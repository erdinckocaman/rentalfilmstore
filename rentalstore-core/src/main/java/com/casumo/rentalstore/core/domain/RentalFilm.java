package com.casumo.rentalstore.core.domain;

import java.util.Objects;

public class RentalFilm {

    private String code;
    private String name;
    private RentalFilmType filmType;

    public RentalFilm(String code, String name, RentalFilmType filmType) {
        Objects.requireNonNull(code);
        Objects.requireNonNull(name);
        Objects.requireNonNull(filmType);

        this.code = code;
        this.name = name;
        this.filmType = filmType;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public RentalFilmType getFilmType() {
        return filmType;
    }
}
