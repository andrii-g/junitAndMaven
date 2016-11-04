package com.junit.maven.junitAndMaven;

import businessObject.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrii_Grygoruk on 11/4/2016.
 */
@RunWith(Parameterized.class)
public class CalculatorParamsTest {

    private double expected;
    private double value1;
    private double value2;
    final double DELTA = 1e-15;
    Calculator calc;

    public CalculatorParamsTest(double expected, double value1, double value2){
        this.expected = expected;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Parameters
    public static Collection<Object[]> testData() {
        Object[][] data = new Object[][]{{6.5,2.3,4.2}, {15.8,8.1,7.7}, {28.0,2.0,26.0}};
        return Arrays.asList(data);
    }

    @Test
    public void testSumDouble(){
        assertEquals(expected, calc.sum(value1, value2), DELTA);
    }
}