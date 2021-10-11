package com.casumo.store.lib.spring.impl;

import com.casumo.store.lib.spring.StoreHttpResponseEntity;
import org.springframework.http.HttpStatus;

public class OkResponseEntity<T> extends StoreHttpResponseEntity<T> {

    public OkResponseEntity(T payload) {
        super(HttpStatus.OK, payload);
    }
}
