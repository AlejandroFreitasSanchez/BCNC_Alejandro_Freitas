package com.bcnc.alejandro.application.useCase;

import java.time.LocalDateTime;


import org.springframework.stereotype.Component;

import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.domain.exception.PriceNotFoundException;
import com.bcnc.alejandro.domain.port.PriceRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class FindPriceUseCase implements IFindPriceUseCase{
	
	private static final Logger logger = LoggerFactory.getLogger(FindPriceUseCase.class);
	private final PriceRepositoryPort priceRepositoryPort;
	
		@Override
		public Price findPriceByProductIdBrandIdAndApplicationDate(Long productId,
				Long brandId, LocalDateTime applicationDate) {
			
			Price price =  priceRepositoryPort.findPriceByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate);
			
			if(price == null) {
				  PriceNotFoundException exception = new PriceNotFoundException(productId, brandId, applicationDate.toString());
		          logger.error(exception.getMessage(), exception);
		          throw exception;
			}
			
			return price;
		}
	

}
