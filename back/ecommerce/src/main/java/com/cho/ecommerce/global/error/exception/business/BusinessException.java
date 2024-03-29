package com.cho.ecommerce.global.error.exception.business;

import com.cho.ecommerce.global.error.ErrorCode;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;
    
    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
    
}