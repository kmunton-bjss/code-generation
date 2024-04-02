package com.example.amazonq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

// Code generated by Amazon Q chat (without all the imports)
// Human intervention needed to add all the imports and fix code where it calls a nonexistent method
public class FibonacciControllerTest {

    // Human intervention - needed to add this and fix all the tests
    private final FibonacciController fibonacciController = new FibonacciController();

    @Test
    public void positiveTest() {
        // Arrange
        int number = 5;

        // Act
        List<Integer> result = fibonacciController.getFibonacciSequence(number);

        // Assert
        // Human intervention needed to fix expected result
        assertEquals(3, result.get(4));
    }

    @Test
    public void negativeTest() {
        // Arrange
        int number = -5;

        // Act & Assert
        assertThrows(ResponseStatusException.class,
            () -> fibonacciController.getFibonacciSequence(number));
    }

    // Incorrect Test generated
//    @Test
//    public void edgeCase1() {
//        // Arrange
//        int number = 0;
//
//        // Act
//        List<Integer> result = fibonacciController.getFibonacciSequence(number);
//
//        // Assert
//        assertEquals(0, result.get(0));
//    }

    // Human intervention to fix it
    @Test
    public void edgeCase1() {
        // Arrange
        int number = 0;

        // Act & Assert
        assertThrows(ResponseStatusException.class,
            () -> fibonacciController.getFibonacciSequence(number));
    }

    @Test
    public void edgeCase2() {
        // Arrange
        int number = 1;

        // Act
        List<Integer> result = fibonacciController.getFibonacciSequence(number);

        // Assert
        // Human intervention needed to fix expected result
        assertEquals(0, result.get(0));
    }

    // Code generated by AWS CodeWhisperer Autocomplete
    @Test
    public void edgeCaseNumberHigherThan20() {
        // Arrange
        int number = 21;

        // Act & Assert
        assertThrows(ResponseStatusException.class,
            () -> fibonacciController.getFibonacciSequence(number));
    }

}
