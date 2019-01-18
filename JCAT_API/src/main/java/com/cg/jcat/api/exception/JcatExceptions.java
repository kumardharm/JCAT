package com.cg.jcat.api.exception;

public class JcatExceptions extends Exception{

	/**
	 * 
	 */
	private static String ExceptionMessage;
	private static final long serialVersionUID = -8302425943271138598L;

	public JcatExceptions() {
		super();
		
	}

	public JcatExceptions(String message) {
		
		this.ExceptionMessage=message;
	}
	
	

}
