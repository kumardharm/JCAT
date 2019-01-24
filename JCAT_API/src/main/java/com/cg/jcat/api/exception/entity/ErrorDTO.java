package com.cg.jcat.api.exception.entity;

import java.util.Date;

public class ErrorDTO {
	
//	CRE_CART_INCOMPLETE_BODY(400,"E001","Incomplete request body","");
	
	private String error_code;
	private String error_message;
	private String error_value;
	private Date error_timestamp;
	private String error_details;
	
	public ErrorDTO(String error_code, String error_message, String error_value, Date error_timestamp, String error_details) {
		this.error_code=error_code;
		this.error_message=error_message;
		this.error_value=error_value;
		this.error_timestamp=error_timestamp;
		this.error_details=error_details;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public String getError_value() {
		return error_value;
	}
	public void setError_value(String error_value) {
		this.error_value = error_value;
	}
	
	
	public Date getError_timestamp() {
		return error_timestamp;
	}
	public void setError_timestamp(Date error_timestamp) {
		this.error_timestamp = error_timestamp;
	}
	
	public String getError_details() {
		return error_details;
	}
	public void setError_details(String error_details) {
		this.error_details = error_details;
	}
	@Override
	public String toString() {
		return "ErrorDTO [error_code=" + error_code + ", error_message=" + error_message + ", error_value="
				+ error_value + ", error_timestamp=" + error_timestamp + ", error_details=" + error_details + "]";
	}
	
	
	
	

}
