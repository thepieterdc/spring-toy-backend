/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc.handler;

/**
 * DTO representing invalid field values.
 */
public final class ErrorField {
	private final String error;
	private final String field;
	
	/**
	 * ErrorField constructor.
	 *
	 * @param field the name of the field
	 * @param error the error message
	 */
	ErrorField(final String field, final String error) {
		this.error = error;
		this.field = field;
	}
	
	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getError() {
		return this.error;
	}
	
	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public String getField() {
		return this.field;
	}
}
