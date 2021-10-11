package com.casumo.store.core.service.exception;

import com.casumo.store.core.commons.RentalStoreCoreErrorCodes;
import com.casumo.store.lib.exception.BaseExceptionWithExternalCode;

public class RentalFilmProcessNotFoundException extends BaseExceptionWithExternalCode {

    private final String processCode;

    public RentalFilmProcessNotFoundException(String processCode) {
        super(RentalStoreCoreErrorCodes.RENTAL_FILM_PROCESS_NOT_FOUND.getCode());

        this.processCode = processCode;
    }

    @Override
    public String getMessage() {
        return "[process code=" + processCode + "]";
    }
}
