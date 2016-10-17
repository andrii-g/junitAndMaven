package com.junit.maven.junitAndMaven;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Andrii_Grygoruk on 10/17/2016.
 */
@RunWith(Categories.class)
@Suite.SuiteClasses({CalculatorTest.class})
public class CalculatorTestSuite {

}
