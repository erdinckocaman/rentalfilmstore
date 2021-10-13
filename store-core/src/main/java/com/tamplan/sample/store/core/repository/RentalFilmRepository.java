package com.tamplan.sample.store.core.repository;

import com.tamplan.sample.store.core.domain.RentalFilm;

public interface RentalFilmRepository {

    RentalFilm findByCode(String code);

}
