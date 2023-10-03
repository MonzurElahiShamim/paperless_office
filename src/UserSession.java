/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Monzur Elahi Shamim
 */
public class UserSession {
    private static UserSession instance;
    private String userEmail; // Session data (in this case, the userEmail)

    private UserSession() {
        // Private constructor to prevent instantiation from other classes
    }

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUser() {
        return userEmail;
    }

    public void clearSession() {
        userEmail = null;
    }

    public boolean isAuthenticated() {
        return userEmail != null;
    }
}

