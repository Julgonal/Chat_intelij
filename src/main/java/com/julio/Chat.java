package com.julio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication(scanBasePackages = {
		"com.julio.config",
		"com.julio.controller",
		"com.julio.models",
		"com.julio.services",
})
@EnableMongoRepositories(basePackages =
		"com.julio.repositories")
public class Chat {
	public static void main(String[] args) {
		SpringApplication.run(Chat.class, args);
	}
}