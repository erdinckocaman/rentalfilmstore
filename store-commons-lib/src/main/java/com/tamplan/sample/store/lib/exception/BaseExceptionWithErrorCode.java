package com.tamplan.sample.store.lib.exception;

public abstract class BaseExceptionWithErrorCode extends BaseException implements ExceptionWithErrorCode {

    private final int externalCode;

    public BaseExceptionWithErrorCode(int externalCode) {
        this.externalCode = externalCode;
    }

    @Override
    public int getErrorCode() {
        return externalCode;
    }

}
