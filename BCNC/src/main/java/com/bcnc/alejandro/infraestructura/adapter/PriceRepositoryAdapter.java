package com.bcnc.alejandro.infraestructura.adapter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.domain.port.PriceRepositoryPort;
import com.bcnc.alejandro.infraestructura.entity.PriceEntity;
import com.bcnc.alejandro.infraestructura.mapper.PriceMapper;
import com.bcnc.alejandro.infraestructura.repository.JpaPriceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort{
	
	private final JpaPriceRepository jpaPriceRepository;
	
	@Override
	public Price findPriceByProductIdBrandIandApplicationDate(Long productId, Long brandId,
			LocalDateTime applicationDate) {
	
        List<PriceEntity> priceEntities = jpaPriceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, applicationDate, applicationDate);
        
        if (priceEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha encontrado ningúm precio para el productId " + productId + ", brandId " + brandId + ", applicationDate " + applicationDate + " indicado.");
        }
        
        // En caso de haber varios precios, se filtra por el de mayor prioridad
        Optional<PriceEntity> priceEntity = priceEntities.stream()
        	    .max(Comparator.comparingInt(PriceEntity::getPriority));
		return PriceMapper.fromPriceEntityToPrice(priceEntity.orElse(null));
	}

}
