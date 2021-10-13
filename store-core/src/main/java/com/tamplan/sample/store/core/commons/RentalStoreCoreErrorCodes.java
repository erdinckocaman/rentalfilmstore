package com.tamplan.sample.store.core.commons;

public enum RentalStoreCoreErrorCodes {

    PRICE_CALCULATOR_NOT_FOUND(101),
    RENTAL_FILM_NOT_FOUND(102),
    RENTAL_FILM_PROCESS_NOT_FOUND(103);

    int code;

    RentalStoreCoreErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
