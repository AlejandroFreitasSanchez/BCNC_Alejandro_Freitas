package com.bcnc.alejandro.infraestructura.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "PRICES")
@Entity
public class PriceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long productId;
	private Long brandId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int priority;
	private BigDecimal price;
	private String currency;
}
