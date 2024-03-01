package com.data_structures.stack;

// Not copied directly but inspried by the code from "Data Structures and Algorithm Analysis in Java" by Mark Allen Weiss
// Manual implementation of a stack data structure
// Based on my manual implementation of an ArrayList
public class Stack<T> {
    private int DEFAULT_CAPACITY = 10;
    private Object[] list;
    private int topOfStack;

    public Stack() {
        this.list = new Object[DEFAULT_CAPACITY];
        this.topOfStack = -1;
    }

    public int size() {
        return topOfStack + 1;
    }

    public boolean isEmpty() {
        return this.topOfStack == -1;
    }

    public void clear() {
        this.list = new Object[DEFAULT_CAPACITY];
        this.topOfStack = -1;
    }

    public void push(T element) {
        if(list.length == topOfStack + 1) {
            increaseCapacity();
        }

        list[topOfStack + 1] = element;
        topOfStack++;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if(isEmpty()) {
            return null;
        }

        return (T) list[topOfStack];
    }

    public T pop() {
        if(isEmpty()) {
            return null;
        }

        @SuppressWarnings("unchecked")
        T element = (T)list[topOfStack];
        list[topOfStack] = null;
        topOfStack--;

        return element;
    }

    public int search(T element) {
        for(int i = 0; i <= topOfStack; i++) {
            if(list[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(T element) {
        return search(element) != -1;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[topOfStack + 1];
        for(int i = 0; i <= topOfStack; i++) {
            array[i] = (T) list[i];
        }

        return array;
    }

    @Override
    public String toString() {
        if(topOfStack == -1) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder(topOfStack).append("[");
        for(int i = 0; i < topOfStack; i++) {
            sb.append(list[i]).append(", ");
        }

        return sb.append(list[topOfStack]).append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof Stack)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Stack<T> stack = (Stack<T>) o;
        if(topOfStack != stack.topOfStack) {
            return false;
        }

        for(int i = 0; i <= topOfStack; i++) {
            if(!list[i].equals(stack.list[i])) {
                return false;
            }
        }

        return true;
    }

    private void increaseCapacity() {
        if(list.length == topOfStack + 1) {
            Object[] newList = new Object[list.length * 2];
        
            for(int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
    
            list = newList;
        }
    }
}
