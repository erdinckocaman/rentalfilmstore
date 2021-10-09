package com.casumo.rentalstore.core.commons;

public enum RentalStoreCoreErrorCodes {

    PRICE_CALCULATOR_NOT_FOUND(101);

    int code;

    RentalStoreCoreErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
