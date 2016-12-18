package model;

public class Email {

	private int id;
	private int rec;
	private int exp;
	private String subject;
	private String message;
	private int attachments;
	private String status;
	
	public Email(int id, int exp, int rec, String subject, String message, int attach, String status){
		this.id = id;
		this.exp = exp;
		this.setRec(rec);
		this.subject = subject;
		this.message= message;
		this.attachments = attach;
	}
	public Email(){
		this.id = 0;
		this.exp = 0;
		this.rec = 0;
		this.subject = "Subject";
		this.message= "Message";
		this.attachments = 0;
		this.status = "Unread";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public int getRec() {
		return rec;
	}
	public void setRec(int rec) {
		this.rec = rec;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getAttachments() {
		return attachments;
	}
	public void setAttachments(int attachments) {
		this.attachments = attachments;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
