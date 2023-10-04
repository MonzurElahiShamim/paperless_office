/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Monzur Elahi Shamim
 */
public class UserInfo {
    private String stId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String mobile;
    private String session;
    private String instEmail;
    private String personEmail;

    public UserInfo() {
        // Default constructor
    }

    public UserInfo(String stId, String firstName, String lastName, String fatherName,
                    String mobile, String session, String instEmail, String personEmail) {
        this.stId = stId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.mobile = mobile;
        this.session = session;
        this.instEmail = instEmail;
        this.personEmail = personEmail;
    }

    // Getters and setters for the fields

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getInstEmail() {
        return instEmail;
    }

    public void setInstEmail(String instEmail) {
        this.instEmail = instEmail;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }
}

