package com.cg.jcat.api.exception;

import java.util.Date;

import com.cg.jcat.api.exception.entity.ErrorDTO;

public class SaveUserException extends JcatExceptions{
	
	private static String error_code = "UE101";
	private static String error_message = "User with name already exists can't assign name to someone else";
	private static Date error_timestamp = new Date();
    private static String error_details ;
	public SaveUserException() {
		super();
	}
    
	public SaveUserException(String error_value) {
		super(new ErrorDTO(error_code,error_message, error_value,error_timestamp,error_details));
	}

}
