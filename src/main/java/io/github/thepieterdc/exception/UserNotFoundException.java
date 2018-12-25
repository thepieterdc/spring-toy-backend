/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc.exception;

/**
 * The requested user was not found.
 */
public final class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -34670051254168594L;
	
	/**
	 * UserNotFoundException constructor.
	 */
	public UserNotFoundException() {
		super("The requested user was not found.");
	}
}
