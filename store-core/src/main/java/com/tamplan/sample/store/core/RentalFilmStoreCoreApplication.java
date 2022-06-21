package com.tamplan.sample.store.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RentalFilmStoreCoreApplication {

	private static Logger logger = LoggerFactory.getLogger(RentalFilmStoreCoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentalFilmStoreCoreApplication.class, args);

		logger.info("RentalFilmStore - core service started...");

	}

}
