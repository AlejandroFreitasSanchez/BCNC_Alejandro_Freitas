package com.bcnc.alejandro.domain.exception;

import com.bcnc.alejandro.domain.utils.ExceptionEnum;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(Long productId, Long brandId, String applicationDate) {
        super(String.format(ExceptionEnum.PRICE_NOT_FOUND_EXCEPTION.getMessage(), 
                productId, brandId, applicationDate));
    }
}
