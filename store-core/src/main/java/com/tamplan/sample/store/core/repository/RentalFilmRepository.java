package com.tamplan.sample.store.core.repository;

import com.tamplan.sample.store.core.domain.entity.RentalFilm;

public interface RentalFilmRepository {
    RentalFilm findByCode(String code);

}
