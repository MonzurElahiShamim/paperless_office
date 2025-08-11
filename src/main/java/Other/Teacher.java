package Other;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Monzur Elahi Shamim
 */
public class Teacher {

	private String ID;
	private String NameEn;
	private String NameBn;
	private String mobile;
	private String Designation;
	private String Email;
	private String Dept;

	public Teacher() {
		// Default constructor
	}

	public Teacher(String ID, String NameEn, String NameBn, String mobile, String Designation, String Email, String Dept) {
		this.ID = ID;
		this.NameEn = NameEn;
		this.NameBn = NameBn;
		this.mobile = mobile;
		this.Designation = Designation;
		this.Email = Email;
		this.Dept = Dept;
	}

	// Getters and setters for the fields
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNameEn() {
		return NameEn;
	}

	public void setNameEn(String NameEn) {
		this.NameEn = NameEn;
	}

	public String getNameBn() {
		return NameBn;
	}

	public void setNameBn(String NameBn) {
		this.NameBn = NameBn;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String Designation) {
		this.Designation = Designation;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String Dept) {
		this.Dept = Dept;
	}
}
