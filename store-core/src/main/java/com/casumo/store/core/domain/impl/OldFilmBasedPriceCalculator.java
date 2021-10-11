package com.casumo.store.core.domain.impl;

import com.casumo.store.core.domain.PriceCalculatorUtil;
import com.casumo.store.core.domain.RentalFilm;
import com.casumo.store.core.domain.RentalFilmPriceType;
import com.casumo.store.core.domain.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class OldFilmBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int daysTotal = days + daysDelayed;

        return PriceCalculatorUtil.calculatePriceWithFlatPricing(daysTotal, RentalFilmPriceType.BASIC.getPrice(), 5);
    }
}
