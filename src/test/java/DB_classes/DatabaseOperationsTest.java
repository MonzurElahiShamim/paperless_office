package DB_classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseOperationsTest {
    
    @BeforeEach
    void setUp() throws Exception {
    // Ensure system properties for DatabaseConfig filtering (in case resource filtering didn't substitute)
    System.setProperty("db.url", "jdbc:h2:mem:paperless;DB_CLOSE_DELAY=-1;MODE=MySQL");
    System.setProperty("db.username", "sa");
    System.setProperty("db.password", "");
    System.setProperty("db.driver", "org.h2.Driver");

    String url = System.getProperty("db.url");
    String user = System.getProperty("db.username");
    String pass = System.getProperty("db.password");
    Class.forName(System.getProperty("db.driver"));
        try (Connection conn = DriverManager.getConnection(url, user, pass); Statement st = conn.createStatement()) {
            // Drop existing tables to ensure clean state
            try { st.execute("DROP TABLE IF EXISTS student"); } catch (Exception ignore) {}
            try { st.execute("DROP TABLE IF EXISTS teacher"); } catch (Exception ignore) {}

            // Execute schema
            String schema = new String(Files.readAllBytes(Paths.get("src/test/resources/schema.sql")), "UTF-8");
            for (String sql : schema.split(";")) {
                String trimmed = sql.trim();
                if (!trimmed.isEmpty()) {
                    st.execute(trimmed);
                }
            }
            // Seed data
            String data = new String(Files.readAllBytes(Paths.get("src/test/resources/data.sql")), "UTF-8");
            for (String sql : data.split(";")) {
                String trimmed = sql.trim();
                if (!trimmed.isEmpty()) {
                    st.execute(trimmed);
                }
            }
        }
    }
    
    @Test
    void testRetrieveUserDataFromDatabase_ValidEmail_ReturnsUser() {
        String testEmail = "test@example.com";
        Other.UserInfo result = assertDoesNotThrow(() -> DatabaseOperations.retrieveUserDataFromDatabase(testEmail));
        assertNotNull(result, "Expected a user for test email");
        assertEquals("S001", result.getStId());
        assertEquals("Test Student", result.getStNameEn());
    }
    
    @Test
    void testRetrieveUserDataFromDatabase_InvalidEmail_ReturnsNull() {
        String invalidEmail = "nonexistent@example.com";
        Other.UserInfo result = assertDoesNotThrow(() -> DatabaseOperations.retrieveUserDataFromDatabase(invalidEmail));
        assertNull(result, "Expected null for unknown email");
    }
}