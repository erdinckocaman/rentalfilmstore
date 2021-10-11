package com.casumo.store.core.domain.exception;

import com.casumo.store.core.commons.RentalStoreCoreErrorCodes;
import com.casumo.store.core.domain.RentalFilmType;
import com.casumo.store.lib.exception.BaseExceptionWithExternalCode;

public class PriceCalculatorNotFoundException extends BaseExceptionWithExternalCode {

    private final RentalFilmType filmType;

    public PriceCalculatorNotFoundException(RentalFilmType filmType) {
        super(RentalStoreCoreErrorCodes.PRICE_CALCULATOR_NOT_FOUND.getCode());

        this.filmType = filmType;
    }

    @Override
    public String getMessage() {
        return "[film type=" + filmType + "]";
    }
}
