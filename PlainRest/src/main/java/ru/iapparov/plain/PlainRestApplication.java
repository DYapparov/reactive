package ru.iapparov.plain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.iapparov.plain")
public class PlainRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlainRestApplication.class, args);
	}

}
