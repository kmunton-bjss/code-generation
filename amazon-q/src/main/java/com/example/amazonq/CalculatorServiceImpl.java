package com.example.amazonq;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  private final Calculator calculator;

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int x, int y) {
      return calculator.add(x, y);
    }

    @Override
    public int subtract(int x, int y) {
      return calculator.subtract(x, y);
    }

    @Override
    public int multiply(int x, int y) {
        return calculator.multiply(x, y);
    }

    @Override
    public int divide(int x, int y) {
        return calculator.divide(x, y);
    }

}
