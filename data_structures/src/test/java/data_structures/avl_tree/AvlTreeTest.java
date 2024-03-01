package data_structures.avl_tree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.data_structures.avl_tree.AvlTree;

public class AvlTreeTest {
    /*
     * Test isEmpty() method
     */
    @Test
    public void testIsEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(avl.isEmpty());
    }

    @Test
    public void testIsEmptyAfterInsert() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(!avl.isEmpty());
    }

    /*
     * Test makeEmpty() method
     */
    @Test
    public void testMakeEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.makeEmpty();
        assert(avl.isEmpty());
    }

    @Test
    public void testMakeEmptyWhenEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.makeEmpty();
        assert(avl.isEmpty());
    }

    /*
     * Test insert() method
     */
    @Test
    public void testInsert() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.findMin() == 2);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 7);
        assert(avl.countLeaves() == 4);
        assertArrayEquals(new Integer[] {2, 3, 4, 5, 6, 7, 8}, avl.toArray());
    }

    @Test
    public void testInsertDuplicate() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.insert(5);
        assert(avl.findMin() == 2);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 7);
        assert(avl.countLeaves() == 4);
        assertArrayEquals(new Integer[] {2, 3, 4, 5, 6, 7, 8}, avl.toArray());
    }

    @Test
    public void testInsertRotateLeftChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(9);
        avl.insert(4);
        avl.insert(3);
        assert(avl.findMin() == 3);
        assert(avl.findMax() == 9);
        assert(avl.height() == 2);
        assert(avl.size() == 5);
        assert(avl.countLeaves() == 3);
        assertArrayEquals(new Integer[] {3, 4, 6, 8, 9}, avl.toArray());
    }

    @Test
    public void testInsertRotateRightChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(9);
        avl.insert(10);
        avl.insert(11);
        assert(avl.findMin() == 6);
        assert(avl.findMax() == 11);
        assert(avl.height() == 2);
        assert(avl.size() == 5);
        assert(avl.countLeaves() == 3);
        assertArrayEquals(new Integer[] {6, 8, 9, 10, 11}, avl.toArray());
    }

    @Test
    public void testInsertDoubleRotateLeftChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(9);
        avl.insert(4);
        avl.insert(5);
        assert(avl.findMin() == 4);
        assert(avl.findMax() == 9);
        assert(avl.height() == 2);
        assert(avl.size() == 5);
        assert(avl.countLeaves() == 3);
        assertArrayEquals(new Integer[] {4, 5, 6, 8, 9}, avl.toArray());
    }

    @Test
    public void testInsertDoubleRotateRightChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(12);
        avl.insert(10);
        avl.insert(11);
        assert(avl.findMin() == 6);
        assert(avl.findMax() == 12);
        assert(avl.height() == 2);
        assert(avl.size() == 5);
        assert(avl.countLeaves() == 3);
        assertArrayEquals(new Integer[] {6, 8, 10, 11, 12}, avl.toArray());
    }

    /*
     * Test remove() method
     */
    @Test
    public void testRemove() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.remove(2);
        avl.remove(6);
        assert(avl.findMin() == 3);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 5);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {3, 4, 5, 7, 8}, avl.toArray());
    }

    @Test
    public void testRemoveWithOneChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(6);
        avl.remove(2);
        avl.remove(6);
        assert(avl.findMin() == 3);
        assert(avl.findMax() == 7);
        assert(avl.height() == 1);
        assert(avl.size() == 3);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {3, 5, 7}, avl.toArray());
    }

    @Test
    public void testRemoveWithTwoChildren() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.remove(3);
        avl.remove(7);
        assert(avl.findMin() == 2);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 5);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {2, 4, 5, 6, 8}, avl.toArray());
    }

    @Test
    public void testRemoveRoot() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.remove(5);
        assert(avl.findMin() == 2);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 6);
        assert(avl.countLeaves() == 3);
        assertArrayEquals(new Integer[] {2, 3, 4, 6, 7, 8}, avl.toArray());
    }

    @Test
    public void testRemoveAll() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.remove(2);
        avl.remove(3);
        avl.remove(4);
        avl.remove(5);
        avl.remove(6);
        avl.remove(7);
        avl.remove(8);
        assert(avl.isEmpty());
    }

    @Test
    public void testRemoveEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.remove(5);
        assert(avl.isEmpty());
    }

    @Test
    public void testRemoveRotateLeftChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(9);
        avl.insert(4);
        avl.insert(3);
        avl.remove(9);
        assert(avl.findMin() == 3);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 4);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {3, 4, 6, 8}, avl.toArray());
    }

    @Test
    public void testRemoveRotateRightChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(9);
        avl.insert(10);
        avl.insert(11);
        avl.remove(6);
        assert(avl.findMin() == 8);
        assert(avl.findMax() == 11);
        assert(avl.height() == 2);
        assert(avl.size() == 4);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {8, 9, 10, 11}, avl.toArray());
    }

    @Test
    public void testRemoveDoubleRotateLeftChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(9);
        avl.insert(4);
        avl.insert(5);
        avl.remove(9);
        assert(avl.findMin() == 4);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 4);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {4, 5, 6, 8}, avl.toArray());
    }

    @Test
    public void testRemoveDoubleRotateRightChild() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(8);
        avl.insert(6);
        avl.insert(12);
        avl.insert(10);
        avl.insert(11);
        avl.remove(6);
        assert(avl.findMin() == 8);
        assert(avl.findMax() == 12);
        assert(avl.height() == 2);
        assert(avl.size() == 4);
        assert(avl.countLeaves() == 2);
        assertArrayEquals(new Integer[] {8, 10, 11, 12}, avl.toArray());
    }

    @Test
    public void testRemoveDuplicate() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.insert(5);
        avl.remove(5);
        assert(avl.findMin() == 2);
        assert(avl.findMax() == 8);
        assert(avl.height() == 2);
        assert(avl.size() == 6);
        assert(avl.countLeaves() == 3);
        assertArrayEquals(new Integer[] {2, 3, 4, 6, 7, 8}, avl.toArray());
    }

    /*
     * Test findMin() method
     */
    @Test
    public void testFindMin() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.findMin() == 2);
    }

    @Test
    public void testFindMinEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(avl.findMin() == null);
    }

    @Test
    public void testFindMinOneElement() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(avl.findMin() == 5);
    }

    /*
     * Test findMax() method
     */
    @Test
    public void testFindMax() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.findMax() == 8);
    }

    @Test
    public void testFindMaxEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(avl.findMax() == null);
    }

    @Test
    public void testFindMaxOneElement() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(avl.findMax() == 5);
    }

    /*
     * Test height() method
     */
    @Test
    public void testHeight() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.height() == 2);
    }

    @Test
    public void testHeightEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(avl.height() == -1);
    }

    @Test
    public void testHeightOneElement() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(avl.height() == 0);
    }

    /*
     * Test size() method
     */
    @Test
    public void testSize() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.size() == 7);
    }

    @Test
    public void testSizeEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(avl.size() == 0);
    }

    @Test
    public void testSizeOneElement() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(avl.size() == 1);
    }

    /*
     * Test countLeaves() method
     */
    @Test
    public void testCountLeaves() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.countLeaves() == 4);
    }

    @Test
    public void testCountLeavesEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(avl.countLeaves() == 0);
    }

    @Test
    public void testCountLeavesOneElement() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(avl.countLeaves() == 1);
    }

    /*
     * Test contains() method
     */
    @Test
    public void testContains() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assert(avl.contains(5));
        assert(avl.contains(3));
        assert(avl.contains(7));
        assert(avl.contains(2));
        assert(avl.contains(4));
        assert(avl.contains(6));
        assert(avl.contains(8));
    }

    @Test
    public void testContainsEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assert(!avl.contains(5));
    }

    @Test
    public void testContainsFalse() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        assert(!avl.contains(3));
    }

    /*
     * Test toArray() method
     */
    @Test
    public void testToArray() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assertArrayEquals(new Integer[] {2, 3, 4, 5, 6, 7, 8}, avl.toArray());
    }

    @Test
    public void testToArrayEmpty() {
        AvlTree<Integer> avl = new AvlTree<>();
        assertArrayEquals(new Integer[] {}, avl.toArray());
    }
}
