package com.assignment.calculator.controller;

import com.assignment.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestBody String numbers){
        int sum = calculatorService.addNumber(numbers);
        return ResponseEntity.ok("Sum is: "+sum );
    }

}
