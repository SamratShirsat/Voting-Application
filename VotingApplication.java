package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class VotingApplication {


	public static void main(String[] args) {
		SpringApplication.run(VotingApplication.class, args);
	}

}
