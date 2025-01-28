package com.bcnc.alejandro;

import com.bcnc.alejandro.application.useCase.FindPriceUseCase;
import com.bcnc.alejandro.domain.exception.PriceNotFoundException;
import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.domain.utils.ExceptionEnum;
import com.bcnc.alejandro.infraestructura.mapper.PriceDto;
import com.bcnc.alejandro.infraestructura.mapper.PriceDtoMapper;
import com.bcnc.alejandro.infraestructura.rest.controller.PriceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {
	 @Mock
    private FindPriceUseCase findPriceUseCase; 

    @Autowired
    private MockMvc mockMvc; 
    @InjectMocks
    private PriceController priceController; 

    private Price mockPrice;
    private PriceDto mockPriceDto;

    @BeforeEach
    public void setUp() {
    	
        // Configuración del mock para el objeto Price
    	
        mockPrice = new Price(
                35455L, 1L, 1, LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                LocalDateTime.of(2020, 6, 14, 18, 0, 0), 1, new BigDecimal("35.50"), "EUR"
        );
        
        
        mockPriceDto = PriceDtoMapper.fromPriceToPriceDto(mockPrice);
    }

    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_Success() throws Exception {
        // Mock
        when(findPriceUseCase.findPriceByProductIdBrandIdAndApplicationDate(35455L, 1L, LocalDateTime.of(2020, 6, 14, 10, 0, 0)))
                .thenReturn(mockPrice); 

        // Llamada al controlador
        ResponseEntity<PriceDto> response = priceController.findPriceByProductIdBrandIdAndApplicationDate(
                35455L, 1L, LocalDateTime.of(2020, 6, 14, 10, 0, 0)
        );

        // asserts
        assertEquals(HttpStatus.OK, response.getStatusCode()); 
        assertEquals(mockPriceDto.getBrandId(), response.getBody().getBrandId());
        assertEquals(mockPriceDto.getEndDate(), response.getBody().getEndDate());
        assertEquals(mockPriceDto.getPrice(), response.getBody().getPrice());
        assertEquals(mockPriceDto.getPriceList(), response.getBody().getPriceList());
        assertEquals(mockPriceDto.getStartDate(), response.getBody().getStartDate());
    }

    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_NotFound() throws Exception {
        // Configuración Mock para que lance una excepción
        when(findPriceUseCase.findPriceByProductIdBrandIdAndApplicationDate(35455L, 1L, LocalDateTime.of(2020, 6, 14, 10, 0, 0)))
                .thenThrow(new PriceNotFoundException(35455L, 1L, "2020-06-14T10:00:00")); 

        // Llamada al controlador
        MvcResult result = mockMvc.perform(get("/bcnc/prices")
                .param("productId", "35455")
                .param("brandId", "2")
                .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(String.format(ExceptionEnum.PRICE_NOT_FOUND_EXCEPTION.getMessage(), 35455, 2, "2020-06-14T10:00")))
                .andReturn();

        // asserts
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
}
    }
