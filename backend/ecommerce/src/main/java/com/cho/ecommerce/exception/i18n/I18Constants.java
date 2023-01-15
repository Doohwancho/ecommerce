package com.cho.ecommerce.exception.i18n;

import lombok.Getter;

@Getter
public enum I18Constants {
    NO_ITEM_FOUND("item.absent"),
    DATABASE_EXCEPTION("database.exception"),
    NO_CATEGORY_FOUND("category.absent");

    String key;
    I18Constants(String key) {
        this.key = key;
    }
}