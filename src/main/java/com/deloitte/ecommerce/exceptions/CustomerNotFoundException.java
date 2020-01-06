package com.deloitte.ecommerce.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
