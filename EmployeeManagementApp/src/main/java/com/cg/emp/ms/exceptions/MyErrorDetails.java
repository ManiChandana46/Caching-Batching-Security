package com.cg.emp.ms.exceptions;

import java.io.Serializable;
import java.util.Date;

public class MyErrorDetails implements Serializable {

	private Date timeStamp;
	private String message;
	private String details;
	
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public MyErrorDetails(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
}
