package com.casumo.rentalstore.core.domain;

import java.math.BigDecimal;

public interface RentalFilmPriceCalculator {

    BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed);

}
