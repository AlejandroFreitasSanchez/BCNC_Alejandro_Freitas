package com.bcnc.alejandro.infraestructura.dataBase.h2.mapper;

import com.bcnc.alejandro.domain.model.Price;

public class PriceDtoMapper {
	public static PriceDto fromPriceToPriceDto(Price price) {
		return new PriceDto(price.getProductId(), price.getBrandId(), price.getPriceList(),
				price.getStartDate(), price.getEndDate(), price.getPrice());
	}
}
