package DB_classes;


import DB_classes.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataValidate {

    public static boolean isStudentIdExists(String stId) {
        String query = "SELECT * FROM student WHERE st_id = ?";
        try (Connection connection = databaseConnection.connection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, stId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if stId exists in the database, false otherwise
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Handle the exception as per your application's requirements
        }
    }

    public static boolean isEmailExists(String email) {
        String query = "SELECT * FROM student WHERE eduEmail = ? OR (personalEmail = ? AND personalEmail IS NOT NULL)";
        try (Connection connection = databaseConnection.connection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if email exists in the database, false otherwise
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Handle the exception as per your application's requirements
        }
    }

    public static void validateStudentData(String nameEn, String nameBn, String fatherEn, String fatherBn, String mobile, String stId,
            String session, String instEmail, String personEmail, String password1, String password2) {

        // Format: Three uppercase letters, two digits, two digits, three digits, 'M' or 'F'
        String stIdRegex = "^[A-Z]{3}\\d{2}\\d{2}\\d{3}[MF]$";

        // Check if any of the required fields are empty
        if (nameEn.equals("") || nameBn.equals("") || fatherEn.equals("") || fatherBn.equals("") || mobile.equals("") || stId.equals("")
                || session.equals("") || (instEmail.equals("") && personEmail.equals("")) || password1.equals("")
                || password2.equals("")) {
            JOptionPane.showMessageDialog(null, "Fill up all fields");
        } // Validate the mobile number format
        else if (!mobile.matches("^01\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "Invalid mobile number.");
        } // Validate the session format (e.g., '2018-19')
        else if (!session.matches("^\\d{4}-\\d{2}$")) {
            JOptionPane.showMessageDialog(null, "Invalid session format. Please enter a valid session in the format 'YYYY-YY', like '2018-19'.");
        } // Validate the student ID format (e.g., 'ASH1911012M' or 'MUH1911011F')
        else if (!stId.matches(stIdRegex)) {
            JOptionPane.showMessageDialog(null, "Invalid student ID format. Please enter a valid student ID like 'ASH1911012M' or 'MUH1911011F'.");
        } // Validate institutional email format (must end with '@student.nstu.edu.bd')
        else if (!instEmail.endsWith("@student.nstu.edu.bd")) {
            JOptionPane.showMessageDialog(null, "Institutional email must end with '@student.nstu.edu.bd'.");
        } // Check if the student ID already exists in the database
        else if (isStudentIdExists(stId)) {
            JOptionPane.showMessageDialog(null, "Student ID already exists.");
        } // Check if the provided email address (institutional or personal) already exists in the database
        else if (isEmailExists(instEmail) || isEmailExists(personEmail)) {
            JOptionPane.showMessageDialog(null, "Email address already exists.");
        } // Check if passwords match
        else if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(null, "Password does not match!");
        } // Check if the password is at least 8 characters long
        else if (password1.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
        } // If all validations pass, insert data into the database
        else {
            DatabaseOperations.insertDataIntoDatabase(stId, nameEn, nameBn, fatherEn, fatherBn, mobile, session, instEmail, personEmail, password1);
        }

    }

    

}
