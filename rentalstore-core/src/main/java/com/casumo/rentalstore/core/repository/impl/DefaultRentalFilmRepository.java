package com.casumo.rentalstore.core.repository.impl;

import com.casumo.rentalstore.core.domain.RentalFilm;
import com.casumo.rentalstore.core.domain.RentalFilmType;
import com.casumo.rentalstore.core.repository.RentalFilmRepository;

public class DefaultRentalFilmRepository implements RentalFilmRepository {
    @Override
    public RentalFilm findByCode(String code) {
        return new RentalFilm(code, "Film", RentalFilmType.REGULAR);
    }
}
