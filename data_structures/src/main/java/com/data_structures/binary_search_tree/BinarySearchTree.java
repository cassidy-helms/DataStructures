package com.data_structures.binary_search_tree;

// Not copied directly but inspried by the code from "Data Structures and Algorithm Analysis in Java" by Mark Allen Weiss
// https://users.cs.fiu.edu/~weiss/dsaajava3/code/BinarySearchTree.java
public class BinarySearchTree<T extends Comparable<? super T>> {
    private class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;

        BinaryNode(E element) {
            this(element, null, null);
        }

        BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    public void remove(T element) {
        root = remove(element, root);
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(BinaryNode<T> node) {
        if(node == null) {
            return null;
        } else if(node.left == null) {
            return node.element;
        }

        return findMin(node.left);
    }

    public T findMax() {
        return findMax(root);
    }

    private T findMax(BinaryNode<T> node) {
        if(node == null) {
            return null;
        } else if (node.right == null) {
            return node.element;
        }

        return findMax(node.right);
    }

    public boolean contains(T element) {
        return contains(element, root);
    }

    public void printTree() {
        printTree(root);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public int height() {
        return height(root);
    }

    public int size() {
        return size(root);
    }

   public int countLeaves() {
        return countLeaves(root);
    }

    private BinaryNode<T> insert(T element, BinaryNode<T> node) {
        if(node == null) {
            return new BinaryNode<T>(element);
        }

        int comparison = element.compareTo(node.element);
        if(comparison < 0) {
            node.left = insert(element, node.left);
        } else if(comparison > 0) {
            node.right = insert(element, node.right);
        }
        
        return node;
    }

    private boolean contains(T element, BinaryNode<T> node) {
        if(node == null) {
            return false;
        }

        int comparison = element.compareTo(node.element);
        if(comparison < 0) {
            return contains(element, node.left);
        } else if(comparison > 0) {
            return contains(element, node.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> remove(T element, BinaryNode<T> node) {
        if(node == null) {
            return node;
        }

        int comparison = element.compareTo(node.element);
        if(comparison < 0) {
            node.left = remove(element, node.left);
        } else if(comparison > 0) {
            node.right = remove(element, node.right);
        } else {
            if(node.left != null && node.right != null) {
                // Two children
                // Replace the node with the smallest node in the right subtree
                node.element = findMin(node.right);
                node.right = remove(node.element, node.right);
            } else {
                // Only one child
                // Set the node equal to its child
                node = (node.left != null) ? node.left : node.right;
            }
        }

        return node;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Comparable[size()];
        toArray(root, array, 0);
        return array;
    }

    private int toArray(BinaryNode<T> node, T[] array, int index) {
        if(node != null) {
            index = toArray(node.left, array, index);
            array[index++] = node.element;
            index = toArray(node.right, array, index);
        }

        return index;
    }

    private void printTree(BinaryNode<T> node) {
        if(node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }

    private int height(BinaryNode<T> node) {
        if(node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int size(BinaryNode<T> node) {
        if(node == null) {
            return 0;
        }

        return 1 + size(node.left) + size(node.right);
    }  

    private int countLeaves(BinaryNode<T> node) {
        if(node == null) {
            return 0;
        }

        if(node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }
}
