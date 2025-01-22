package com.bcnc.alejandro.infraestructura.rest.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.alejandro.application.useCase.FindPriceUseCase;
import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.infraestructura.mapper.PriceDto;
import com.bcnc.alejandro.infraestructura.mapper.PriceDtoMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/BCNC/price")
@RestController
public class PriceController {

	private final FindPriceUseCase findPriceUseCase;

	@GetMapping("/{productId}/{brandId}/{applicationDate}")
	public ResponseEntity<PriceDto> findPriceByProductIdAndBrandIdAndApplicationDateBetweenDates(
			@PathVariable Long productId, @PathVariable Long brandId, @PathVariable LocalDateTime applicationDate) {

		Price price = findPriceUseCase.findPriceByProductIdAndBrandIandApplicationDate(productId, brandId,
				applicationDate);
		PriceDto priceResponseDto = PriceDtoMapper.fromPriceToPriceDto(price);
		return ResponseEntity.status(HttpStatus.OK).body(priceResponseDto);
	}

}
