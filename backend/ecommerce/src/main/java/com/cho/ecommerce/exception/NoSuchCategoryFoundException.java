package com.cho.ecommerce.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Exception")
@Schema(description = "Page Not Found")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchCategoryFoundException extends RuntimeException {
    public NoSuchCategoryFoundException(String message){
        super(message);
    }
}
