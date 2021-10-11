package com.casumo.store.core.resources.model;

import java.util.List;

public class RentalFilmReturnRequest {

    private List<String> codes;

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }
}
