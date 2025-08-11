package DB_classes;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class databaseConnection {
    
    public static Connection connection(){
        try{
            Class.forName(DatabaseConfig.getDriver());
            Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(), 
                DatabaseConfig.getUsername(), 
                DatabaseConfig.getPassword()
            );
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
