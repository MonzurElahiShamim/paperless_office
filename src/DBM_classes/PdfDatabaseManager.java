package DBM_classes;

import DBM_classes.databaseConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PdfDatabaseManager {

    public static void savePDFToDatabase(String filePath, String type, String status) {
        try (Connection connection = databaseConnection.connection()) {
            String insertQuery = "INSERT INTO pdf_storage (file_path, pdf_name, byte_pdf, type, status) VALUES (?, ?, ?, ?, ?)";

            File pdfFile = new File(filePath);
            String pdfName = pdfFile.getName();
            try (FileInputStream fis = new FileInputStream(pdfFile);
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                // Set values for the prepared statement
                preparedStatement.setString(1, filePath);
                preparedStatement.setString(2, pdfName);
                preparedStatement.setBinaryStream(3, fis, (int) pdfFile.length());
                preparedStatement.setString(4, type);
                preparedStatement.setString(5, status);

                // Execute the query
                preparedStatement.executeUpdate();

                System.out.println("PDF file saved to database successfully!");
            }
        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
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
