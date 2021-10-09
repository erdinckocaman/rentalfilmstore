package com.casumo.rentalstore.lib.exception;

public abstract class BaseExceptionWithExternalCode extends BaseException implements ExceptionWithExternalCode {

	private static final long serialVersionUID = 1L;

	private final int externalCode;

	public BaseExceptionWithExternalCode(int externalCode) {
		this.externalCode = externalCode;
	}

	@Override
	public int getExternalCode() {
		return externalCode;
	}

}
