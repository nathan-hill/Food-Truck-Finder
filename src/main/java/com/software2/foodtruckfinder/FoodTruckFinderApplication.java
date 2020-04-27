package com.software2.foodtruckfinder;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Scanner;

@SpringBootApplication
public class FoodTruckFinderApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodTruckFinderApplication.class, args);
		System.out.println("Done");
	}
}
