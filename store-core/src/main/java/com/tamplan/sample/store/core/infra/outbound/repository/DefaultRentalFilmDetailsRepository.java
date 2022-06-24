package com.tamplan.sample.store.core.infra.outbound.repository;

import com.tamplan.sample.store.core.domain.entity.RentalFilmProcess;
import com.tamplan.sample.store.core.repository.RentalFilmDetailsRepository;

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
