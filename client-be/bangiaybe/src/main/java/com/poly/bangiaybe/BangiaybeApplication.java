package com.poly.bangiaybe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BangiaybeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BangiaybeApplication.class, args);
	}

}
