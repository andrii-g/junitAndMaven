package com.junit.maven.junitAndMaven;

import businessObject.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 16.10.2016.
 */
public class CalculatorTest {

    @Test
    public void sumLongTest() {
        Calculator calculator = new Calculator();
        assertEquals("Expected value is not equal to actual", 4294967296L, calculator.sum(2147483648L, 2147483648L));
    }

    @Test
    public void sumDoubleTest() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 5.67, calculator.sum(2.65, 3.02), DELTA);
    }

    @Test
    public void subLongTest() {
        Calculator calculator = new Calculator();
        assertEquals("Expected value is not equal to actual", 2147483648L, calculator.sub(4294967296L, 2147483648L));
    }

    @Test
    public void subDoubleTest() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", -0.37, calculator.sub(2.65, 3.02), DELTA);
    }

    @Test
    public void multLongTest() {
        Calculator calculator = new Calculator();
        assertEquals("Expected value is not equal to actual", 4611686018427387904L, calculator.mult(2147483648L, 2147483648L));
    }

    @Test
    public void multDoubleTest() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 11.0922, calculator.mult(2.78, 3.99), DELTA);
    }

    @Test
    public void divDoubleTest() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 4.0, calculator.div(20.0, 5.0), DELTA);
    }

    @Test (expected = NumberFormatException.class)
    public void divDoubleExceptionTest() {
        Calculator calculator = new Calculator();
        calculator.div(20.0, 0.0);
    }

    @Test
    public void divLongTest() {
        Calculator calculator = new Calculator();
        assertEquals("Expected value is not equal to actual", 4L, calculator.div(20L, 5L));
    }

    @Test (expected = NumberFormatException.class)
    public void divLongExceptionTest() {
        Calculator calculator = new Calculator();
        calculator.div(20L, 0L);
    }

    @Test
    public void pow() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-5;
        assertEquals("Expected value is not equal to actual", 247.684822619, calculator.pow(3.5, 4.4), DELTA);
    }

    @Test
    public void sqrtDoubleTest() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 8.8, calculator.sqrt(77.44), DELTA);
    }

    @Test
    public void tg() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-5;
        assertEquals("Expected value is not equal to actual", Math.tan(45), calculator.tg(45), DELTA);
    }

    @Test
    public void ctg() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", (1.0/Math.tan(0.5)), calculator.ctg(0.5), DELTA);
    }

    @Test
    public void cos() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", (Math.cos(45)), calculator.cos(45), DELTA);
    }

    @Test
    public void sin() {
        Calculator calculator = new Calculator();
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", (Math.sin(45)), calculator.sin(45), DELTA);
    }

    @Test
    public void isPositiveTrueTest() {
        Calculator calculator = new Calculator();
        assertTrue("Actual value isn't true", calculator.isPositive(4294967296L));
    }

    @Test
    public void isPositiveFalseTest() {
        Calculator calculator = new Calculator();
        assertFalse("Actual value isn't false", calculator.isPositive(-4294967296L));
    }

    @Test
    public void isPositiveZeroTest() {
        Calculator calculator = new Calculator();
        assertTrue("Actual value isn't true", calculator.isPositive(-0L));
    }

    @Test
    public void isNegativeTrueTest() {
        Calculator calculator = new Calculator();
        assertTrue("Actual value isn't true", calculator.isNegative(-2));
    }


    @Test
    public void isNegativeFalseTest() {
        Calculator calculator = new Calculator();
        assertFalse("Actual value isn't false", calculator.isNegative(4294967296L));
    }

    @Test
    public void isNegativeZeroTest() {
        Calculator calculator = new Calculator();
        assertFalse("Actual value isn't false", calculator.isNegative(0L));
    }

}