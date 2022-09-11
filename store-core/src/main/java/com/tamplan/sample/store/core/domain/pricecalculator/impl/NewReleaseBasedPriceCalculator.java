package com.tamplan.sample.store.core.domain.pricecalculator.impl;

import com.tamplan.sample.store.core.domain.entity.RentalFilm;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceType;

import java.math.BigDecimal;

public class NewReleaseBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int totalDays = days + daysDelayed;

        return RentalFilmPriceType.PREMIUM.getPrice().multiply(BigDecimal.valueOf(totalDays));
    }
}
