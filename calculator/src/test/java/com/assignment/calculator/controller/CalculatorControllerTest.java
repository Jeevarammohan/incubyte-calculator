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
 * Unit tests for the {@link CalculatorController} class.
 * This test focuses on verifying the behavior of the controller layer for the calculator API.
 * It tests the addition of numbers by sending a POST request to the '/api/v1/calculator/add' endpoint.
 */
@WebMvcTest(CalculatorController.class)
@Import(CalculatorService.class)
public class CalculatorControllerTest {
    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    private MockMvc mockMvc;
    /**
     * Sets up the necessary environment for the test, initializing the {@link MockMvc} instance
     * that will be used to perform the HTTP requests.
     */
    @BeforeEach
    public void setup() {
        mockMvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    /**
     * Tests the {@link CalculatorController#addNumbers(String)} method to verify that
     * the controller correctly adds a series of numbers and returns the expected sum.

     * Given a valid series of numbers in the request body (e.g., "1,2,3,4,5"), the controller
     * should return the correct sum as part of the response.

     * Expected outcome: The response should contain the string "Sum is: 15" with an HTTP 200 status.
     *
     * @throws Exception if there is any error while performing the request
     */
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

    /**
     * Tests the {@link CalculatorController#addNumbers(String)} method to verify that
     * the controller correctly adds a series of numbers and returns the expected sum.

     * Given a invalid series of numbers in the request body (e.g., "1,-2,3"), the controller
     * should return the correct sum as part of the response if no negative is given.

     * Expected outcome: The response should contain the string "negative numbers not allowed " with an HTTP 500 status.
     *
     * @throws Exception if there is any error while performing the request
     */
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
