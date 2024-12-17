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
        String delimiter =",";
        String numbersPart = numbers;
        if(numbers.startsWith("//")){
            int delimiterIndex = numbers.indexOf("\n");
            if(delimiterIndex!=-1){
                delimiter = numbers.substring(2,delimiterIndex);
                numbersPart = numbers.substring(delimiterIndex+1);
            }
        }
        //splitting the numbers with ',' delimiter
        String[] numberArray = numbersPart.replace("\n",delimiter).split(delimiter);
        int sum=0;
        //calculating the sum of numbers
        for(String number : numberArray){
            if(!number.trim().isEmpty()){
                sum+=Integer.parseInt(number.trim());
            }

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
