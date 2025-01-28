package com.bcnc.alejandro;



import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIT {

    @Autowired
    private MockMvc mockMvc;
    
    

    @Test
    public void Test01_integracion() throws Exception {
        // Test 1: Petición para el producto 35455 de la marca 1 (ZARA) a las 10:00 AM del día 14 de junio.
        // Se espera que el precio sea 35.50 y que los demás detalles coincidan con los valores correctos
        mockMvc.perform(MockMvcRequestBuilders.get("/bcnc/prices?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }
    
    @Test
    public void Test02_integracion() throws Exception {
        // Test 2: Petición para el producto 35455 de la marca 1 (ZARA) a las 4:00 PM del día 14 de junio.
        // Se espera que el precio sea 25.45 y que los demás detalles coincidan con los valores correctos
        mockMvc.perform(MockMvcRequestBuilders.get("/bcnc/prices?productId=35455&brandId=1&applicationDate=2020-06-14T16:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18:30:00"));
    }
    
    @Test
    public void Test03_integracion() throws Exception {
        // Test 3: Petición para el producto 35455 de la marca 1 (ZARA) a las 9:00 PM del día 14 de junio.
        // Se espera que el precio sea 35.50 y que los demás detalles coincidan con los valores correctos
        mockMvc.perform(MockMvcRequestBuilders.get("/bcnc/prices?productId=35455&brandId=1&applicationDate=2020-06-14T21:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }
    
    @Test
    public void Test04_integracion() throws Exception {
        // Test 4: Petición para el producto 35455 de la marca 1 (ZARA) a las 10:00 AM del día 15 de junio.
        // Se espera que el precio sea 30.50 y que los demás detalles coincidan con los valores correctos
        mockMvc.perform(MockMvcRequestBuilders.get("/bcnc/prices?productId=35455&brandId=1&applicationDate=2020-06-15T10:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00"));
    }
    
    @Test
    public void Test05_integracion() throws Exception {
        // Test 5: Petición para el producto 35455 de la marca 1 (ZARA) a las 9:00 PM del día 16 de junio.
        // Se espera que el precio sea 38.95 y que los demás detalles coincidan con los valores correctos
        mockMvc.perform(MockMvcRequestBuilders.get("/bcnc/prices?productId=35455&brandId=1&applicationDate=2020-06-16T21:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }
    
}