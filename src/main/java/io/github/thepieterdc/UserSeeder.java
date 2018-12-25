/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

/**
 * Seeds the users.
 */
@Component
public class UserSeeder implements ApplicationRunner {
	private final UserRepository users;
	
	/**
	 * UserSeeder constructor.
	 *
	 * @param users auto injected user repository
	 */
	@Autowired
	public UserSeeder(final UserRepository users) {
		this.users = users;
	}
	
	@Override
	public void run(final ApplicationArguments args) {
		final Collection<User> seeds = Arrays.asList(
			new User("thepieterdc@github.io", "Pieter", "De Clercq", LocalDate.of(1997, Month.AUGUST, 21)),
			new User("john.smith@mail.com", "John", "Smith", LocalDate.now())
		);
		
		this.users.saveAll(seeds);
	}
}
