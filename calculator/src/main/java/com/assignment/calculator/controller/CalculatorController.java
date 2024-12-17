package com.assignment.calculator.controller;

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


    @PostMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestBody String numbers){
        return ResponseEntity.ok("Sum is: " );
    }

}
