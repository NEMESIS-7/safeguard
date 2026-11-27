package com.reynolds.safeguard;

import com.reynolds.safeguard.shared.config.DotenvInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafeguardApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SafeguardApplication.class);
		application.addInitializers(new DotenvInitializer());
		application.run(args);
	}

}
