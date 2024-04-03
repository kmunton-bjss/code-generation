package com.example.amazonq;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        assertThat(calculatorService.add(1, 2), is(3));
    }

    @Test
    public void testSubtract() {
        assertThat(calculatorService.subtract(2, 1), is(1));
    }

    @Test
    public void testMultiply() {
        assertThat(calculatorService.multiply(1, 2), is(2));
    }

    @Test
    public void testDivide() {
        assertThat(calculatorService.divide(4, 2), is(2));
    }
}
