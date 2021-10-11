package com.casumo.store.lib.spring;

public class StoreHttpResponse<T> {

    private T payload;
    private Integer errorCode;

    public StoreHttpResponse(T payload, Integer errorCode) {
        this.payload = payload;
        this.errorCode = errorCode;
    }

    public T getPayload() {
        return payload;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
