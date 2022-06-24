package com.tamplan.sample.store.core.domain.pricecalculator.exception;

import com.tamplan.sample.store.core.commons.RentalStoreCoreErrorCodes;
import com.tamplan.sample.store.lib.exception.BaseExceptionWithExternalCode;

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
