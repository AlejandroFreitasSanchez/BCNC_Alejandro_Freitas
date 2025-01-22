package com.bcnc.alejandro.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Price {
	private Long productId;
	private Long brandId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int priority;
	private BigDecimal price;
	private String currency;

}