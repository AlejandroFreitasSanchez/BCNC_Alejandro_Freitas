package com.bcnc.alejandro.application.useCase;

import java.time.LocalDateTime;


import org.springframework.stereotype.Component;

import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.domain.port.PriceRepositoryPort;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class FindPriceUseCase implements IFindPriceUseCase{
	
	private final PriceRepositoryPort priceRepositoryPort;
	
		@Override
		public Price findPriceByProductIdAndBrandIandApplicationDate(Long productId,
				Long brandId, LocalDateTime applicationDate) {
			// TODO Auto-generated method stub
			return priceRepositoryPort.findPriceByProductIdAndBrandIandApplicationDate(productId, brandId, applicationDate);
		}
	

}
