package com.tamplan.sample.store.core.repository;

import com.tamplan.sample.store.core.domain.RentalFilmProcess;

public interface RentalFilmDetailsRepository {

    RentalFilmProcess findByCode(String code);
}
