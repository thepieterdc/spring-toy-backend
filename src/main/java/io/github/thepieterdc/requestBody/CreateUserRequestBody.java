/*
 * Copyright (c) 2018 - Singular-IT. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Julie De Meyer
 * @author Robbe Vanhaesebroeck
 *
 * https://www.limpio.online/
 */
package io.github.thepieterdc.requestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * Request body to create a user.
 */
public final class CreateUserRequestBody {
	private final @NotNull @PastOrPresent LocalDate birthday;
	
	private final @NotBlank @Email String email;
	
	private final @NotBlank String firstName;
	
	private final @NotBlank String lastName;
	
	/**
	 * CreateUserRequestBody constructor.
	 *
	 * @param birthday  the birthday
	 * @param email     the email address
	 * @param firstName the first name
	 * @param lastName  the last name
	 */
	public CreateUserRequestBody(@JsonProperty("birthday") final LocalDate birthday,
	                             @JsonProperty("email") final String email,
	                             @JsonProperty("firstName") final String firstName,
	                             @JsonProperty("lastName") final String lastName) {
		this.birthday = birthday;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Accessor for the birthday.
	 *
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return this.birthday;
	}
	
	/**
	 * Accessor for the email address.
	 *
	 * @return the email address
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Accessor for the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Accessor for the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Creates a user from this request body.
	 *
	 * @return the created user
	 */
	public User toUser() {
		return new User(this.email, this.firstName, this.lastName, this.birthday);
	}
}
