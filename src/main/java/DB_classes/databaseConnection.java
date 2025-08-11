package DB_classes;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class databaseConnection {

    private static final Logger LOGGER = Logger.getLogger(databaseConnection.class.getName());

    public static Connection connection(){
        try {
            Class.forName(DatabaseConfig.getDriver());
            return DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Database connection failure", e);
            return null;
        }
    }
}
