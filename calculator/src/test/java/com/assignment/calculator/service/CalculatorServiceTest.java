package com.assignment.calculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Unit tests for {@link CalculatorService}.
 * This class contains test cases to verify the functionality of the CalculatorService,
 */
public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    /**
     * Tests the addition of valid numbers.
     * Verifies that the method correctly calculates the sum of a list of numbers.
     */
    @Test
    public void shouldAddValidNumbers(){
        String numbers = "1,2,3,4,5";
        int expected = 15;
        int actual = calculatorService.addNumber(numbers);
        assertEquals(expected, actual, "The sum should be 15");
    }

}