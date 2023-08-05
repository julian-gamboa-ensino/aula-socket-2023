package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Calculator;

public class CalculatorTest {
/*
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

*/


     @Test
    public void testINICIALIZAR() {
        Calculator calculator = new Calculator();
        calculator.inicializarTESTE();        
        calculator.enviarRespostaTESTE();     
    }
}


