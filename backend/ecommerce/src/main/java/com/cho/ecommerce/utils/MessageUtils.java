package com.cho.ecommerce.utils;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@AllArgsConstructor
public class MessageUtils {

    private final MessageSource messageSource;

    public String getLocalMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }
}

