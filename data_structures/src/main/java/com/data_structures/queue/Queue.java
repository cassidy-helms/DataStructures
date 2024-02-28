package com.data_structures.queue;

// Manual impelementation of a queue data structure
// Based on my manual implementation of a linked list
public class Queue<T> {
    private class Node<E> {
        public T data;
        public Node<E> next;
        public Node<E> previous;

        public Node(T data, Node<E> next, Node<E> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        this.head = new Node<T>(null, null, null);
        this.tail = new Node<T>(null, null, head);
        this.head.next = tail;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head.next = tail;
        this.tail.previous = head;
        this.size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<T>(element, tail, tail.previous);
        tail.previous.next = newNode;
        tail.previous = newNode;
        size++;
    }

    public T element() {
        if(size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return head.next.data;
    }

    public T peek() {
        if(size == 0) {
            return null;
        }

        return head.next.data;
    }

    public T poll() {
        if(size == 0) {
            return null;
        }

        Node<T> current = head.next;
        head.next = current.next;
        current.next.previous = head;
        size--;

        return current.data;
    }

    public T remove() {
        if(size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        Node<T> current = head.next;
        head.next = current.next;
        current.next.previous = head;
        size--;

        return current.data;
    }

    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> current = head.next;
        while(current != tail) {
            sb.append(current.data);
            if(current.next != tail) {
                sb.append(", ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Queue)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Queue<T> compared = (Queue<T>) obj;

        if(this.size != compared.size) {
            return false;
        }

        Node<T> current = head.next;
        Node<T> comparedCurrent = compared.head.next;

        while(current != tail) {
            if(!current.data.equals(comparedCurrent.data)) {
                return false;
            }

            current = current.next;
            comparedCurrent = comparedCurrent.next;
        }

        return true;
    }

    public boolean contains(T element) {
        Node<T> current = head.next;

        while(current != tail) {
            if(current.data.equals(element)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        Node<T> current = head.next;

        for(int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
    }
}
