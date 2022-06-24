package com.tamplan.sample.store.core.domain.pricecalculator.exception;

import com.tamplan.sample.store.core.commons.RentalStoreCoreErrorCodes;
import com.tamplan.sample.store.core.domain.entity.RentalFilmType;
import com.tamplan.sample.store.lib.exception.BaseExceptionWithExternalCode;

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
