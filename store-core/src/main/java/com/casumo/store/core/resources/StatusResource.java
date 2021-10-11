package com.casumo.store.core.resources;

import com.casumo.store.core.service.exception.RentalFilmNotFoundException;
import com.casumo.store.lib.spring.StoreHttpResponseEntity;
import com.casumo.store.lib.spring.impl.OkResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.casumo.store.core.configuration.RentalStoreCoreAppConfiguration;

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

    @GetMapping(value = "/test", produces = {"plain/text"})
    public String execTest() {
        throw new RuntimeException("Deneme!!");
    }


    @GetMapping(value = "/test2", produces = {"plain/text"})
    public String execTest2(){
        throw new RentalFilmNotFoundException("Deneme!!");
    }

    @GetMapping(value = "/test3")
    public StoreHttpResponseEntity<String> execTest3(){
        return new OkResponseEntity<>("test result");
    }

}
