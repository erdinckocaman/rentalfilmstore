package com.casumo.rentalstore.core.domain;

import java.util.Objects;

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
