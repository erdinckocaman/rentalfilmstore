package com.casumo.rentalstore.core.service;

import com.casumo.rentalstore.core.domain.*;
import com.casumo.rentalstore.core.repository.RentalFilmDetailsRepository;
import com.casumo.rentalstore.core.repository.RentalFilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

public class RentalFilmService {
    
    private static Logger logger = LoggerFactory.getLogger(RentalFilmService.class);

    private final RentalFilmRepository rentalFilmRepository;
    private final RentalFilmDetailsRepository rentalFilmDetailsRepository;
    private final RentalFilmPriceCalculatorFactory rentalFilmPriceCalculatorFactory;

    public RentalFilmService(
            RentalFilmRepository rentalFilmRepository,
            RentalFilmDetailsRepository rentalFilmDetailsRepository,
            RentalFilmPriceCalculatorFactory rentalFilmPriceCalculatorFactory) {

        Objects.requireNonNull(rentalFilmRepository);
        Objects.requireNonNull(rentalFilmDetailsRepository);
        Objects.requireNonNull(rentalFilmPriceCalculatorFactory);

        this.rentalFilmRepository = rentalFilmRepository;
        this.rentalFilmDetailsRepository = rentalFilmDetailsRepository;
        this.rentalFilmPriceCalculatorFactory = rentalFilmPriceCalculatorFactory;
    }

    // ============================================================================
    // Calculate rental price
    // ============================================================================

    public BigDecimal calculatePriceToRentFilms(List<String> codes, Integer days) {
        Objects.requireNonNull(codes);
        Objects.requireNonNull(days);
        // Check if days > 0

        BigDecimal total = BigDecimal.ZERO;

        for (String code: codes) {
            RentalFilm film = rentalFilmRepository.findByCode(code);

            if ( film == null ) {
                // throw exception
            }
            total = total.add(calculatePriceToRentFilms(film, days));

        }

        return total;
    }

    private BigDecimal calculatePriceToRentFilms(RentalFilm film, int days) {
        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(film.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        return priceCalculator.calculatePrice(film, days, 0);
    }

    // ============================================================================
    // Calculate return fee
    // ============================================================================
    public BigDecimal calculatePriceToReturnFilms(List<String> codes) {
        BigDecimal total = BigDecimal.ZERO;

        for (String code: codes) {
            RentalFilmDetails rentalFilmDetails = rentalFilmDetailsRepository.findByCode(code);

            if ( rentalFilmDetails == null ) {
                // throw exception
            }

            total = total.add(calculatePriceToReturnFilm(rentalFilmDetails));

        }

        return total;
    }

    private BigDecimal calculatePriceToReturnFilm(RentalFilmDetails rentalFilmDetails) {
        Long days = Duration.between(LocalDateTime.now(), rentalFilmDetails.getDateRent()).get(ChronoUnit.DAYS);
        
        logger.info("Rental days so far is {}", days);

        int daysDelayed = 0;

        if ( days > rentalFilmDetails.getDaysRent() ) {
            daysDelayed = days.intValue() - rentalFilmDetails.getDaysRent();
        }

        logger.info("Days delayed is {}", daysDelayed);

        RentalFilm film = rentalFilmRepository.findByCode(rentalFilmDetails.getCode());

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(film.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        BigDecimal lateFee =  priceCalculator.calculatePrice(film, rentalFilmDetails.getDaysRent(), daysDelayed).subtract(priceCalculator.calculatePrice(film, rentalFilmDetails.getDaysRent(), 0));

        logger.info("Calculated late fee to return film is {}", lateFee);

        return lateFee;
    }
}
