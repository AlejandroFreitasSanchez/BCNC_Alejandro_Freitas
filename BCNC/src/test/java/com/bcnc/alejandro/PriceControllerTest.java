package com.bcnc.alejandro;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testIntegracion01() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/BCNC/price/35455/1/2020-06-14T10:00:00"))
    	.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_Succes01() throws Exception {
        // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        mockMvc.perform(MockMvcRequestBuilders.get("/BCNC/price/35455/1/2020-06-14T10:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50)); 
    }
    
    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_Succes02() throws Exception {
        // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        mockMvc.perform(MockMvcRequestBuilders.get("/BCNC/price/35455/1/2020-06-14T16:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45)); 
    }
    
    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_Succes03() throws Exception {
        // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        mockMvc.perform(MockMvcRequestBuilders.get("/BCNC/price/35455/1/2020-06-14T21:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50)); 
    }
    
    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_Succes04() throws Exception {
        // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        mockMvc.perform(MockMvcRequestBuilders.get("/BCNC/price/35455/1/2020-06-15T10:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50)); 
    }
    
    @Test
    public void testFindPriceByProductIdAndBrandIdAndApplicationDate_Succes05() throws Exception {
        // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
        mockMvc.perform(MockMvcRequestBuilders.get("/BCNC/price/35455/1/2020-06-16T21:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95)); 
    }
    
}