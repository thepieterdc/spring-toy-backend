/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import io.github.thepieterdc.exception.DuplicateEmailException;
import io.github.thepieterdc.exception.UserNotFoundException;
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
	 * Creates a new user.
	 *
	 * @param data the user data to create a new user from
	 * @return the created user
	 */
	public User create(final User data) {
		this.users.findByEmail(data.getEmail()).ifPresent(u -> {
			throw new DuplicateEmailException();
		});
		
		return this.users.save(data);
	}
	
	/**
	 * Deletes the user with the given id.
	 *
	 * @param id the id of the user to delete
	 */
	public void delete(final Long id) {
		final User user = this.get(id);
		this.users.delete(user);
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
	
	/**
	 * Updates the user with the given id.
	 *
	 * @param id      the id of the user to update
	 * @param newData the data to update the user with
	 * @return the updated user
	 */
	public User update(final Long id, final User newData) {
		final User user = this.get(id);
		
		if (!user.getEmail().equals(newData.getEmail())) {
			this.users.findByEmail(newData.getEmail()).ifPresent(u -> {
				throw new DuplicateEmailException();
			});
		}
		
		return this.users.save(user
			.setBirthday(newData.getBirthday())
			.setEmail(newData.getEmail())
			.setFirstName(newData.getFirstName())
			.setLastName(newData.getLastName())
		);
	}
}
