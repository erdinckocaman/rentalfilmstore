package com.casumo.store.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalFilmStoreCoreApplication {

	private static Logger logger = LoggerFactory.getLogger(RentalFilmStoreCoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentalFilmStoreCoreApplication.class, args);

		logger.info("Core service started...");

	}

}
