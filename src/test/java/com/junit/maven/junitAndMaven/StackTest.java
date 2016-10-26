package com.junit.maven.junitAndMaven;

import businessObject.Stack;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created by User on 16.10.2016.
 */
public class StackTest {

    Stack stack;
    ResourcesReader resourcesReader;
    int arg;
    int arg2;

    @Before
    public void setUp () throws IOException{
        stack = new Stack();
        resourcesReader = new ResourcesReader();
        arg = Integer.parseInt(resourcesReader.getStackArgument("pushArgument"));
        arg2 = Integer.parseInt(resourcesReader.getStackArgument("pushArgument2"));
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void pushTest() throws IOException {
        stack.push(arg);
        assertEquals("Expected value is not equal to actual", arg, stack.peek().intValue());
    }

    @Category({StackTestsSuite.class, ExceptionTestSuite.class})
    @Test(expected = IndexOutOfBoundsException.class)
    public void pushExceptionTest() throws IOException {
        Stack stack = new Stack(0);
        stack.push(arg);
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void peekTest() throws IOException {
        stack.push(arg);
        stack.push(arg2);
        assertEquals("Expected value is not equal to actual", arg2, stack.peek().intValue());
    }

    @Category({StackTestsSuite.class, ExceptionTestSuite.class})
    @Test(expected = EmptyStackException.class)
    public void peekExceptionTest() {
        stack.peek();
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void popTest() throws IOException {
        stack.push(arg);
        stack.push(arg2);
        stack.pop();
        assertEquals("Expected value is not equal to actual", arg, stack.peek().intValue());
    }

    @Category({StackTestsSuite.class})
    @Test
    public void popNullTest() {
        assertNull("Stack should be empty, but it wasn't", stack.pop());
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void emptyTrueTest() {
        assertTrue("Actual value isn't true", stack.empty());
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void emptyFalseTest() throws IOException {
        stack.push(arg);
        assertFalse("Actual value isn't false", stack.empty());
    }

}