/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import static io.github.thepieterdc.UserController.ENDPOINT_USERS;

/**
 * A controller for User entities.
 */
@RestController
@RequestMapping(value = ENDPOINT_USERS, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	public static final String ENDPOINT_USERS = "/users";
	
	private final UserService users;
	
	/**
	 * UserController constructor.
	 *
	 * @param users auto injected user service
	 */
	@Autowired
	public UserController(final UserService users) {
		this.users = users;
	}
	
	/**
	 * Gets the user with the given id.
	 *
	 * @param id the id of the user to get
	 * @return a list of all users
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserResource> get(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(UserResource.wrap(this.users.get(id)));
	}
	
	/**
	 * Gets a list of all users.
	 *
	 * @return a list of all users
	 */
	@GetMapping
	public ResponseEntity<Collection<UserResource>> list() {
		return ResponseEntity.ok(this.users.listAll().stream().map(UserResource::wrap).collect(Collectors.toSet()));
	}
}
