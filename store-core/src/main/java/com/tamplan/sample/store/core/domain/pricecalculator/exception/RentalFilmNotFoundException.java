package com.tamplan.sample.store.core.domain.pricecalculator.exception;

import com.tamplan.sample.store.core.commons.RentalStoreCoreErrorCodes;
import com.tamplan.sample.store.lib.exception.BaseExceptionWithExternalCode;

public class RentalFilmNotFoundException extends BaseExceptionWithExternalCode {

    private final String filmCode;

    public RentalFilmNotFoundException(String filmCode) {
        super(RentalStoreCoreErrorCodes.RENTAL_FILM_NOT_FOUND.getCode());
        this.filmCode = filmCode;
    }

    @Override
    public String getMessage() {
        return "[film code=" + filmCode + "]";
    }
}
