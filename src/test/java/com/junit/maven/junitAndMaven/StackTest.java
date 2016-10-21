package com.junit.maven.junitAndMaven;

import businessObject.Stack;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created by User on 16.10.2016.
 */
public class StackTest {

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void del() {

        ResourcesReader resourcesReader = new ResourcesReader();
        try{
            resourcesReader.getResources();
        }catch (IOException e){
            e.printStackTrace();
        }

        Stack stack = new Stack();
        stack.push(3);
        assertEquals("Expected value is not equal to actual", 3, stack.peek().intValue());
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void pushTest() {
        Stack stack = new Stack();
        stack.push(3);
        assertEquals("Expected value is not equal to actual", 3, stack.peek().intValue());
    }

    @Category({StackTestsSuite.class, ExceptionTestSuite.class})
    @Test(expected = IndexOutOfBoundsException.class)
    public void pushExceptionTest() {
        Stack stack = new Stack(0);
        stack.push(1);
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void peekTest() {
        Stack stack = new Stack();
        stack.push(11);
        stack.push(22);
        assertEquals("Expected value is not equal to actual", 22, stack.peek().intValue());
    }

    @Category({StackTestsSuite.class, ExceptionTestSuite.class})
    @Test(expected = EmptyStackException.class)
    public void peekExceptionTest() {
        Stack stack = new Stack();
        stack.peek();
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void popTest() {
        Stack stack = new Stack();
        stack.push(11);
        stack.push(22);
        stack.pop();
        assertEquals("Expected value is not equal to actual", 11, stack.peek().intValue());
    }

    @Category({StackTestsSuite.class})
    @Test
    public void popNullTest() {
        Stack stack = new Stack();
        assertNull("Stack should be empty, but it wasn't", stack.pop());
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void emptyTrueTest() {
        Stack stack = new Stack();
        assertTrue("Actual value isn't true", stack.empty());
    }

    @Category({SmokeTestsSuite.class, StackTestsSuite.class})
    @Test
    public void emptyFalseTest() {
        Stack stack = new Stack();
        stack.push(5);
        assertFalse("Actual value isn't false", stack.empty());
    }

}