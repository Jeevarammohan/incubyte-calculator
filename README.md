# TDD Assignment for Software Craftsperson - Fullstack Role

## Overview
This repository contains my solution to the TDD assignment for the Software Craftsperson - Fullstack role at Incubyte. The assignment demonstrates my approach to Test-Driven Development (TDD) by solving the given problem using the steps outlined in the assignment description.

## How to Run the Code

### Prerequisites:
- Java 17
- Maven (for building and running the project)

### Steps to Run:
1. Clone this repository:

    ```bash
    git clone https://github.com/Jeevarammohan/incubyte-calculator/
    ```

2. Navigate to the project directory:

    ```bash
    cd incubyte-calculator
    ```

3. Build and run the project using Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## TDD Process

### Approach:
- **Test First**: I began by writing unit tests for the problem before writing any implementation code.
- **Red-Green-Refactor Cycle**:
    - **Red**: Write a failing test that defines a function or improvement.
    - **Green**: Write just enough code to make the test pass.
    - **Refactor**: Clean up the code while keeping the tests green.

### Commit Strategy:
I committed frequently, ensuring that each commit shows a small step in the development process, illustrating the progression from writing the first test to completing the solution.

## Tests:
The tests validate core functionality and edge cases as defined in the assignment.

### Key tests include:
- Validating the handling of multiple delimiters
- Testing for edge cases such as empty input or single-element input

## Code Explanation

The solution is written in Java using the Spring Boot framework. The core logic is implemented in the `CalculatorService` class, which handles the parsing of input strings and the execution of mathematical operations. The `CalculatorController` class exposes a REST API endpoint to accept the input, invoke the service, and return the result.

The TDD approach ensured that each function was thoroughly tested and verified before moving on to the next step.

## Resources
- [TDD Video Guide](https://www.youtube.com/watch?v=qkblc5WRn-U&t=3s) (for understanding TDD principles)
- [Incubyte Inspiration Page](https://incubyte.co/inspiration) for best practices and concepts

## Future Improvements
- I could optimize the string parsing logic to handle larger input sizes more efficiently.
- A more advanced feature could include supporting floating-point numbers or adding additional operations like subtraction and multiplication.

## Conclusion
This solution follows TDD principles and demonstrates the incremental development process. I’ve committed each step of the process to show how the code evolved, from writing the first test to finalizing the solution.
