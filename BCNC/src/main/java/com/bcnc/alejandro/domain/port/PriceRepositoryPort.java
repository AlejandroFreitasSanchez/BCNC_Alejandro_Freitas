package com.bcnc.alejandro.domain.port;

import java.time.LocalDateTime;


import com.bcnc.alejandro.domain.model.Price;

public interface PriceRepositoryPort {
	Price findPriceByProductIdBrandIandApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
