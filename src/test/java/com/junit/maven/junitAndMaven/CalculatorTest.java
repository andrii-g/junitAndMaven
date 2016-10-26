package com.junit.maven.junitAndMaven;

import businessObject.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by User on 16.10.2016.
 */

public class CalculatorTest {

    Calculator calculator;
    ResourcesReader resourcesReader;

    @Before
    public void setUp() throws IOException {
        calculator = new Calculator();
        resourcesReader = new ResourcesReader();
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void sumLongTest() throws IOException {
        long expectedResult = Long.parseLong(resourcesReader.getCalculatorArgument("sumLongTestExpected"));
        long sumArgument = Long.parseLong(resourcesReader.getCalculatorArgument("sumLongTestArg"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.sum(sumArgument, sumArgument));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void sumDoubleTest() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 5.67, calculator.sum(2.65, 3.02), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void subLongTest() {
        assertEquals("Expected value is not equal to actual", 2147483648L, calculator.sub(4294967296L, 2147483648L));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void subDoubleTest() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", -0.37, calculator.sub(2.65, 3.02), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void multLongTest() {
        assertEquals("Expected value is not equal to actual", 4611686018427387904L, calculator.mult(2147483648L, 2147483648L));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class, FailingTestsSuite.class})
    @Test
    public void multDoubleTest() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 11.0922, calculator.mult(2.78, 3.99), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void divDoubleTest() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 4.0, calculator.div(20.0, 5.0), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class, ExceptionTestSuite.class})
    @Test (expected = NumberFormatException.class)
    public void divDoubleExceptionTest() {
        calculator.div(20.0, 0.0);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void divLongTest() {
        assertEquals("Expected value is not equal to actual", 4L, calculator.div(20L, 5L));
    }

    @Category({CalculatorTestSuite.class, ExceptionTestSuite.class})
    @Test (expected = NumberFormatException.class)
    public void divLongExceptionTest() {
        calculator.div(20L, 0L);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class, FailingTestsSuite.class})
    @Test
    public void pow() {
        final double DELTA = 1e-5;
        assertEquals("Expected value is not equal to actual", 247.684822619, calculator.pow(3.5, 4.4), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void sqrtDoubleTest() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", 8.8, calculator.sqrt(77.44), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void tg() {
        final double DELTA = 1e-5;
        assertEquals("Expected value is not equal to actual", Math.tan(45), calculator.tg(45), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void ctg() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", (1.0/Math.tan(0.5)), calculator.ctg(0.5), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void cos() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", (Math.cos(45)), calculator.cos(45), DELTA);
    }

    @Category({CalculatorTestSuite.class})
    @Test
    public void sin() {
        final double DELTA = 1e-15;
        assertEquals("Expected value is not equal to actual", (Math.sin(45)), calculator.sin(45), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isPositiveTrueTest() {
        assertTrue("Actual value isn't true", calculator.isPositive(4294967296L));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isPositiveFalseTest() {
        assertFalse("Actual value isn't false", calculator.isPositive(-4294967296L));
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void isPositiveZeroTest() {
        assertTrue("Actual value isn't true", calculator.isPositive(-0L));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isNegativeTrueTest() {
        assertTrue("Actual value isn't true", calculator.isNegative(-2));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isNegativeFalseTest() {
        assertFalse("Actual value isn't false", calculator.isNegative(4294967296L));
    }

    @Category({CalculatorTestSuite.class})
    @Test
    public void isNegativeZeroTest() {
        assertFalse("Actual value isn't false", calculator.isNegative(0L));
    }

}