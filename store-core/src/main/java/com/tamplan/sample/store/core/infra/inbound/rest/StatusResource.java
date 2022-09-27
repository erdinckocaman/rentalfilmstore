package com.tamplan.sample.store.core.infra.inbound.rest;

import com.tamplan.sample.store.core.configuration.RentalStoreCoreAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatusResource {

    @Autowired
    private RentalStoreCoreAppConfiguration config;

    @GetMapping(value = "/env", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getEnv() {
        return config.getEnv();
    }

}
