package Other;

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
	private String stNameEn;
	private String stNameBn;
	private String fatherNameEn;
	private String fatherNameBn;
	private String mobile;
	private String session;
	private String instEmail;
	private String personEmail;

	public UserInfo() {
		// Default constructor
	}

	public UserInfo(String stId, String stNameEn, String stNameBn, String fatherNameEn, String fatherNameBn,
		String mobile, String session, String instEmail, String personEmail) {
		this.stId = stId;
		this.stNameEn = stNameEn;
		this.stNameBn = stNameBn;
		this.fatherNameEn = fatherNameEn;
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

	public String getStNameEn() {
		return stNameEn;
	}

	public void setStNameEn(String stNameEn) {
		this.stNameEn = stNameEn;
	}

	public String getStNameBn() {
		return stNameBn;
	}

	public void setStNameBn(String stNameBn) {
		this.stNameBn = stNameBn;
	}

	public String getFatherNameEn() {
		return fatherNameEn;
	}

	public void setFatherNameEn(String fatherNameEn) {
		this.fatherNameEn = fatherNameEn;
	}
	public String getFatherNameBn() {
		return fatherNameBn;
	}

	public void setFatherNameBn(String fatherNameBn) {
		this.fatherNameBn = fatherNameBn;
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
