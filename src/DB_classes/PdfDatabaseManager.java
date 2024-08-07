package DB_classes;

import DB_classes.databaseConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PdfDatabaseManager {

	public static void saveDocAsText(int pdfId, String date, String receipient, String dept, String subj, String body, String type, String status) {
		try (Connection connection = databaseConnection.connection()) {
			String insertQuery = "INSERT INTO doc_as_text (date, receipient, dept, subject, body, type, status, doc_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			// Set values for the prepared statement
			preparedStatement.setString(1, date);
			preparedStatement.setString(2, receipient);
			preparedStatement.setString(3, dept);
			preparedStatement.setString(4, subj);
			preparedStatement.setString(5, body);
			preparedStatement.setString(6, type);
			preparedStatement.setString(7, status);
			preparedStatement.setInt(8, pdfId);

			// Execute the query
			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(PdfDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static String[] retrieveDocAsText(int docId) {
		String[] rowData = null;

		try (Connection connection = databaseConnection.connection()) {
			String selectQuery = "SELECT * FROM doc_as_text WHERE doc_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

			// Set the doc_id parameter in the prepared statement
			preparedStatement.setInt(1, docId);
			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Iterate through the result set and add each row to the resultList
			while (resultSet.next()) {
				rowData = new String[7]; // Assuming 7 columns in the table
				rowData[0] = resultSet.getString("date");
				rowData[1] = resultSet.getString("receipient");
				rowData[2] = resultSet.getString("dept");
				rowData[3] = resultSet.getString("subject");
				rowData[4] = resultSet.getString("body");
				rowData[5] = resultSet.getString("type");
				rowData[6] = resultSet.getString("status");
			}
		} catch (SQLException ex) {
			Logger.getLogger(PdfDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		return rowData;
	}

	public static int savePDFToDatabase(String filePath, String type, String status) {
		int pdfId = -1;
		try (Connection connection = databaseConnection.connection()) {
			String insertQuery = "INSERT INTO pdf_storage (file_path, pdf_name, byte_pdf, type, status) VALUES (?, ?, ?, ?, ?)";

			File pdfFile = new File(filePath);
			String pdfName = pdfFile.getName();
			try (FileInputStream fis = new FileInputStream(pdfFile);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {

				// Set values for the prepared statement
				preparedStatement.setString(1, filePath);
				preparedStatement.setString(2, pdfName);
				preparedStatement.setBinaryStream(3, fis, (int) pdfFile.length());
				preparedStatement.setString(4, type);
				preparedStatement.setString(5, status);

				// Execute the query
				preparedStatement.executeUpdate();
// Retrieve the auto-generated keys (pdf_id)
				try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						pdfId = generatedKeys.getInt(1);
						System.out.println("PDF file saved to database successfully! pdf_id: " + pdfId);
					} else {
						System.out.println("Failed to retrieve the auto-generated pdf_id.");
					}
				}
				System.out.println("PDF file saved to database successfully!");
			}
		} catch (SQLException | java.io.IOException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		return pdfId;
	}

	public static void retrievePdfFromDatabase(int pdfId, String destinationPath) {
		try (Connection connection = databaseConnection.connection()) {
			String sql = "SELECT byte_pdf FROM pdf_storage WHERE pdf_id = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				//int pdfId = 1; // Assuming you want to retrieve PDF with ID 1
				statement.setInt(1, pdfId);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						// Retrieve PDF data as byte array
						byte[] pdfData = resultSet.getBytes("byte_pdf");

						// Save PDF data to a file
						try (FileOutputStream fos = new FileOutputStream(destinationPath)) {
							fos.write(pdfData);
							System.out.println("PDF retrieved and saved successfully.");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("PDF not found in the database.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PdfDatabaseManager pdfManager = new PdfDatabaseManager();

		// Example usage: Saving a PDF to the database
		String filePath = "D:/Shamim.pdf";
		String pdfName = "example.pdf";
		//pdfManager.savePDFToDatabase(filePath, "Notice", "Unread");

		// Example usage: Retrieving a PDF from the database
		int pdfId = 1; // Replace with the actual PDF ID you want to retrieve
		String destinationPath = "D:/Retrieved.pdf";
		pdfManager.retrievePdfFromDatabase(pdfId, destinationPath);
	}
}
