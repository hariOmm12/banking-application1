package com.example.demo.dao;

public class NotificationDTO {
    private String email;
    private String type;
    private Double amount;
    
	public NotificationDTO(String email, String type, Double amount) {
		super();
		this.email = email;
		this.type = type;
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
  
}
