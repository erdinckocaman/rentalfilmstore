package com.casumo.store.lib.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.List;

public abstract class StoreHttpResponseEntity<T> extends ResponseEntity<StoreHttpResponse<T>> {

    public StoreHttpResponseEntity(HttpStatus status, T data, Integer errorCode) {
        super(new StoreHttpResponse(data, errorCode), buildErrorHeader(), status);
    }

    private static MultiValueMap buildErrorHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("X-HAS-ERROR", List.of("true"));
        return httpHeaders;
    }

    public StoreHttpResponseEntity(HttpStatus status, T data) {
        super(new StoreHttpResponse(data, 0), status);
    }
}
