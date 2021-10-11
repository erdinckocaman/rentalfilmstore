package com.casumo.store.lib.exception;

public abstract class BaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BaseException(Throwable e) {
		super(e);
	}

	protected BaseException() {
	}

	protected BaseException(String message) {
		super(message);
	}
	

}
