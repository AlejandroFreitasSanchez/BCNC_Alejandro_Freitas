package com.bcnc.alejandro.infraestructura.dataBase.h2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcnc.alejandro.infraestructura.dataBase.h2.entity.PriceEntity;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

	/**
	 * 
	 * @param productId
	 * @param brandId
	 * @param applicationDate
	 * @param applicationDate2 -> este campo tiene el mismo valor que applicationDate.
	 * @return Devuelve la entidad PriceEntity con el productId, brandId indicados y
	 *         applicationDate esté entre la fecha de inicio(startDate) y la fecha
	 *         de fin(endDate).
	 */
	List<PriceEntity> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long productId,
			Long brandId, LocalDateTime applicationDate, LocalDateTime applicationDate2);
}
