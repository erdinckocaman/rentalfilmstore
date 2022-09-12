package com.tamplan.sample.store.core.infra.inbound.rest.model;

import java.util.List;

public record RentalFilmRequest(List<String> codes, Integer days) { }
