package com.tm.evaluationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EvaluationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationSystemApplication.class, args);
	}

}
