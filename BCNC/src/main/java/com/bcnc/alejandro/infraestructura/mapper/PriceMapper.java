package com.bcnc.alejandro.infraestructura.mapper;


import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.infraestructura.entity.PriceEntity;

public class PriceMapper {

	public static Price fromPriceEntityToPrice(PriceEntity priceEntity) {
		return new Price(priceEntity.getProductId(), priceEntity.getBrandId(), priceEntity.getPriceList(),
				priceEntity.getStartDate(), priceEntity.getEndDate(), priceEntity.getPriority(), priceEntity.getPrice(),
				priceEntity.getCurrency());
	}
}
