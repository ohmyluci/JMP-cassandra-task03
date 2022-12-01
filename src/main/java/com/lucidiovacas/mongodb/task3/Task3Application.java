package com.lucidiovacas.mongodb.task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class Task3Application {

	public static void main(String[] args) {

		SpringApplication.run(Task3Application.class, args);

	}

}
