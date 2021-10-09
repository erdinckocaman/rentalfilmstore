package com.casumo.rentalstore.core.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.casumo.rentalstore.core.configuration.RentalStoreCoreAppConfiguration;

@RestController
@RequestMapping(value = "/status", produces = "application/json")
public class StatusResource {
    
    private static Logger logger = LoggerFactory.getLogger(StatusResource.class);

    @Autowired
    private RentalStoreCoreAppConfiguration config;

    @GetMapping(value = "/env", produces = {"plain/text"})
    public String getEnv() {
        return config.getEnv();
    }

}
