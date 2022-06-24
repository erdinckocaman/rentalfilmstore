package com.tamplan.sample.store.core.domain.pricecalculator;

import com.tamplan.sample.store.core.domain.entity.RentalFilmType;

import java.util.Objects;

/**
 * Context information used to calculate rental pricing
 */
public class PriceCalculatorContext {

    private RentalFilmType filmType;

    public PriceCalculatorContext(RentalFilmType filmType) {
        Objects.requireNonNull(filmType);

        this.filmType = filmType;
    }

    public RentalFilmType getFilmType() {
        return filmType;
    }
}
