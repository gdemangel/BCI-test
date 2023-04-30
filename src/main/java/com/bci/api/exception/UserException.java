package com.bci.api.exception;

public class UserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public UserException(String msg, Throwable e) {
		super(msg, e);
	}
	

}
