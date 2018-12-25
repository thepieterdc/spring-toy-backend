/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc.exception;

/**
 * A duplicate email address was provided.
 */
public final class DuplicateEmailException extends RuntimeException {
	private static final long serialVersionUID = -4760018599631798071L;
	
	/**
	 * DuplicateEmailException constructor.
	 */
	public DuplicateEmailException() {
		super("This email address is already in use.");
	}
}
