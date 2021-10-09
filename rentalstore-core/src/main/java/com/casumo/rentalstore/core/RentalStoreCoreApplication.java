package com.casumo.rentalstore.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalStoreCoreApplication {

	private static Logger logger = LoggerFactory.getLogger(RentalStoreCoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentalStoreCoreApplication.class, args);

		logger.info("Core service started...");

	}

}
