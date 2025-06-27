package br.com.heserproject.imobiliaria.core.base;


import br.com.heserproject.imobiliaria.core.domain.functional.ApiResponseRunnable;
import br.com.heserproject.imobiliaria.core.domain.functional.ApiResponseSupplier;
import br.com.heserproject.imobiliaria.core.util.HttpUtil;
import lombok.Generated;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import java.io.Serializable;

import static org.springframework.http.HttpStatus.OK;

public abstract class BaseSimpleController implements Serializable, ApplicationContextAware {

    private static final long serialVersionUID = 1L;
    private transient ApplicationContext applicationContext;

    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }

    public ResponseEntity<BaseApiResponse> createResponse(Object responseReturnObject, Class outputClass, HttpStatus httpStatus) {
        return HttpUtil.createResponse(responseReturnObject, outputClass, httpStatus);
    }

    protected ResponseEntity<BaseApiResponse> createResponse(ApiResponseRunnable runnable) {
        runnable.run();
        return ResponseEntity.ok().body(new BaseApiResponse());
    }

    protected <R> ResponseEntity<BaseApiResponse<R>> createResponse(ApiResponseSupplier<?> supplier, Class<R> clazz, HttpStatus httpStatus) {
        return HttpUtil.createResponse(supplier.get(), clazz, httpStatus);
    }


    public static <R> ResponseEntity<BaseApiResponse<R>> sendResponseCreated(ApiResponseSupplier<?> supplier) {
        return sendResponse(supplier, HttpStatus.CREATED);
    }

    protected static <R> ResponseEntity<BaseApiResponse<R>> sendResponseOK(ApiResponseSupplier<?> supplier) {
        return sendResponse(supplier, OK);
    }

    protected static <R> ResponseEntity<BaseApiResponse<R>> sendResponse(ApiResponseSupplier<?> supplier, HttpStatus httpStatus) {
        return HttpUtil.createResponse(supplier.get(), Object.class, httpStatus);
    }

    protected static <R> ResponseEntity<BaseApiResponse<R>> sendResponseOK(ApiResponseRunnable responseRunnable) {
        responseRunnable.run();
        return HttpUtil.createResponse(Boolean.TRUE, Object.class, OK);
    }

    protected static <R> ResponseEntity<BaseApiResponse<R>> sendResponse(ApiResponseRunnable responseRunnable, HttpStatus httpStatus) {
        responseRunnable.run();
        return HttpUtil.createResponse(Boolean.TRUE, Object.class, httpStatus);
    }

    @Generated
    public BaseSimpleController() {
    }
}
