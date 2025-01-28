package com.bcnc.alejandro.application.useCase;

import java.time.LocalDateTime;


import org.springframework.stereotype.Component;

import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.domain.exception.PriceNotFoundException;
import com.bcnc.alejandro.domain.port.PriceRepositoryPort;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class FindPriceUseCase implements IFindPriceUseCase{
	
	private final PriceRepositoryPort priceRepositoryPort;
	
		@Override
		public Price findPriceByProductIdBrandIandApplicationDate(Long productId,
				Long brandId, LocalDateTime applicationDate) {
			
			Price price =  priceRepositoryPort.findPriceByProductIdBrandIandApplicationDate(productId, brandId, applicationDate);
			
			if(price == null) {
				throw new PriceNotFoundException(productId, brandId, applicationDate.toString());
			}
			
			return price;
		}
	

}
