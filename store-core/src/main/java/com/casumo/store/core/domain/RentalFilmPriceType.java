package com.casumo.store.core.domain;

import java.math.BigDecimal;

public enum RentalFilmPriceType {

    PREMIUM(BigDecimal.valueOf(40L)),
    BASIC(BigDecimal.valueOf(30L));

    private BigDecimal price;

    RentalFilmPriceType(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
