package com.example.springboot_mysql_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMysqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMysqlDemoApplication.class, args);
		// Models - Class representing each of our entities which are mapped to DB storage (SQL table)
		// Repositories - Data access layer - JPA repository has preset CRUD method to allow direc IO on DB

		// Controllers - Handling HTTP requests - orchestrating the operations (talking to services,
		// getting data back and sending responcesto clients)
		// Services	- Business Logic - data processing, cleaning, validation,...

		// We want to build an API for users to give movies ratings
		// one user can rate multiple movies
		// one movie can have multiple ratings
		// A rating is specific to a user and to a movie

		// Client -> Controllers -> Services -> Repos -> DB
	}
}
