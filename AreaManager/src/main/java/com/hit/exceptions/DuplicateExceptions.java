package com.hit.exceptions;

@SuppressWarnings("serial")
public class DuplicateExceptions extends RuntimeException{
	public DuplicateExceptions(String message) {
		super(message);
	}
}
