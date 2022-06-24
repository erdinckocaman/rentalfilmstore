package com.tamplan.sample.store.core.domain.pricecalculator.impl;

import com.tamplan.sample.store.core.domain.pricecalculator.PriceCalculatorUtil;
import com.tamplan.sample.store.core.domain.entity.RentalFilm;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceType;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceCalculator;

import java.math.BigDecimal;

public class RegularFilmBasedPriceCalculator implements RentalFilmPriceCalculator {

    @Override
    public BigDecimal calculatePrice(RentalFilm rentalFilm, int days, int daysDelayed) {
        int daysTotal = days + daysDelayed;

        return PriceCalculatorUtil.calculatePriceWithFlatPricing(daysTotal, RentalFilmPriceType.BASIC.getPrice(), 3);

    }
}
