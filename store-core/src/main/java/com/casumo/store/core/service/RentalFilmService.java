package com.casumo.store.core.service;

import com.casumo.store.core.domain.*;
import com.casumo.store.core.repository.RentalFilmDetailsRepository;
import com.casumo.store.core.repository.RentalFilmRepository;
import com.casumo.store.core.service.exception.RentalFilmNotFoundException;
import com.casumo.store.core.service.exception.RentalFilmProcessNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
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

        logger.info("Calculating rental price for codes '{}' and days '{}'", codes, days);

        BigDecimal total = BigDecimal.ZERO;

        for (String code: codes) {
            RentalFilm film = rentalFilmRepository.findByCode(code);

            if ( film == null ) {
                throw new RentalFilmNotFoundException(code);
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
            RentalFilmProcess rentalFilmDetails = rentalFilmDetailsRepository.findByCode(code);

            if ( rentalFilmDetails == null ) {
               throw new RentalFilmProcessNotFoundException(code);
            }

            total = total.add(calculatePriceToReturnFilm(rentalFilmDetails));

        }

        return total;
    }

    private BigDecimal calculatePriceToReturnFilm(RentalFilmProcess rentalFilmDetails) {
        Long days = Duration.between(rentalFilmDetails.getDateRent(), LocalDateTime.now()).toDays();
        
        logger.info("For renting process '{}', rental days so far is {}", rentalFilmDetails.getCode(), days);

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
