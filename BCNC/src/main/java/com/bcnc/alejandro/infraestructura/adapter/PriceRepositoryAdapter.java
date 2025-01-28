package com.bcnc.alejandro.infraestructura.adapter;

import java.time.LocalDateTime;

import java.util.Optional;


import org.springframework.stereotype.Component;

import com.bcnc.alejandro.domain.exception.PriceNotFoundException;
import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.domain.port.PriceRepositoryPort;
import com.bcnc.alejandro.infraestructura.entity.PriceEntity;
import com.bcnc.alejandro.infraestructura.mapper.PriceMapper;
import com.bcnc.alejandro.infraestructura.repository.PriceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort{
	
	
	private static final Logger logger = LoggerFactory.getLogger(PriceRepositoryAdapter.class);

	private final PriceRepository jpaPriceRepository;
	
	@Override
	public Price findPriceByProductIdBrandIdAndApplicationDate(Long productId, Long brandId,
			LocalDateTime applicationDate) {
	
        Optional<PriceEntity> priceEntitie = jpaPriceRepository.findPriceByProductIdBrandIandApplicationDate(
                productId, brandId, applicationDate);
        
        if(!priceEntitie.isPresent()) {
            PriceNotFoundException exception = new PriceNotFoundException(productId, brandId, applicationDate.toString());
            logger.error(exception.getMessage(), exception);
            throw exception;

		}
        
       
		return PriceMapper.fromPriceEntityToPrice(priceEntitie.get());
	}

}
