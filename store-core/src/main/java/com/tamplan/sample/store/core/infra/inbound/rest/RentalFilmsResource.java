package com.tamplan.sample.store.core.infra.inbound.rest;

import com.tamplan.sample.store.core.infra.inbound.rest.model.RentalFilmRequest;
import com.tamplan.sample.store.core.infra.inbound.rest.model.RentalFilmReturnRequest;
import com.tamplan.sample.store.core.service.RentalFilmService;
import com.tamplan.sample.store.lib.spring.impl.OkResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/rentalfilms", produces = "application/json", consumes = "application/json")
public class RentalFilmsResource {
    
    private static Logger logger = LoggerFactory.getLogger(RentalFilmsResource.class);

    @Autowired
    RentalFilmService rentalFilmService;

    @PostMapping(value = "/rent")
    public OkResponseEntity<BigDecimal> calculatePriceToRentFilms(@RequestBody RentalFilmRequest rentalFilmRequest) {
        return new OkResponseEntity(rentalFilmService.calculatePriceToRentFilms(rentalFilmRequest.getCodes(), rentalFilmRequest.getDays()));
    }

    @PostMapping(value = "/return")
    public OkResponseEntity<BigDecimal> calculatePriceToReturnFilms(@RequestBody RentalFilmReturnRequest rentalFilmReturnRequest) {
        return new OkResponseEntity(rentalFilmService.calculatePriceToReturnFilms(rentalFilmReturnRequest.getCodes()));
    }

}
