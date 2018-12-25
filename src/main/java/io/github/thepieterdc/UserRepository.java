/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * A repository for User entities.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	/**
	 * Gets all users.
	 *
	 * @return all users
	 */
	Collection<User> findAll();
	
	/**
	 * Finds a user given an email address.
	 *
	 * @param email the email address to find
	 * @return the user if any
	 */
	Optional<User> findByEmail(final String email);
}