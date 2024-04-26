package DB_classes;

import DB_classes.databaseConnection;
import Other.Teacher;
import Other.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class DatabaseOperations {

	static void insertDataIntoDatabase(String stId, String nameEn, String nameBn, String fatherEn, String fatherBn, String mobile,
		String session, String instEmail, String personEmail, String password) {
		try (Connection connection = databaseConnection.connection()) {
			String query = "INSERT INTO student (st_id, firstName, lastName, fatherNameEn, mobile, session, eduEmail, personalEmail, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, stId);
			preparedStatement.setString(2, nameEn);
			preparedStatement.setString(3, nameBn);
			preparedStatement.setString(4, fatherEn);
			preparedStatement.setString(5, fatherBn);
			preparedStatement.setString(6, mobile);
			preparedStatement.setString(7, session);
			preparedStatement.setString(8, instEmail);
			preparedStatement.setString(9, personEmail);
			preparedStatement.setString(10, password);

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registered successfully!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	public static void updateStudentData(String stId, String fatherName,
		String mobile, String session, String personalEmail) {
		String updateQuery = "UPDATE student SET fatherName=?, mobile=?, "
			+ "session=?, personalEmail=? WHERE st_id=?";

		try (Connection connection = databaseConnection.connection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			preparedStatement.setString(1, fatherName);
			preparedStatement.setString(2, mobile);
			preparedStatement.setString(3, session);
			preparedStatement.setString(4, personalEmail);
			preparedStatement.setString(5, stId);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Student data updated successfully!");
			} else {
				System.out.println("No rows were updated.");
			}
		} catch (SQLException e) {
			System.out.println("Error updating student data: " + e.getMessage());
		}
	}

	public static UserInfo retrieveUserDataFromDatabase(String email) {
		UserInfo user = null;
		try (Connection connection = databaseConnection.connection()) {
			String query = "SELECT * FROM student WHERE eduEmail = ? OR personalEmail = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new UserInfo();
				user.setStId(resultSet.getString("st_id"));
				user.setStNameEn(resultSet.getString("stNameEn"));
				user.setStNameBn(resultSet.getString("stNameBn"));
				user.setFatherNameEn(resultSet.getString("fatherNameEn"));
				user.setFatherNameBn(resultSet.getString("fatherNameBn"));
				user.setMobile(resultSet.getString("mobile"));
				user.setSession(resultSet.getString("session"));
				user.setInstEmail(resultSet.getString("eduEmail"));
				user.setPersonEmail(resultSet.getString("personalEmail"));
				// Retrieve other fields as needed
			}

			resultSet.close();
			preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Handle the exception properly (logging, error message, etc.)
		}
		return user;
	}
	
	public static Teacher retrieveTeacherDataFromDatabase(String email) {
		Teacher teacher = null;
		try (Connection connection = databaseConnection.connection()) {
			String query = "SELECT * FROM teacher WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				teacher = new Teacher();
				teacher.setID(resultSet.getString("id"));
				teacher.setNameEn(resultSet.getString("nameEn"));
				teacher.setNameBn(resultSet.getString("nameBn"));
				teacher.setMobile(resultSet.getString("mobile"));
				teacher.setDesignation(resultSet.getString("designation"));
				teacher.setEmail(resultSet.getString("email"));
				teacher.setDept(resultSet.getString("dept"));
				// Retrieve other fields as needed
			}

			resultSet.close();
			preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Handle the exception properly (logging, error message, etc.)
		}
		return teacher;
	}
	
	public static void updateTeacherData(String NameEn, String NameBn, String Designation,
		String Mobile, String Dept, String Email) {
		String updateQuery = "UPDATE teacher SET nameEn=?, nameBn=?, designation=?, mobile=?, "
			+ "dept=?  WHERE email=?";

		try (Connection connection = databaseConnection.connection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			preparedStatement.setString(1, NameEn);
			preparedStatement.setString(2, NameBn);
			preparedStatement.setString(3, Designation);
			preparedStatement.setString(4, Mobile);
			preparedStatement.setString(5, Dept);
			preparedStatement.setString(6, Email);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Teacher data updated successfully!");
			} else {
				System.out.println("No rows were updated.");
			}
		} catch (SQLException e) {
			System.out.println("Error updating student data: " + e.getMessage());
		}
	}
}
