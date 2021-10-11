package com.casumo.store.core.domain;

import java.math.BigDecimal;

/**
 * This is main interface for different kinds of price calculator instances
 */
public interface RentalFilmPriceCalculator {

    BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed);

}
