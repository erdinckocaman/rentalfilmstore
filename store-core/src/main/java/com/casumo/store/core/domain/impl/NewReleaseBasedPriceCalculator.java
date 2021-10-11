package com.casumo.store.core.domain.impl;

import com.casumo.store.core.domain.RentalFilm;
import com.casumo.store.core.domain.RentalFilmPriceType;
import com.casumo.store.core.domain.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class NewReleaseBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int totalDays = days + daysDelayed;

        return RentalFilmPriceType.PREMIUM.getPrice().multiply(BigDecimal.valueOf(totalDays));
    }
}
