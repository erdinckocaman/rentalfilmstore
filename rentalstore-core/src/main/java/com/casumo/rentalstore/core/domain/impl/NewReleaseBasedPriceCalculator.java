package com.casumo.rentalstore.core.domain.impl;

import com.casumo.rentalstore.core.domain.RentalFilm;
import com.casumo.rentalstore.core.domain.RentalFilmPriceType;
import com.casumo.rentalstore.core.domain.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class NewReleaseBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int totalDays = days + daysDelayed;

        return RentalFilmPriceType.PREMIUM.getPrice().multiply(BigDecimal.valueOf(totalDays));
    }
}
