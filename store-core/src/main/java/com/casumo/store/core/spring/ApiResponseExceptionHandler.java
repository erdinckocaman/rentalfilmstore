package com.casumo.store.core.spring;

import com.casumo.store.lib.exception.BaseExceptionWithExternalCode;
import com.casumo.store.lib.spring.StoreHttpResponseEntity;
import com.casumo.store.lib.spring.impl.BusinessLogicErrorResponseEntity;
import com.casumo.store.lib.spring.impl.ServerErrorResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(ApiResponseExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public StoreHttpResponseEntity handleServerError(Exception exception, WebRequest request) {
        logger.error("Generic server error", exception);
        return new ServerErrorResponseEntity("Generic server error");
    }

    @ExceptionHandler(BaseExceptionWithExternalCode.class)
    public StoreHttpResponseEntity handleServerError(BaseExceptionWithExternalCode exception, WebRequest request) {
        logger.error("Business logic error", exception);
        return new BusinessLogicErrorResponseEntity(exception.getExternalCode());
    }

}
