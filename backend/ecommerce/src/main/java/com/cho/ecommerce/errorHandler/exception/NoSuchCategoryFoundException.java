package com.cho.ecommerce.errorHandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchCategoryFoundException extends RuntimeException {
    public NoSuchCategoryFoundException(String message){
        super(message);
    }
}
