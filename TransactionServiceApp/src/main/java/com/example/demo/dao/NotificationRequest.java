package com.example.demo.dao;

public class NotificationRequest {
	
	private String email;
    private String subject;
    private String message;
 
	public NotificationRequest(String email, String subject, String message) {
		super();
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
    
    

}
