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

    /*
     * Test findMin() method
     */
    @Test
    public void testFindMin() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.findMin() == 2);
    }

    @Test
    public void testFindMinWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(bst.findMin() == null);
    }

    @Test
    public void testFindMineOneElement() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        assert(bst.findMin() == 5);
    }

    /*
     * Test findMax() method
     */
    @Test
    public void testFindMax() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.findMax() == 8);
    }

    @Test
    public void testFindMaxWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(bst.findMax() == null);
    }

    @Test
    public void testFindMaxOneElement() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        assert(bst.findMax() == 5);
    }

    /*
     * Test contains() method
     */
    @Test
    public void testContains() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.contains(5));
        assert(bst.contains(3));
        assert(bst.contains(7));
        assert(bst.contains(2));
        assert(bst.contains(4));
        assert(bst.contains(6));
        assert(bst.contains(8));
    }

    @Test
    public void testContainsWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(!bst.contains(5));
    }

    /*
     * Test height() method
     */
    @Test
    public void testHeight() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.height() == 2);
    }

    @Test
    public void testHeightWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(bst.height() == -1);
    }

    @Test
    public void testHeightOneElement() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        assert(bst.height() == 0);
    }

    /*
     * Test size() method
     */
    @Test
    public void testSize() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.size() == 7);
    }

    @Test
    public void testSizeWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(bst.size() == 0);
    }

    /*
     * Test countLeaves() method
     */
    @Test
    public void testCountLeaves() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assert(bst.countLeaves() == 4);
    }

    @Test
    public void testCountLeavesWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assert(bst.countLeaves() == 0);
    }

    /*
     * Test toArray() method
     */
    @Test
    public void testToArray() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assertArrayEquals(new Integer[] {2, 3, 4, 5, 6, 7, 8}, bst.toArray());
    }

    @Test
    public void testToArrayWhenEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertArrayEquals(new Integer[] {}, bst.toArray());
    }
}
