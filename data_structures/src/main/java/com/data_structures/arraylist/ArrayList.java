package com.data_structures.arraylist;

public class ArrayList<T> {
    private int DEFAULT_CAPACITY = 10;
    private Object[] list;
    private int size;

    public ArrayList() {
        this.list = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.list = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if(size == list.length) {
            increaseCapacity();
        }

        list[size] = element;
        size++;
    }

    public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for array of size " + size);
        }

        if(size == list.length) {
            increaseCapacity();
        }

        for(int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = element;
        size++;
    }

    public Object get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for array of size " + size);
        }

        return list[index];
    }

    public Object set(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for array of size " + size);
        }

        Object oldValue = list[index];
        list[index] = element;

        return oldValue;
    }

    public Object remove(int index) {
        if(index < 0 || index > size || size == 0) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for array of size " + size);
        }

        Object removedValue = list[index];

        for(int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;

        return removedValue;
    }

    public boolean remove(T element) {
        for(int i = 0; i < size; i++) {
            if(list[i].equals(element)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    public int indexOf(T element) {
        for(int i = 0; i < size; i++) {
            if(list[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        for(int i = 0; i < size; i++) {
            array[i] = (T) list[i];
        }

        return array;
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder(size).append("[");
        for(int i = 0; i < size - 1; i++) {
            sb.append(list[i]).append(", ");
        }

        return sb.append(list[size - 1]).append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof ArrayList)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        ArrayList<T> arrayList = (ArrayList<T>) o;
        if(size != arrayList.size) {
            return false;
        }

        for(int i = 0; i < size; i++) {
            if(!list[i].equals(arrayList.list[i])) {
                return false;
            }
        }

        return true;
    }

    private void increaseCapacity() {
        if(size == list.length) {
            Object[] newList = new Object[list.length * 2];
        
            for(int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
    
            list = newList;
        }
    }
}
