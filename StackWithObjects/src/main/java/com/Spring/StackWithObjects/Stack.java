package com.Spring.StackWithObjects;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.lang.Object;
import java.util.Arrays;
import javax.persistence.*;

@Entity
public class Stack<T> {

    @Id
    private int stackID;
    private int size;
    private int topIndex = -1;
    private String type;
//    @OneToMany(targetEntity = Stack.class)
//    @JoinColumns({
//            @JoinColumn(
//                    name = "event_id",
//                    referencedColumnName = "event_id", insertable = false, updatable = false)
//    })
//    @OneToMany(targetEntity = )
    @Transient
    private T[] stack;



    public Stack() {
    }

    public Stack(int stackID, int size, T[] arr) {
        this.stackID = stackID;
        this.size = size;
        this.stack = arr;  //(T[]) new Object[size];
        this.type =  stack.getClass().getSimpleName();
    }

    public void push(T o){
        this.topIndex++;
        System.out.println(topIndex);
        this.stack[topIndex] = o;
    }

    public T pop(){
        T popped = this.stack[topIndex];
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

    public T[] getStack() {
        System.out.println(stack);
        return stack;
    }

    public void setStack(T[] stack) {
        this.stack = stack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

