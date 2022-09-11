package com.tamplan.sample.store.lib.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException(Throwable e) {
        super(e);
    }

    protected BaseException() {
    }

    protected BaseException(String message) {
        super(message);
    }


}
