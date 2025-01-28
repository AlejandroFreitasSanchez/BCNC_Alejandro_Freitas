package com.bcnc.alejandro.domain.utils;

public enum ExceptionEnum {
    
    PRICE_NOT_FOUND_EXCEPTION("No se ha encontrado ningún precio para el productId %d, brandId %d, applicationDate %s indicado.");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
