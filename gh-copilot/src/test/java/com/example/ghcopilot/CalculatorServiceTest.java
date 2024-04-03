package com.example.ghcopilot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertThat(calculatorService.add(1, 2), is(3));
    }

    @Test
    void testSubtract() {
        assertThat(calculatorService.subtract(2, 1), is(1));
    }

    @Test
    void testMultiply() {
        assertThat(calculatorService.multiply(1, 2), is(2));
    }

    @Test
    void testDivide() {
        assertThat(calculatorService.divide(4, 2), is(2));
    }
}
