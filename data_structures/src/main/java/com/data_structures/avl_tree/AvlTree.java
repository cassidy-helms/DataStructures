package com.data_structures.avl_tree;

// Not copied directly but inspried by the code from "Data Structures and Algorithm Analysis in Java" by Mark Allen Weiss
// https://users.cs.fiu.edu/~weiss/dsaajava3/code/AvlTree.java
// Uses my BinarySearchTree.java as a base
public class AvlTree<T extends Comparable<? super T>> {
    private class AvlNode<E> {
        E element;
        AvlNode<E> left;
        AvlNode<E> right;
        int height;

        AvlNode(E element) {
            this(element, null, null);
        }

        AvlNode(E element, AvlNode<E> left, AvlNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    private AvlNode<T> root;

    public AvlTree() {
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

    private T findMin(AvlNode<T> node) {
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

    private T findMax(AvlNode<T> node) {
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

    public AvlNode<T> getRoot() {
        return root;
    }

    public int height(AvlNode<T> node) {
        if(node == null) {
            return -1;
        }

        return node.height;
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

    private AvlNode<T> insert(T element, AvlNode<T> node) {
        if(node == null) {
            return new AvlNode<T>(element);
        }

        int comparison = element.compareTo(node.element);
        if(comparison < 0) {
            node.left = insert(element, node.left);
        } else if(comparison > 0) {
            node.right = insert(element, node.right);
        }
        
        return balance(node);
    }

    private boolean contains(T element, AvlNode<T> node) {
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

    private AvlNode<T> remove(T element, AvlNode<T> node) {
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

        return balance(node);
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Comparable[size()];
        toArray(root, array, 0);
        return array;
    }

    private AvlNode<T> balance(AvlNode<T> node) {
        if(node == null) {
            return node;
        }


        /* left subtree is more than 1 level deeper than right subtree
         * 
         *                     8                8
         *                    / \              / \
         *                   6   9            6   9
         *                  /                /
         *                 4                4
         *                /                  \
         *               3                    5
        */
        if(height(node.left) - height(node.right) > 1) {
            /* insertion into the left subtree of the left child
             *
             *                    8
             *                   / \
             *                  4   9
             *                 / \
             *                3   6 
             */
            if(height(node.left.left) >= height(node.left.right)) {
                node = rotateWithLeftChild(node);
            /* insertion into the right subtree of the left child
             *
             *                    8
             *                   / \
             *                  5   9
             *                 / \
             *                4   6 
             *                  
            */ 
            } else {
                node = doubleRotateWithLeftChild(node);
            }
        /*
         * right subtree is more than 1 level deeper than left subtree
         * 
         *                    8                8
         *                   / \              / \
         *                  6  12            6  12
         *                     /                /
         *                    10               10 
         *                   /                   \
         *                  9                     11
         * 
         */
        } else if(height(node.right) - height(node.left) > 1) {
            /* insertion into the right subtree of the right child
             *
             *                    8
             *                   / \
             *                  6  10
             *                     / \
             *                    9  12 
             */
            if(height(node.right.right) >= height(node.right.left)) {
                node = rotateWithRightChild(node);
            /* insertion into the left subtree of the right child
             *
             *                    8
             *                   / \
             *                  6  11
             *                     / \
             *                    10 12 
             */
            } else {
                node = doubleRotateWithRightChild(node);
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    /*
     * 
     *                     8                8
     *                    / \              / \
     *                   6   9     =>     4   9
     *                  /                / \
     *                 4                3   6
     *                /                  
     *               3                    
     *
     * 6 is the node that is unbalanced
     * 4 is 6's left child
     * to rotate with left child, 6 becomes the right child of 4
     * 4 becomes the new root of this subtree
     * 3 remains the left child of 4
     */
    
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> x) {
        AvlNode<T> y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), x.height) + 1;
        return y;
    }

    /*
     * 
     *               8                 8
     *              / \               / \
     *             6   9        =>   6   11
     *                  \                / \
     *                   11             9   12
     *                    \
     *                     12
     *
     * 9 is the node that is unbalanced
     * 11 is 9's right child
     * to rotate with right child, 9 becomes the left child of 11
     * 11 becomes the new root of this subtree
     * 12 remains the right child of 11
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> x) {
        AvlNode<T> y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.right), x.height) + 1;
        return y;
    }

    /*
     *            8                  8                8
     *           / \                / \              / \
     *          6   9       =>     6   9    =>      5   9 
     *         /                  /                / \
     *        4                  5                4   6
     *         \                /
     *          5              4
     * 
     * 6 is the node that is unbalanced
     * 4 is 6's left child
     * rotate the left child of the unbalanced node with its right child
     * so rotate 4 with 5
     * 5 becomes the new root of this subtree
     * 4 becomes the left child of 5
     * then rotate 6 with 5
     * 5 becomes the new root of this subtree
     * 6 becomes the right child of 5
     */
    private AvlNode<T> doubleRotateWithLeftChild(AvlNode<T> x) {
        x.left = rotateWithRightChild(x.left);
        return rotateWithLeftChild(x);
    }

    /*
     *            8                  8                8
     *           / \                / \              / \
     *          6   12       =>    6   12    =>     6   11 
     *               \                 /                / \
     *               14               11               12  14
     *               /                  \
     *              11                   14
     * 
     * 12 is the node that is unbalanced
     * 14 is 12's right child
     * rotate the right child of the unbalanced node with its left child
     * so rotate 14 with 11
     * 11 becomes the new root of this subtree
     * 14 becomes the right child of 11
     * then rotate 12 with 11
     * 11 becomes the new root of this subtree
     * 12 becomes the left child of 11
     */
    private AvlNode<T> doubleRotateWithRightChild(AvlNode<T> x) {
        x.right = rotateWithLeftChild(x.right);
        return rotateWithRightChild(x);
    }

    private int toArray(AvlNode<T> node, T[] array, int index) {
        if(node != null) {
            index = toArray(node.left, array, index);
            array[index++] = node.element;
            index = toArray(node.right, array, index);
        }

        return index;
    }

    private void printTree(AvlNode<T> node) {
        if(node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }

    private int size(AvlNode<T> node) {
        if(node == null) {
            return 0;
        }

        return 1 + size(node.left) + size(node.right);
    }  

    private int countLeaves(AvlNode<T> node) {
        if(node == null) {
            return 0;
        }

        if(node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }
}
