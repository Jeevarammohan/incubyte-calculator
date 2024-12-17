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
        if(isNullOrEmpty(numbers)){
            return 0;
        }
        String[] numberArray = numbers.split(",");
        int sum=0;
        for(String number : numberArray){
            sum+=Integer.parseInt(number);
        }
        return sum;

    }

    public boolean isNullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
