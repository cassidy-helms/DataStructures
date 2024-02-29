package data_structures.binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.data_structures.binary_search_tree.BinarySearchTree;

public class BinarySearchTreeTest {
    /*
     * Test isEmpty() method
     */
    @Test
    public void testIsEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(bst.isEmpty());
    }

    @Test
    public void testIsEmptyAfterInsert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        assert(!bst.isEmpty());
    }

    /*
     * Test makeEmpty() method
     */
    @Test
    public void testMakeEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.makeEmpty();
        assert(bst.isEmpty());
    }

    @Test
    public void testMakeEmptyWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.makeEmpty();
        assert(bst.isEmpty());
    }

    /*
     * Test insert() method
     */
    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.findMin() == 2);
        assert(bst.findMax() == 8);
        assert(bst.height() == 2);
        assert(bst.size() == 7);
        assert(bst.countLeaves() == 4);
        assertArrayEquals(new Integer[] {2, 3, 4, 5, 6, 7, 8}, bst.toArray());
    }

    /*
     * Test remove() method
     */
    @Test
    public void testRemoveLeaves() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        bst.remove(2);
        bst.remove(6);
        assert(bst.findMin() == 3);
        assert(bst.findMax() == 8);
        assert(bst.height() == 2);
        assert(bst.size() == 5);
        assert(bst.countLeaves() == 2);
        assertArrayEquals(new Integer[] {3, 4, 5, 7, 8}, bst.toArray());
    }

    @Test
    public void testRemoveWithOneChild() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(6);
        bst.remove(2);
        bst.remove(6);
        assert(bst.findMin() == 3);
        assert(bst.findMax() == 7);
        assert(bst.height() == 1);
        assert(bst.size() == 3);
        assert(bst.countLeaves() == 2);
        assertArrayEquals(new Integer[] {3, 5, 7}, bst.toArray());
    }

    @Test
    public void testRemoveWithTwoChildren() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        bst.remove(3);
        bst.remove(7);
        assert(bst.findMin() == 2);
        assert(bst.findMax() == 8);
        assert(bst.height() == 2);
        assert(bst.size() == 5);
        assert(bst.countLeaves() == 2);
        assertArrayEquals(new Integer[] {2, 4, 5, 6, 8}, bst.toArray());
    }
}
