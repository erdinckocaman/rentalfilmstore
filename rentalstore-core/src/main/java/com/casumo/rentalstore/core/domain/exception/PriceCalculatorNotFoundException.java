package com.casumo.rentalstore.core.domain.exception;

import com.casumo.rentalstore.core.commons.RentalStoreCoreErrorCodes;
import com.casumo.rentalstore.core.domain.RentalFilmType;
import com.casumo.rentalstore.lib.exception.BaseExceptionWithExternalCode;

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
