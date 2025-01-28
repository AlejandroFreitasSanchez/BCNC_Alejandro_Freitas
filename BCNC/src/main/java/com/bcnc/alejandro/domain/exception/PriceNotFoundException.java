package com.bcnc.alejandro.domain.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(Long productId, Long brandId, String applicationDate) {
        super(String.format("No se ha encontrado ningúm precio para el productId %d, brandId %d, applicationDate %s indicado.", 
                productId, brandId, applicationDate));
    }
}
