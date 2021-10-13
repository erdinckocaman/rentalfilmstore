package com.tamplan.sample.store.core.domain.impl;

import com.tamplan.sample.store.core.domain.PriceCalculatorUtil;
import com.tamplan.sample.store.core.domain.RentalFilm;
import com.tamplan.sample.store.core.domain.RentalFilmPriceType;
import com.tamplan.sample.store.core.domain.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class RegularFilmBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int daysTotal = days + daysDelayed;

        return PriceCalculatorUtil.calculatePriceWithFlatPricing(daysTotal, RentalFilmPriceType.BASIC.getPrice(), 3);

    }
}
