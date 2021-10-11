package com.casumo.store.core.domain;

public enum RentalFilmType {
    NEW_RELEASE("NR"),
    REGULAR("RG"),
    OLD_FILM("OF");

    // This code used to store enumeration value in database as 2-char types
    private String code;

    RentalFilmType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}