package com.assignment.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    public void shouldReturnTrueForNullOrEmptyInput(){
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

    /**
     * Tests the add method handles input with custom delimiter.
     * Verifies that the method correctly return sum
     */
    @Test
    public void shouldHandleInputWithCustomDelimiter(){
        int expected =8;
        int actual= calculatorService.addNumber("//:\n2:4:2 ");
        assertEquals(expected,actual, "The sum should be 8");
    }

    /**
     * Tests the addition of numbers with multiple negative numbers.
     * Verifies that an exception is thrown with the correct message listing all negative numbers.
     */
    @Test
    public void shouldThrowExceptionForMultipleNegativeNumbers() {
        // Prepare the input string with multiple negative numbers
        String numbers = "1,-2,3,-4,5,-6";

        // Perform the test and assert that the exception is thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.addNumber(numbers);
        });

        // Verify the exception message
        assertEquals("negative numbers not allowed -2,-4,-6", exception.getMessage(), "The exception message should list all negative numbers");

    }



}
