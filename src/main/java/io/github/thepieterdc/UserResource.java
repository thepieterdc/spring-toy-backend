/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

/**
 * Resource representation for User entities.
 */
public final class UserResource {
	@JsonProperty
	private final String url;
	
	@JsonUnwrapped
	private final User user;
	
	/**
	 * UserResource constructor.
	 *
	 * @param user the user
	 */
	private UserResource(final User user) {
		this.url = ControllerLinkBuilder.linkTo(UserController.class).slash(user.getId()).withSelfRel().getHref();
		this.user = user;
	}
	
	/**
	 * Wraps the user entity in its resource representation.
	 *
	 * @param user the user
	 * @return resource representation
	 */
	public static UserResource wrap(final User user) {
		return new UserResource(user);
	}
}
