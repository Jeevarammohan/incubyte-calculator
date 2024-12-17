package com.assignment.calculator.controller;

import com.assignment.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for the {@link CalculatorController} class.
 * This test class focuses on verifying the behavior of the controller layer of the calculator API.
 */
@WebMvcTest(CalculatorController.class)
@Import(CalculatorService.class)
public class CalculatorControllerTest {
    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void shouldAddValidNumbers() throws Exception {
        String numbers = "1,2,3,4,5";
        when(calculatorService.addNumber(numbers)).thenReturn(15);

        mockMvc.perform(post("/api/v1/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(numbers))
                .andExpect(status().isOk())
                .andExpect(content().string("Sum is: 15"));
    }
    @Test
    public void testAddNumbersWithNegativeNumbers() throws Exception {
        // Mock the service call
        when(calculatorService.addNumber("1,-2,3")).thenThrow(new IllegalArgumentException("negative numbers not allowed -2"));

        mockMvc.perform(post("/api/v1/calculator/add")
                        .content("1,-2,3")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("negative numbers not allowed -2"));
    }
}
