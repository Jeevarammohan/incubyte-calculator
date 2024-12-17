package com.assignment.calculator.service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    /**
     * Tests the addition of empty numbers/string.
     * Verifies that the method correctly return 0 for empty string
     */
    @Test
    public void shouldReturnZeroWhenEmptyNumber(){
        String numbers = "";
        int expected = 0;
        int actual = calculatorService.addNumber(numbers);
        assertEquals(expected, actual, "The sum should be 0");
    }

    /**
     * Tests the addition of null input.
     * Verifies that the method correctly return 0 for null string
     */
    @Test
    public void shouldReturnZeroWhenNullInput(){

        int expected = 0;
        int actual = calculatorService.addNumber(null);
        assertEquals(expected, actual, "The sum should be 0");
    }

    /**
     * Tests the helper method of invalid input(null or empty string).
     * Verifies that the method correctly return true or false for validity
     */
    @Test
    public void shouldReturnTrueForValidInput(){
        boolean actual= calculatorService.isNullOrEmpty("");
        assertTrue(actual, "The input is invalid but result is false");
    }

    /**
     * Tests the add method handles input with new line between number.
     * Verifies that the method correctly return sum
     */
    @Test
    public void shouldHandleNewLinesBetweenNumbers(){
        int expected =8;
        int actual= calculatorService.addNumber("2\n4,2\n");
        assertEquals(expected,actual, "The sum should be 8");
    }

    /**
     * Tests the add method handles input with trailing space between number.
     * Verifies that the method correctly return sum
     */
    @Test
    public void shouldIgnoreTrailingNewLines(){
        int expected =8;
        int actual= calculatorService.addNumber("2 ,4,2 ");
        assertEquals(expected,actual, "The sum should be 8");
    }


    @Test
    public void shouldHandleInputWithCustomDelimiter(){
        int expected =8;
        int actual= calculatorService.addNumber("\\:\n2:4:2 ");
        assertEquals(expected,actual, "The sum should be 8");
    }




}
