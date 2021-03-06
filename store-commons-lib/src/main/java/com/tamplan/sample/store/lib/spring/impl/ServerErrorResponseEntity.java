package com.tamplan.sample.store.lib.spring.impl;

import com.tamplan.sample.store.lib.spring.StoreHttpResponseEntity;
import org.springframework.http.HttpStatus;

public class ServerErrorResponseEntity extends StoreHttpResponseEntity<String> {

    public ServerErrorResponseEntity(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
