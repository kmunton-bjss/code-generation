// src/calculator.ts
import fetch from 'node-fetch';

interface OperationResponse {
  result: number;
}

class Calculator {
  private baseUrl: string;

  constructor(baseUrl: string = 'http://localhost:3000') {
    this.baseUrl = baseUrl;
  }

  private async performOperation(operation: string, a: number, b: number): Promise<number | string> {
    const url = `${this.baseUrl}/${operation}?a=${encodeURIComponent(a)}&b=${encodeURIComponent(b)}`;
    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error(`Server responded with status: ${response.status}`);
      }
      const data: OperationResponse = await response.json();
      return data.result;
    } catch (error) {
      console.error('Error performing operation:', error);
      return 'Invalid input';
    }
  }

  public add(a: number, b: number): Promise<number | string> {
    return this.performOperation('add', a, b);
  }

  public subtract(a: number, b: number): Promise<number | string> {
    return this.performOperation('subtract', a, b);
  }

  public multiply(a: number, b: number): Promise<number | string> {
    return this.performOperation('multiply', a, b);
  }

  public divide(a: number, b: number): Promise<number | string> {
    return this.performOperation('divide', a, b);
  }
}

export default Calculator;
