package com.gymManagement.GymMotivation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GymMotivationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymMotivationApplication.class, args);
	}

}
