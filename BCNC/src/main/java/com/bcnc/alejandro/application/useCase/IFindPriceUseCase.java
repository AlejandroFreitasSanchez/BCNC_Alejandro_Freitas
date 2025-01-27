package com.bcnc.alejandro.application.useCase;

import java.time.LocalDateTime;


import com.bcnc.alejandro.domain.model.Price;

public interface IFindPriceUseCase {
	
	Price findPriceByProductIdBrandIandApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
