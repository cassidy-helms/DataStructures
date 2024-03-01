package com.data_structures.linked_list;

// Not copied directly but inspried by the code from "Data Structures and Algorithm Analysis in Java" by Mark Allen Weiss
public class LinkedList<T> {
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

    public LinkedList() {
        this.head = new Node<T>(null, null, null);  // Header Node
        this.tail = new Node<T>(null, null, head); // Tail Node
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

    public void addFirst(T element) {
        Node <T> newNode = new Node<T>(element, head.next, head);
        head.next.previous = newNode;
        head.next = newNode;
        size++;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<T>(element, tail, tail.previous);
        tail.previous.next = newNode;
        tail.previous = newNode;
        size++;
    }

    public void add(T element) {
        addLast(element);
    }

    public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for array of size " + size);
        }

        if(index == 0) {
            addFirst(element);
        } else if(index == size) {
            addLast(element);
        } else {
            Node<T> current = getNode(index);
            Node<T> newNode = new Node<T>(element, current, current.previous);
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T set(int index, T element) {
        Node<T> current  = getNode(index);
        T oldData = current.data;
        current.data = element;
        return oldData;
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }

        Node<T> current = head.next;
        head.next = current.next;
        current.next.previous = head;
        size--;

        return current.data;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }

        Node<T> current = tail.previous;
        tail.previous = current.previous;
        current.previous.next = tail;
        size--;

        return current.data;
    }

    public T remove(int index) {
        Node<T> current = getNode(index);

        if(index == 0) {
            return removeFirst();
        } else if(index == size - 1) {
            return removeLast();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }

        return current.data;
    }

    public T removeElement(T element) {
        Node<T> current = head.next;

        while(current != tail) {
            if(current.data.equals(element)) {
                if(current == head.next) {
                    head.next = current.next;
                    current.next.previous = head;
                } else if(current == tail.previous) {
                    tail.previous = current.previous;
                    current.previous.next = tail;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }

                size--;
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public int indexOf(T element) {
        Node<T> current = head.next;
        int index = 0;

        while(current != tail) {
            if(current.data.equals(element)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    private Node<T> getNode(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for array of size " + size);
        }

        Node<T> current;

        if(index < size / 2) {
            current  = head.next;

            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail.previous;

            for(int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }

        return current;
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

        if(!(obj instanceof LinkedList)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        LinkedList<T> compared = (LinkedList<T>) obj;

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
