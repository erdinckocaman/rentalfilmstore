package com.casumo.store.lib.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class StoreHttpResponseEntity<T> extends ResponseEntity<StoreHttpResponse<T>> {

    public StoreHttpResponseEntity(HttpStatus status, T data, Integer errorCode) {
        super(new StoreHttpResponse(data, errorCode), status);
    }

    public StoreHttpResponseEntity(HttpStatus status, T data) {
        super(new StoreHttpResponse(data, 0), status);
    }
}
