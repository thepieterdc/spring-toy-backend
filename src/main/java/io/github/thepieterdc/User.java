/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Locale;

/**
 * User model.
 */
@Entity
public class User implements Identifiable<Long> {
	private @PastOrPresent LocalDate birthday;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Instant createdAt;
	
	@Column(unique = true)
	private String email;
	
	private String firstName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String lastName;
	
	/**
	 * User constructor.
	 *
	 * @param email     the email address
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param birthday  the birthday
	 */
	public User(final String email, final String firstName, final String lastName, final LocalDate birthday) {
		this.birthday = birthday;
		this.setEmail(email);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * User constructor.
	 */
	protected User() {
		//jpa
	}
	
	/**
	 * Gets the birthday of the user.
	 *
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return this.birthday;
	}
	
	/**
	 * Gets the creation timestamp.
	 *
	 * @return the creation timestamp
	 */
	public Instant getCreatedAt() {
		return this.createdAt;
	}
	
	/**
	 * Gets the email address of the user.
	 *
	 * @return the email address
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Gets the first name of the user.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Gets the first name of the user.
	 *
	 * @return the first name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Sets the birthday.
	 *
	 * @param nw the new birthday to set
	 * @return fluent
	 */
	public User setBirthday(final LocalDate nw) {
		this.birthday = nw;
		return this;
	}
	
	/**
	 * Sets the email address.
	 *
	 * @param nw the new email address to set
	 * @return fluent
	 */
	public User setEmail(final String nw) {
		this.email = nw.toLowerCase(Locale.getDefault());
		return this;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param nw the new first name to set
	 * @return fluent
	 */
	public User setFirstName(final String nw) {
		this.firstName = nw;
		return this;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param nw the new last name to set
	 * @return fluent
	 */
	public User setLastName(final String nw) {
		this.lastName = nw;
		return this;
	}
}
