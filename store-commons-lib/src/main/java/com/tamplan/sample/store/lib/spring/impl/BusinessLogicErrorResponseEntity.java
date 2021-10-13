package com.tamplan.sample.store.lib.spring.impl;

import com.tamplan.sample.store.lib.spring.StoreHttpResponseEntity;
import org.springframework.http.HttpStatus;

public class BusinessLogicErrorResponseEntity extends StoreHttpResponseEntity<String> {

    public BusinessLogicErrorResponseEntity(Integer errorCode) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "", errorCode);
    }
}
