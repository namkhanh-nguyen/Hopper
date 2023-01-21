package com.hopper;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Program will persistently act as a server as long as the computer is running
 */

@Theme(value = "my-theme")
@SpringBootApplication
public class HopperApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(HopperApplication.class, args);
	}

}
