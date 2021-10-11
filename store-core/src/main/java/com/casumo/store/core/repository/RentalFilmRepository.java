package com.casumo.store.core.repository;

import com.casumo.store.core.domain.RentalFilm;

public interface RentalFilmRepository {

    RentalFilm findByCode(String code);

}
