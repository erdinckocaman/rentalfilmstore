package com.casumo.rentalstore.core.repository;

import com.casumo.rentalstore.core.domain.RentalFilm;

public interface RentalFilmRepository {

    RentalFilm findByCode(String code);

}
