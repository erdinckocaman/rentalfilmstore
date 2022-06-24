package com.tamplan.sample.store.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This object used to track rental process of a film
 */
public class RentalFilmProcess {

    private String code;
    private LocalDateTime dateRent;
    private Integer daysRent;
    private Integer status; // not used currently

    public RentalFilmProcess(String code, LocalDateTime dateRent, Integer daysRent) {
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
