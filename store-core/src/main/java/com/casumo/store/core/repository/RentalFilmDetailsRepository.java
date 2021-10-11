package com.casumo.store.core.repository;

import com.casumo.store.core.domain.RentalFilmProcess;

public interface RentalFilmDetailsRepository {

    RentalFilmProcess findByCode(String code);
}
