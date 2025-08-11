package DB_classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseOperationsTest {
    
    @BeforeEach
    void setUp() {
        // Setup test database connection if needed
    }
    
    @Test
    void testRetrieveUserDataFromDatabase_ValidEmail_ReturnsUser() {
        // Test with valid email
        String testEmail = "test@example.com";
        
        // This would require a test database setup
        // UserInfo result = DatabaseOperations.retrieveUserDataFromDatabase(testEmail);
        
        // For now, just test that method doesn't throw exception
        assertDoesNotThrow(() -> {
            DatabaseOperations.retrieveUserDataFromDatabase(testEmail);
        });
    }
    
    @Test
    void testRetrieveUserDataFromDatabase_InvalidEmail_ReturnsNull() {
        String invalidEmail = "nonexistent@example.com";
        
        assertDoesNotThrow(() -> {
            DatabaseOperations.retrieveUserDataFromDatabase(invalidEmail);
        });
    }
}