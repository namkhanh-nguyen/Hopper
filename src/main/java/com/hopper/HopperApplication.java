package com.hopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HopperApplication {

	/**
	 * Program will run persistently as a server as long as the computer is up
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(HopperApplication.class, args);
	}

}
