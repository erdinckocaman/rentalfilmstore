package com.casumo.rentalstore.core.resources;

import com.casumo.rentalstore.core.resources.model.RentalFilmRequest;
import com.casumo.rentalstore.core.resources.model.RentalFilmReturnRequest;
import com.casumo.rentalstore.core.service.RentalFilmService;
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
    public BigDecimal calculatePriceToRentFilms(@RequestBody  RentalFilmRequest rentalFilmRequest) {
        return rentalFilmService.calculatePriceToRentFilms(rentalFilmRequest.getCodes(), rentalFilmRequest.getDays());
    }

    @PostMapping(value = "/return")
    public BigDecimal calculatePriceToReturnFilms(@RequestBody  RentalFilmReturnRequest rentalFilmReturnRequest) {
        return rentalFilmService.calculatePriceToReturnFilms(rentalFilmReturnRequest.getCodes());
    }

}
