package com.bcnc.alejandro;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.bcnc.alejandro.domain.model.Price;
import com.bcnc.alejandro.application.useCase.FindPriceUseCase;
import com.bcnc.alejandro.domain.exception.PriceNotFoundException;
import com.bcnc.alejandro.domain.port.PriceRepositoryPort;
import com.bcnc.alejandro.domain.utils.ExceptionEnum;

class FindPriceUseCaseTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private FindPriceUseCase findPriceUseCase;

    private Long productId = 35455L;
    private Long brandId = 1L;
    private BigDecimal price = new BigDecimal("34.5");
    private LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testFindPriceByProductIdBrandIdAndApplicationDate_PriceFound() {
       
        Price expectedPrice = new Price(productId, brandId, 1, applicationDate, applicationDate, 1, price, "EUR");

        // Configurar el mock para que devuelva un precio
        when(priceRepositoryPort.findPriceByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate))
            .thenReturn(expectedPrice);

        // Llamar al método de findPriceUseCase
        Price result = findPriceUseCase.findPriceByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate);

        // asserts
        assertNotNull(result);
        assertEquals(expectedPrice.getPrice(), result.getPrice());
        assertEquals(expectedPrice.getProductId(), result.getProductId());
        assertEquals(expectedPrice.getBrandId(), result.getBrandId());
    }

    @Test
    void testFindPriceByProductIdBrandIdAndApplicationDate_PriceNotFound() {
        // Mock configurado para retornar null
        when(priceRepositoryPort.findPriceByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate))
            .thenReturn(null);

        // Ejecutar el método para comprobar que se lanza la excepcion
        PriceNotFoundException exception = assertThrows(PriceNotFoundException.class, () -> {
            findPriceUseCase.findPriceByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate);
        });

        // assert
        assertEquals(String.format(ExceptionEnum.PRICE_NOT_FOUND_EXCEPTION.getMessage(), 35455, 1, "2020-06-14T10:00"), exception.getMessage());
    }
}
