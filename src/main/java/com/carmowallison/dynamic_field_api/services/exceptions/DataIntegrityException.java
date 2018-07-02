package com.carmowallison.dynamic_field_api.services.exceptions;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException (String msg, Throwable cause) {
		super(msg,cause);
	}

}
