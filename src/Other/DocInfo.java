package Other;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Monzur Elahi Shamim
 */
public class DocInfo {

	private String docID;
	private String docName;
	private String creationDate;
	private String receipient;
	private String recpDept;
	private String subject;
	private String body;
	private String pdfPath;
	private String type;
	private String status;

	public DocInfo() {
		// Default constructor
	}

	public DocInfo(String docID, String docName, String creationDate, String receipient, String subject, String body,
		String pdfPath, String recpDept, String type, String status) {
		this.docID = docID;
		this.docName = docName;
		this.creationDate = creationDate;
		this.receipient = receipient;
		this.recpDept = recpDept;
		this.subject = subject;
		this.body = body;
		this.pdfPath = pdfPath;
		this.type = type;
		this.status = status;
	}

	// Getters and setters for the fields
	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String receipient) {
		this.receipient = receipient;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getRecpDept() {
		return recpDept;
	}

	public void setRecpDept(String recpDept) {
		this.recpDept = recpDept;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
