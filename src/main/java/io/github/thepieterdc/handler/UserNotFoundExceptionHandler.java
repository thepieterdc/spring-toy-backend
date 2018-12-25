/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc.handler;

import io.github.thepieterdc.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Handles UserNotFoundExceptions.
 */
@RestControllerAdvice
public final class UserNotFoundExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * UserNotFoundExceptionHandler constructor.
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public static ResponseEntity<Object> handle(final UserNotFoundException ex) {
		return ResponseEntity.notFound().build();
	}
}
