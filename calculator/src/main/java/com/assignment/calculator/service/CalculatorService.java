package com.assignment.calculator.service;

import org.springframework.stereotype.Service;
/**
 * A service that provides methods to perform various calculations.
 * Currently, it supports adding numbers provided in a comma-separated string.
 */
@Service
public class CalculatorService {
    /**
     * Adds a series of numbers provided as a comma-separated string.
     * @author Jeeva R
     * @param numbers A string containing numbers separated by commas (e.g., "1,2,3").
     * @return The sum of the numbers as an integer.
     */
    public int addNumber(String numbers) {
        // return sum as 0 if empty or null input
        if(isNullOrEmpty(numbers)){
            return 0;
        }
        //splitting the numbers with ',' delimitter
        String[] numberArray = numbers.split(",");
        int sum=0;
        //calculating the sum of numbers
        for(String number : numberArray){
            sum+=Integer.parseInt(number);
        }
        //returning the result
        return sum;

    }
    /**
     * helper method to check whether the given input is null or empty .
     * @author Jeeva R
     * @param numbers (empty string or null input)
     * @return validity status.
     */
    public boolean isNullOrEmpty(String numbers) {
        //checks whether it is empty input or null input
        return numbers == null || numbers.isEmpty();
    }
}
