package com.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "tweet app"))
public class TweetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetAppApplication.class, args);
	}

}
