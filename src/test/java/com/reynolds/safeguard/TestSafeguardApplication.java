package com.reynolds.safeguard;

import org.springframework.boot.SpringApplication;

public class TestSafeguardApplication {

	public static void main(String[] args) {
		SpringApplication.from(SafeguardApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
