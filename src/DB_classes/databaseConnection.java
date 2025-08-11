package DB_classes;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class databaseConnection {

    private static final Logger LOGGER = Logger.getLogger(databaseConnection.class.getName());

    public static Connection connection(){
        try{
            Class.forName(DatabaseConfig.getDriver());
            Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword()
            );
            return conn;
        } catch(ClassNotFoundException | SQLException e){
            // In headless test environments JOptionPane will throw HeadlessException
            if (!GraphicsEnvironment.isHeadless()) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            }
            LOGGER.log(Level.SEVERE, "Database connection failure", e);
            return null;
        }
    }
}
