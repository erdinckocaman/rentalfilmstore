package com.casumo.rentalstore.core.repository;

import com.casumo.rentalstore.core.domain.RentalFilmDetails;

public interface RentalFilmDetailsRepository {

    RentalFilmDetails findByCode(String code);
}
