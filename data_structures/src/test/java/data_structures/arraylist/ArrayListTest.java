package data_structures.arraylist;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.data_structures.arraylist.ArrayList;

public class ArrayListTest {
    /*
     * Test size() method
     */

    @Test
    public void testSizeWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeWhenOneElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testSizeWhenMultipleElements() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testSizeWhenClear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    /*
     * Test isEmpty() method
     */
    @Test
    public void testIsEmptyWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenClear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.clear();
        assertEquals(true, list.isEmpty());
    }

    /*
     * Test clear() method
     */
    @Test
    public void testClearWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClearWhenNotEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    /*
     * Test add() method
     */
    @Test
    public void testAddOneValue() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[] { 1 }, list.toArray());
    }

    @Test
    public void testAddMultipleValues() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[] { 1, 2, 3 }, list.toArray());
    }

    @Test
    public void testAddAboveCapacity() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        assertEquals(11, list.size());
        assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, list.toArray());
    }

    /*
     * Test add(int index, T element) method
     */
    @Test
    public void testAddAtIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 4);
        assertEquals(4, list.size());
        assertArrayEquals(new Integer[] { 1, 4, 2, 3 }, list.toArray());
    }

    @Test
    public void testAddAtIndexZero() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 1);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[] { 1 }, list.toArray());
    }

    @Test
    public void testAddAtIndexEnd() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3, 4);
        assertEquals(4, list.size());
        assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, list.toArray());
    }

    @Test
    public void testAddAtIndexAboveCapacity() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(10, 10);
        assertEquals(11, list.size());
        assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, list.toArray());
    }

    @Test
    public void testAddAtIndexOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.add(4, 4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("4 is out of bounds for array of size 3", e.getMessage());
        }
    }

    @Test
    public void testAddAtIndexNegative() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.add(-1, 4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("-1 is out of bounds for array of size 3", e.getMessage());
        }
    }

    /*
     * Test get(int index) method
     */
    @Test
    public void testGet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.get(3);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("3 is out of bounds for array of size 3", e.getMessage());
        }
    }

    @Test
    public void testGetNegative() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("-1 is out of bounds for array of size 3", e.getMessage());
        }
    }

    /*
     * Test set(int index, T element) method
     */
    @Test
    public void testSet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);
        assertEquals(4, list.get(1));
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[] { 1, 4, 3 }, list.toArray());
    }

    @Test
    public void testSetOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.set(3, 4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("3 is out of bounds for array of size 3", e.getMessage());
        }
    }

    @Test
    public void testSetNegative() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.set(-1, 4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("-1 is out of bounds for array of size 3", e.getMessage());
        }
    }

    @Test
    public void testSetWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            list.set(0, 1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("0 is out of bounds for array of size 0", e.getMessage());
        }
    }

    /*
     * Test remove(int index) method
     */
    @Test
    public void testRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
        assertArrayEquals(new Integer[] { 1, 3 }, list.toArray());
    }

    @Test
    public void testRemoveOutOfBounds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.remove(3);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("3 is out of bounds for array of size 3", e.getMessage());
        }
    }

    @Test
    public void testRemoveNegative() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.remove(-1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("-1 is out of bounds for array of size 3", e.getMessage());
        }
    }

    @Test
    public void testRemoveWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("0 is out of bounds for array of size 0", e.getMessage());
        }
    }

    @Test
    public void testRemoveLastElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.remove(0);
        assertEquals(0, list.size());
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    @Test
    public void testRemoveAllElements() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    /*
     * Test toArray() method
     */
    @Test
    public void testToArrayWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    @Test
    public void testToArrayWhenNotEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, list.toArray());
    }

    @Test
    public void testToArrayWhenClear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    /*
     * Test toString() method
     */
    @Test
    public void testToStringWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals("[]", list.toString());
    }

    @Test
    public void testToStringWhenNotEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testToStringWhenClear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals("[]", list.toString());
    }

    /*
     * Test equals() method
     */
    @Test
    public void testEqualsWhenEqual() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        assertEquals(true, list1.equals(list2));
    }

    @Test
    public void testEqualsWhenNotEqual() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        assertEquals(false, list1.equals(list2));
    }

    @Test
    public void testEqualsWhenDifferentSize() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        assertEquals(false, list1.equals(list2));
    }

    @Test
    public void testEqualsWhenDifferentType() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        assertEquals(false, list1.equals(new ArrayList<String>()));
    }

    @Test
    public void testEqualsWhenDifferentTypesSameValues() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        assertEquals(false, list1.equals(list2));
    }
    
    @Test
    public void testEqualsWhenEmpty() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        assertEquals(true, list1.equals(list2));
    }

    /*
     * Test indexOf() method
     */
    @Test
    public void testIndexOfWhenExists() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    public void testIndexOfWhenDoesNotExist() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void testIndexOfWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(-1, list.indexOf(1));
    }

    /*
     * Test contains() method
     */
    @Test
    public void testContainsWhenExists() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.contains(2));
    }

    @Test
    public void testContainsWhenDoesNotExist() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(false, list.contains(4));
    }

    @Test
    public void testContainsWhenEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(false, list.contains(1));
    }
}
