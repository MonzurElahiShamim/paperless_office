package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties props = new Properties();
    
    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader()
                .getResourceAsStream("database.properties")) {
            if (input != null) {
                props.load(input);
            }
        } catch (IOException e) {
            // Fallback to default values
            props.setProperty("db.url", "jdbc:mysql://localhost:3306/paperless_office");
            props.setProperty("db.username", "root");
            props.setProperty("db.password", "");
            props.setProperty("db.driver", "com.mysql.cj.jdbc.Driver");
        }
    }
    
    public static String getUrl() {
        return System.getProperty("db.url", props.getProperty("db.url"));
    }

    public static String getUsername() {
        return System.getProperty("db.username", props.getProperty("db.username"));
    }

    public static String getPassword() {
        return System.getProperty("db.password", props.getProperty("db.password"));
    }

    public static String getDriver() {
        return System.getProperty("db.driver", props.getProperty("db.driver"));
    }
}