package com.casumo.store.core.service.exception;

import com.casumo.store.core.commons.RentalStoreCoreErrorCodes;
import com.casumo.store.lib.exception.BaseExceptionWithExternalCode;

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
