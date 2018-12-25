/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("userService")
public class UserService {
	private final UserRepository users;
	
	/**
	 * UserService constructor.
	 *
	 * @param userRepository auto injected user repository
	 */
	@Autowired
	public UserService(final UserRepository userRepository) {
		this.users = userRepository;
	}
	
	/**
	 * Gets the user with the given id.
	 *
	 * @param id the id of the user to retrieve
	 * @return the user
	 */
	public User get(final Long id) {
		return this.users.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	/**
	 * Gets all users.
	 *
	 * @return all users
	 */
	public Collection<User> listAll() {
		return this.users.findAll();
	}
}
