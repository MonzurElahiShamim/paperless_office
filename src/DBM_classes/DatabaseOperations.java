package DBM_classes;


import DBM_classes.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class DatabaseOperations {
    
    static void insertDataIntoDatabase(String stId, String fName, String lName, String father, String mobile,
            String session, String instEmail, String personEmail, String password) {
        try (Connection connection = databaseConnection.connection()) {
            String query = "INSERT INTO student (st_id, firstName, lastName, fatherName, mobile, session, eduEmail, personalEmail, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, stId);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setString(4, father);
            preparedStatement.setString(5, mobile);
            preparedStatement.setString(6, session);
            preparedStatement.setString(7, instEmail);
            preparedStatement.setString(8, personEmail);
            preparedStatement.setString(9, password);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registered successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public static void updateStudentData(String stId, String fatherName,
                                         String mobile, String session, String personalEmail) {
        String updateQuery = "UPDATE student SET fatherName=?, mobile=?, " +
                             "session=?, personalEmail=? WHERE st_id=?";
        
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
}

