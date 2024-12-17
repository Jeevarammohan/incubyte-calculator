package com.assignment.calculator.controller;

import com.assignment.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * A controller that exposes endpoints for performing calculator operations.
 * Currently, it supports adding a series of numbers via a POST request.
 */
@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {


    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    /**
     * Endpoint to add numbers from a string input.
     * @author Jeeva R
     * @param numbers A string containing numbers separated by commas or custom delimiters.
     * @return The sum of the numbers or an error message if there are invalid numbers.
     */
    @PostMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestBody String numbers){
        try {
            // Calling the service to add the numbers and get the sum
            int sum = calculatorService.addNumber(numbers);
            return ResponseEntity.ok("Sum is: " + sum);
        } catch (IllegalArgumentException e) {
            // If negative numbers are found, returning a bad request with an appropriate error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
