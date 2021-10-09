package com.casumo.rentalstore.core.repository.impl;

import com.casumo.rentalstore.core.domain.RentalFilmDetails;
import com.casumo.rentalstore.core.repository.RentalFilmDetailsRepository;

import java.time.LocalDateTime;

public class DefaultRentalFilmDetailsRepository implements RentalFilmDetailsRepository {

    @Override
    public RentalFilmDetails findByCode(String code) {
        return new RentalFilmDetails(code, LocalDateTime.now().minusDays(3), 2);
    }
}
