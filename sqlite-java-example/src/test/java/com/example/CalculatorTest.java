package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Calculator;

public class CalculatorTest {



     @Test
    public void testINICIALIZAR() {
        Calculator calculator = new Calculator();
        calculator.inicializarTESTE();        
        calculator.enviarRespostaTESTE();     
    }
}


