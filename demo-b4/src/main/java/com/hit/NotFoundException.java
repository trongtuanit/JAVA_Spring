package com.hit;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException{
	
	public NotFoundException(String message) {
		super(message);
	}
}