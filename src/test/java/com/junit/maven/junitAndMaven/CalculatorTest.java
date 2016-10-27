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
    public void sumDoubleTest() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double expectedResult = Double.parseDouble(resourcesReader.getCalculatorArgument("sumDoubleTestExpected"));
        double arg1 = Double.parseDouble(resourcesReader.getCalculatorArgument("sumDoubleTestArg1"));
        double arg2 = Double.parseDouble(resourcesReader.getCalculatorArgument("sumDoubleTestArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.sum(arg1, arg2), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void subLongTest() throws IOException {
        long expectedResult = Long.parseLong(resourcesReader.getCalculatorArgument("subLongTestExpected"));
        long arg1 = Long.parseLong(resourcesReader.getCalculatorArgument("subLongTestArg1"));
        long arg2 = Long.parseLong(resourcesReader.getCalculatorArgument("subLongTestArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.sub(arg1, arg2));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void subDoubleTest() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double expectedResult = Double.parseDouble(resourcesReader.getCalculatorArgument("subDoubleTestExpected"));
        double arg1 = Double.parseDouble(resourcesReader.getCalculatorArgument("subDoubleTestArg1"));
        double arg2 = Double.parseDouble(resourcesReader.getCalculatorArgument("subDoubleTestArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.sub(arg1, arg2), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void multLongTest() throws IOException {
        long expectedResult = Long.parseLong(resourcesReader.getCalculatorArgument("multLongTestExpected"));
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("multLongTestArg"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.mult(arg, arg));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class, FailingTestsSuite.class})
    @Test
    public void multDoubleTest() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double expectedResult = Double.parseDouble(resourcesReader.getCalculatorArgument("multDoubleTestExpected"));
        double arg1 = Double.parseDouble(resourcesReader.getCalculatorArgument("multDoubleTestArg1"));
        double arg2 = Double.parseDouble(resourcesReader.getCalculatorArgument("multDoubleTestArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.mult(arg1, arg2), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void divDoubleTest() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double expectedResult = Double.parseDouble(resourcesReader.getCalculatorArgument("divDoubleTestExpected"));
        double arg1 = Double.parseDouble(resourcesReader.getCalculatorArgument("divDoubleTestArg1"));
        double arg2 = Double.parseDouble(resourcesReader.getCalculatorArgument("divDoubleTestArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.div(arg1, arg2), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class, ExceptionTestSuite.class})
    @Test (expected = NumberFormatException.class)
    public void divDoubleExceptionTest() throws IOException {
        double arg1 = Double.parseDouble(resourcesReader.getCalculatorArgument("divDoubleExceptionTestArg1"));
        double arg2 = Double.parseDouble(resourcesReader.getCalculatorArgument("divDoubleExceptionTestArg2"));
        calculator.div(arg1, arg2);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void divLongTest() throws IOException {
        long expectedResult = Long.parseLong(resourcesReader.getCalculatorArgument("divLongTestExpected"));
        long arg1 = Long.parseLong(resourcesReader.getCalculatorArgument("divLongTestArg1"));
        long arg2 = Long.parseLong(resourcesReader.getCalculatorArgument("divLongTestArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.div(arg1, arg2));
    }

    @Category({CalculatorTestSuite.class, ExceptionTestSuite.class})
    @Test (expected = NumberFormatException.class)
    public void divLongExceptionTest() throws IOException {
        long arg1 = Long.parseLong(resourcesReader.getCalculatorArgument("divLongExceptionTestArg1"));
        long arg2 = Long.parseLong(resourcesReader.getCalculatorArgument("divLongExceptionTestArg2"));
        calculator.div(arg1, arg2);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class, FailingTestsSuite.class})
    @Test
    public void pow() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double expectedResult = Double.parseDouble(resourcesReader.getCalculatorArgument("powExpected"));
        double arg1 = Double.parseDouble(resourcesReader.getCalculatorArgument("powArg1"));
        double arg2 = Double.parseDouble(resourcesReader.getCalculatorArgument("powArg2"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.pow(arg1, arg2), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void sqrtDoubleTest() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double expectedResult = Double.parseDouble(resourcesReader.getCalculatorArgument("sqrtDoubleTestExpected"));
        double arg = Double.parseDouble(resourcesReader.getCalculatorArgument("sqrtDoubleTestArg"));
        assertEquals("Expected value is not equal to actual", expectedResult, calculator.sqrt(arg), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void tg() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double arg = Double.parseDouble(resourcesReader.getCalculatorArgument("tgArg"));
        assertEquals("Expected value is not equal to actual", Math.tan(arg), calculator.tg(arg), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void ctg() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double arg = Double.parseDouble(resourcesReader.getCalculatorArgument("ctgArg"));
        assertEquals("Expected value is not equal to actual", (1.0/Math.tan(arg)), calculator.ctg(arg), DELTA);
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void cos() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double arg = Double.parseDouble(resourcesReader.getCalculatorArgument("cosArg"));
        assertEquals("Expected value is not equal to actual", (Math.cos(arg)), calculator.cos(arg), DELTA);
    }

    @Category({CalculatorTestSuite.class})
    @Test
    public void sin() throws IOException {
        final double DELTA = Double.parseDouble(resourcesReader.getCalculatorArgument("delta"));
        double arg = Double.parseDouble(resourcesReader.getCalculatorArgument("sinArg"));
        assertEquals("Expected value is not equal to actual", (Math.sin(arg)), calculator.sin(arg), DELTA);
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isPositiveTrueTest() throws IOException {
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("isPositiveTrueTestArg"));
        assertTrue("Actual value isn't true", calculator.isPositive(arg));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isPositiveFalseTest() throws IOException {
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("isPositiveFalseTestArg"));
        assertFalse("Actual value isn't false", calculator.isPositive(arg));
    }

    @Category({CalculatorTestSuite.class, FailingTestsSuite.class})
    @Test
    public void isPositiveZeroTest() throws IOException {
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("isPositiveZeroTestArg"));
        assertTrue("Actual value isn't true", calculator.isPositive(arg));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isNegativeTrueTest() throws IOException {
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("isNegativeTrueTestArg"));
        assertTrue("Actual value isn't true", calculator.isNegative(arg));
    }

    @Category({CalculatorTestSuite.class, SmokeTestsSuite.class})
    @Test
    public void isNegativeFalseTest() throws IOException {
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("isNegativeFalseTestArg"));
        assertFalse("Actual value isn't false", calculator.isNegative(arg));
    }

    @Category({CalculatorTestSuite.class})
    @Test
    public void isNegativeZeroTest() throws IOException {
        long arg = Long.parseLong(resourcesReader.getCalculatorArgument("isNegativeZeroTest"));
        assertFalse("Actual value isn't false", calculator.isNegative(arg));
    }

}