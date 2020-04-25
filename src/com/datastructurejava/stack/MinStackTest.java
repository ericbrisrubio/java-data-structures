package com.datastructurejava.stack;

import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    MinStack stack;

    @org.junit.jupiter.api.Test
    void push() {
        stack.push(3);
        int topOfStack = stack.top();
        if (topOfStack != 3) {
            fail("Wrong value read from the top of the queue");
        }
    }

    @org.junit.jupiter.api.Test
    void pop() {
        stack.push(3);
        int popElement = stack.pop();
        if (popElement != 3) {
            fail("Wrong value fetched from the top of the queue");
        }
        if (stack.size() != 0) {
            fail("Stack should be empty");
        }
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            return;
        }
        fail("Stack should be empty");
    }

    @org.junit.jupiter.api.Test
    void top() {
        stack.push(3);
        int popElement = stack.top();
        if (popElement != 3 || stack.size() != 1) {
            fail("top method is not getting the expected value");
        }
    }

    @org.junit.jupiter.api.Test
    void getMin() {
        stack.push(3);
        if (stack.getMin() != 3) {
            fail("Wrong value fetched as minimum. Expecting 3 got "+stack.getMin());
        }
        stack.push(2);
        if (stack.getMin() != 2) {
            fail("Wrong value fetched as minimum. Expecting 2 got "+stack.getMin());
        }
        stack.push(5);
        if (stack.getMin() != 2) {
            fail("Wrong value fetched as minimum. Expecting 2 got "+stack.getMin());
        }
    }

    @BeforeEach
    void setUp() {
        stack = new MinStack();
    }
}