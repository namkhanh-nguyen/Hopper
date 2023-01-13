package com.hopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Program will persistently act as a server as long as the computer is running
 */
@SpringBootApplication
public class HopperApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopperApplication.class, args);
	}

}
