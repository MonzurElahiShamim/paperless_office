package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceManager {
    
    public static void closeQuietly(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // Log error silently
            }
        }
    }
    
    public static void closeQuietly(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // Log error silently
            }
        }
    }
    
    public static void closeQuietly(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // Log error silently
            }
        }
    }
    
    public static void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeQuietly(rs);
        closeQuietly(stmt);
        closeQuietly(conn);
    }
}