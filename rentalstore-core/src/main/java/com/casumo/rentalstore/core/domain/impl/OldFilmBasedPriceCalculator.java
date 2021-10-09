package com.casumo.rentalstore.core.domain.impl;

import com.casumo.rentalstore.core.domain.PriceCalculatorUtil;
import com.casumo.rentalstore.core.domain.RentalFilm;
import com.casumo.rentalstore.core.domain.RentalFilmPriceType;
import com.casumo.rentalstore.core.domain.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class OldFilmBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int daysTotal = days + daysDelayed;

        return PriceCalculatorUtil.calculatePriceWithFlatPricing(daysTotal, RentalFilmPriceType.BASIC.getPrice(), 5);
    }
}
