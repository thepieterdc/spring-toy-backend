/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/spring-toy-backend
 */
package io.github.thepieterdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the application.
 */
@SpringBootApplication
public class BackendApplication {

    /**
     * Main function.
     *
     * @param args commandline arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
