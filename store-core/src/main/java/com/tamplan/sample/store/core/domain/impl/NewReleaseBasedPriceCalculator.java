package com.tamplan.sample.store.core.domain.impl;

import com.tamplan.sample.store.core.domain.RentalFilm;
import com.tamplan.sample.store.core.domain.RentalFilmPriceType;
import com.tamplan.sample.store.core.domain.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class NewReleaseBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int totalDays = days + daysDelayed;

        return RentalFilmPriceType.PREMIUM.getPrice().multiply(BigDecimal.valueOf(totalDays));
    }
}
