package com.casumo.store.core.repository.impl;

import com.casumo.store.core.domain.RentalFilmProcess;
import com.casumo.store.core.repository.RentalFilmDetailsRepository;

import java.time.LocalDateTime;

/**
 * Dummy interface implementation
 */
public class DefaultRentalFilmDetailsRepository implements RentalFilmDetailsRepository {

    @Override
    public RentalFilmProcess findByCode(String code) {
        return new RentalFilmProcess(code, LocalDateTime.now().minusDays(4), 2);
    }
}
