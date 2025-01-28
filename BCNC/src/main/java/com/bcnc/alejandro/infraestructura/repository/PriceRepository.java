package com.bcnc.alejandro.infraestructura.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcnc.alejandro.infraestructura.entity.PriceEntity;

public interface PriceRepository {

	/**
	 * 
	 * @param productId
	 * @param brandId
	 * @param applicationDate
	 * @return Devuelve la entidad PriceEntity con el productId, brandId indicados y
	 *         applicationDate
	 */
	Optional<PriceEntity> findPriceByProductIdBrandIandApplicationDate(Long productId,
			Long brandId, LocalDateTime applicationDate);
}
