package com.tamplan.sample.store.core.domain.pricecalculator;

import com.tamplan.sample.store.core.domain.entity.RentalFilm;

import java.math.BigDecimal;

/**
 * This is main interface for different kinds of price calculator instances
 */
public interface RentalFilmPriceCalculator {

    BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed);

}
