package com.Spring.StackWithObjects;

import java.lang.Object;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stack {

    @Id
    private int stackID;
    private int size;
    private int topIndex = -1;
    private Object[] stack;

    public Stack() {
        super();
    }

    public Stack(int stackID, int size) {
        this.stackID = stackID;
        this.size = size;
        this.stack = new Object[size];
    }

    public void push(Object o){
        this.topIndex++;
        System.out.println(topIndex);
        this.stack[topIndex] = o;
    }

    public Object pop(){
        Object popped = this.stack[topIndex];
        this.topIndex--;
        return popped;
    }

    public int getStackID() {
        return stackID;
    }

    public void setStackID(int stackID) {
        this.stackID = stackID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTopIndex() {
        return topIndex;
    }

    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stackID=" + stackID +
                ", size=" + size +
                ", topIndex=" + topIndex +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
}

