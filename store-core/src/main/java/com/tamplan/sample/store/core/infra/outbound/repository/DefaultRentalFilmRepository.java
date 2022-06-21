package com.tamplan.sample.store.core.infra.outbound.repository;

import com.tamplan.sample.store.core.domain.RentalFilm;
import com.tamplan.sample.store.core.domain.RentalFilmType;
import com.tamplan.sample.store.core.repository.RentalFilmRepository;

/**
 * Dummy interface implementation
 */
public class DefaultRentalFilmRepository implements RentalFilmRepository {
    @Override
    public RentalFilm findByCode(String code) {
        return new RentalFilm(code, "Film", RentalFilmType.REGULAR);
    }
}
