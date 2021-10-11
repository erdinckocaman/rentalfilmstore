package com.casumo.store.core.domain;

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
