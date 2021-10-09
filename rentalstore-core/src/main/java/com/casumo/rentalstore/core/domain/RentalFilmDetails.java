package com.casumo.rentalstore.core.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class RentalFilmDetails {

    private String code;
    private LocalDateTime dateRent;
    private Integer daysRent;

    public RentalFilmDetails(String code, LocalDateTime dateRent, Integer daysRent) {
        Objects.requireNonNull(code);
        Objects.requireNonNull(dateRent);
        Objects.requireNonNull(daysRent);

        this.code = code;
        this.dateRent = dateRent;
        this.daysRent = daysRent;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getDateRent() {
        return dateRent;
    }

    public Integer getDaysRent() {
        return daysRent;
    }
}
