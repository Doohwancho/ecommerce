package com.cho.ecommerce.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Exception")
@Schema(name = "3. No Such Element Found Exception", description = "Page Not Found")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends RuntimeException {
    public NoSuchElementFoundException(String message){
        super(message);
    }
}