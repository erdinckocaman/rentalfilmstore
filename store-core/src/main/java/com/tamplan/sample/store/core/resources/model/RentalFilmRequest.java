package com.tamplan.sample.store.core.resources.model;

import java.util.List;

public class RentalFilmRequest {

    private List<String> codes;

    private Integer days;

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
