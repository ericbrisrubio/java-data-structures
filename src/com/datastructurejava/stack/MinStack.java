package com.datastructurejava.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

class MinStack implements IStack {

    private LinkedList<StackNode> data;
    private int size;

    public MinStack() {
        this.data = new LinkedList<StackNode>();
    }

    public void push(int x) {
        int minValue = x;
        int currentMin;
        if (this.data.size() > 0) {
            currentMin = this.getMin();
            if (currentMin < minValue) {
                minValue = currentMin;
            }
        }
        this.data.addFirst(new StackNode(minValue, x));
        this.size+=1;
    }

    public int pop() throws EmptyStackException{
        if (this.data.size() == 0) {
            throw new EmptyStackException();
        }
        var first = this.data.getFirst();
        this.data.removeFirst();
        this.size-=1;
        return first.value;
    }

    public int top() {
        return this.data.getFirst().value;
    }

    public int getMin() {
        int first = this.data.getFirst().minValue;
        return first;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class StackNode {
        int minValue, value;

        StackNode(int minValue, int value) {
            this.minValue = minValue;
            this.value = value;
        }
    }
}
