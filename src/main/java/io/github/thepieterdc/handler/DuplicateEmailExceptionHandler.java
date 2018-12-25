/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc.handler;

import io.github.thepieterdc.exception.DuplicateEmailException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

/**
 * Handles DuplicateEmailExceptions.
 */
@RestControllerAdvice
public final class DuplicateEmailExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * DuplicateEmailExceptionHandler constructor.
	 */
	@ExceptionHandler(DuplicateEmailException.class)
	public static ResponseEntity<Object> handle(final DuplicateEmailException ex) {
		final ErrorField error = new ErrorField("email", "AlreadyExists");
		
		return ResponseEntity.unprocessableEntity().body(Collections.singleton(error));
	}
}
