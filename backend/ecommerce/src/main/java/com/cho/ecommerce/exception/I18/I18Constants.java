package com.cho.ecommerce.exception.I18;

import lombok.Getter;

@Getter
public enum I18Constants {
    NO_ITEM_FOUND("item.absent"),
    DATABASE_EXCEPTION("database.exception");

    String key;
    I18Constants(String key) {
        this.key = key;
    }
}