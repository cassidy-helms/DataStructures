package data_structures.linked_list;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.data_structures.linked_list.LinkedList;

public class LinkedListTest {
    /*
     * Test size() method
     */
    @Test
    public void testSizeWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.size() == 0;
    }

    @Test
    public void testSizeWhenNotEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.size() == 3;
    }

    @Test
    public void testSizeWhenCleared() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assert list.size() == 0;
    }

    /*
     * Test isEmpty() method
     */
    @Test
    public void testIsEmptyWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.isEmpty();
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert !list.isEmpty();
    }

    @Test
    public void testIsEmptyWhenCleared() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assert list.isEmpty();
    }

    /*
     * Test add() method
     */
    @Test
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {1, 2, 3}, list.toArray());
    }

    /*
     * Test addFirst() method
     */
    @Test
    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {3, 2, 1}, list.toArray());
    }

    /*
     * Test addLast() method
     */
    @Test
    public void testAddLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {1, 2, 3}, list.toArray());
    }

    /*
     * Test addAtIndex() method
     */
    @Test
    public void testAddAtIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(1, 2);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {1, 2, 3}, list.toArray());
    }

    @Test
    public void testAddAtIndexWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 1);
        assert list.size() == 1;
        assertArrayEquals(new Integer[] {1}, list.toArray());
    }

    @Test
    public void testAddAtIndexWhenOutOfBounds() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.add(1, 1);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("1 is out of bounds for array of size 0");
        }
    }

    @Test
    public void testAddAtIndexWhenNegative() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.add(-1, 1);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("-1 is out of bounds for array of size 0");
        }
    }
    
    /*
     * Test toArray() method
     */
    @Test
    public void testToArray() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, list.toArray());
    }

    @Test
    public void testToArrayWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    /*
     * Test get() method
     */
    @Test
    public void testGet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.get(1) == 2;
    }

    @Test
    public void testGetWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.get(0);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("0 is out of bounds for array of size 0");
        }
    }

    @Test
    public void testGetWhenOutOfBounds() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.get(3);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("3 is out of bounds for array of size 3");
        }
    }

    @Test
    public void testGetWhenNegative() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("-1 is out of bounds for array of size 0");
        }
    }

    /*
     * Test set() method
     */
    @Test
    public void testSet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {1, 4, 3}, list.toArray());
    }

    @Test
    public void testSetWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.set(0, 1);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("0 is out of bounds for array of size 0");
        }
    }

    @Test
    public void testSetWhenOutOfBounds() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.set(3, 4);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("3 is out of bounds for array of size 3");
        }
    }

    @Test
    public void testSetWhenNegative() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.set(-1, 1);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("-1 is out of bounds for array of size 0");
        }
    }

    /*
     * Test remove() method
     */
    @Test
    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {1, 3}, list.toArray());
    }

    @Test
    public void testRemoveWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("0 is out of bounds for array of size 0");
        }
    }

    @Test
    public void testRemoveWhenOutOfBounds() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.remove(3);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("3 is out of bounds for array of size 3");
        }
    }

    @Test
    public void testRemoveWhenNegative() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.remove(-1);
        } catch (IndexOutOfBoundsException e) {
            assert e.getMessage().equals("-1 is out of bounds for array of size 0");
        }
    }

    @Test
    public void testRemoveFirstElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {2, 3}, list.toArray());
    }

    @Test
    public void testRemoveLastElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {1, 2}, list.toArray());
    }

    @Test
    public void testRemoveWhenMultiple() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(1);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {1, 3, 4}, list.toArray());
    }

    /*
     * Test removeFirst() method
     */
    @Test
    public void testRemoveFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeFirst();
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {2, 3}, list.toArray());
    }

    @Test
    public void testRemoveFirstWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.removeFirst() == null;
    }

    /*
     * Test removeLast() method
     */
    @Test
    public void testRemoveLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeLast();
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {1, 2}, list.toArray());
    }

    @Test
    public void testRemoveLastWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.removeLast() == null;
    }

    /*
     * Test clear() method
     */
    @Test
    public void testClear() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assert list.size() == 0;
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    /*
     * Test contains() method
     */
    @Test
    public void testContains() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.contains(2);
    }

    @Test
    public void testContainsWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert !list.contains(1);
    }

    @Test
    public void testContainsWhenNotPresent() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert !list.contains(4);
    }

    /*
     * Test indexOf() method
     */
    @Test
    public void testIndexOf() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.indexOf(2) == 1;
    }

    @Test
    public void testIndexOfWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.indexOf(1) == -1;
    }

    @Test
    public void testIndexOfWhenNotPresent() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.indexOf(4) == -1;
    }

    /*
     * Test removeElement() method
     */
    @Test
    public void testRemoveElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeElement(2);
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {1, 3}, list.toArray());
    }

    @Test
    public void testRemoveElementWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.removeElement(1) == null;
    }

    @Test
    public void testRemoveElementWhenNotPresent() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.removeElement(4) == null;
    }

    @Test
    public void testRemoveElementWhenMultiple() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.removeElement(2);
        assert list.size() == 3;
        assertArrayEquals(new Integer[] {1, 2, 3}, list.toArray());
    }

    @Test
    public void testRemoveElementWhenFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeElement(1);
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {2, 3}, list.toArray());
    }

    @Test
    public void testRemoveElementWhenLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeElement(3);
        assert list.size() == 2;
        assertArrayEquals(new Integer[] {1, 2}, list.toArray());
    }

    /*
     * Test equals() method
     */
    @Test
    public void testEquals() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        assert list1.equals(list2);
    }

    @Test
    public void testEqualsWhenEmpty() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        assert list1.equals(list2);
    }

    @Test
    public void testEqualsWhenDifferentSize() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        assert !list1.equals(list2);
    }

    @Test
    public void testEqualsWhenDifferentElements() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        assert !list1.equals(list2);
    }

    @Test
    public void testEqualsWhenDifferentOrder() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        assert !list1.equals(list2);
    }

    @Test
    public void testEqualsWhenDifferentType() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        assert !list1.equals(list2);
    }

    /*
     * Test toString() method
     */
    @Test
    public void testToString() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.toString().equals("[1, 2, 3]");
    }

    @Test
    public void testToStringWhenEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assert list.toString().equals("[]");
    }

    @Test
    public void testToStringWhenOneElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assert list.toString().equals("[1]");
    }

    @Test
    public void testToStringWhenMultipleElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assert list.toString().equals("[1, 2]");
    }

    @Test
    public void testToStringWhenMultipleDigits() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assert list.toString().equals("[10, 20, 30]");
    }

    @Test
    public void testToStringWhenMultipleElementsAndEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.clear();
        assert list.toString().equals("[]");
    }
}
