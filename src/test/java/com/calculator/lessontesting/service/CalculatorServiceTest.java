package com.calculator.lessontesting.service;

import com.calculator.lessontesting.controller.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {


     CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForTestsPlus")
    void plus(int rez,int num1, int num2) {
        int rezultat = calculatorService.plus(num1,num2);
        assertEquals(rez, rezultat);
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsMinus")
    void minus(int rez,int num1, int num2) {
        int rezultat = calculatorService.minus(num1,num2);
        assertEquals(rez, rezultat);
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsMultiply")
    void multiply(int rez,int num1, int num2) {
        int rezultat = calculatorService.multiply(num1,num2);
        assertEquals(rez, rezultat);
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsDivide")
    void divide(int rez,int num1, int num2) {
        int rezultat = calculatorService.divide(num1,num2);
        assertEquals(rez, rezultat);
    }

    @Test
     void divide() {
        assertThrows(ArithmeticException.class,()->calculatorService.divide(5,0));
    }

    public static Stream<Arguments> paramsForTestsPlus() {
        return Stream.of(
                Arguments.of(2, 1, 1),
                Arguments.of(4, 2, 2),
                Arguments.of(6, 3, 3),
                Arguments.of(3, 3, 0)
    );
    }

    public static Stream<Arguments> paramsForTestsMinus() {
        return Stream.of(
                Arguments.of(1, 2, 1),
                Arguments.of(2, 4, 2)
        );
    }

    public static Stream<Arguments> paramsForTestsMultiply() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(24, 8, 3)
                );
    }
    public static Stream<Arguments> paramsForTestsDivide() {
        return Stream.of(
                Arguments.of(2, 4, 2),
                Arguments.of(1, 8, 8)
                );
    }

}