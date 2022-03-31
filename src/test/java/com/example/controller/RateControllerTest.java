package com.example.controller;

import com.example.model.Rate;
import com.example.service.RateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RateController.class)
class RateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RateService rateService;

    @Test
    void findById_ReturnOK() throws Exception {

        Rate rate = new Rate(1,2,1, new Date(2022- 1 - 1), new Date(2023-12-12),350, "EUR");

        given(rateService.findById(1)).willReturn(rate);
        mockMvc.perform(get("/rates/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand_id", is(rate.getBrandId())))
                .andExpect(jsonPath("$.product_id", is(rate.getProductId())))
                .andExpect(jsonPath("$.startDate", is(rate.getStartDate())))
                .andExpect(jsonPath("$.end_Date", is(rate.getEndDate())))
                .andExpect(jsonPath("$.price", is(50)))
                .andExpect(jsonPath("$.currencyCode", is(rate.getCurrencyCode())));
    }
}