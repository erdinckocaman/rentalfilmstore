package com.casumo.store.core.repository.impl;

import com.casumo.store.core.domain.RentalFilm;
import com.casumo.store.core.domain.RentalFilmType;
import com.casumo.store.core.repository.RentalFilmRepository;

/**
 * Dummy interface implementation
 */
public class DefaultRentalFilmRepository implements RentalFilmRepository {
    @Override
    public RentalFilm findByCode(String code) {
        return new RentalFilm(code, "Film", RentalFilmType.REGULAR);
    }
}
