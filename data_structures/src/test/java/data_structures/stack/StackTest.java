package data_structures.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.data_structures.stack.Stack;

public class StackTest {
    
    /*
     * Test size() method
     */
    @Test
    public void testSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.size() == 3);
    }

    @Test
    public void testSizeEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.size() == 0);
    }

    /*
     * Test isEmpty() method
     */
    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assert(!stack.isEmpty());
    }

    /*
     * Test clear() method
     */
    @Test
    public void testClear() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();
        assert(stack.isEmpty());
    }

    /*
     * Test push() method
     */
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.size() == 3);
        assertArrayEquals(new Integer[] {1, 2, 3}, stack.toArray());
    }

    /*
     * Test peek() method
     */
    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.peek() == 3);
    }

    @Test
    public void testPeekEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.peek() == null);
    }

    /*
     * Test pop() method
     */
    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.pop() == 3);
        assert(stack.size() == 2);
        assertArrayEquals(new Integer[] {1, 2}, stack.toArray());
    }

    @Test
    public void testPopEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.pop() == null);
    }

    /*
     * Test search() method
     */
    @Test
    public void testSearch() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.search(2) == 1);
    }

    @Test
    public void testSearchNotFound() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.search(4) == -1);
    }

    @Test
    public void testSearchEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.search(1) == -1);
    }

    @Test
    public void testSearchNull() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.search(null) == -1);
    }

    @Test
    public void testSearchNullEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.search(null) == -1);
    }

    /*
     * Test toArray() method
     */
    @Test
    public void testToArray() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, stack.toArray());
    }

    @Test
    public void testToArrayEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertArrayEquals(new Integer[] {}, stack.toArray());
    }

    /*
     * Test toString() method
     */
    @Test
    public void testToString() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert(stack.toString().equals("[1, 2, 3]"));
    }

    @Test
    public void testToStringEmpty() {
        Stack<Integer> stack = new Stack<>();
        assert(stack.toString().equals("[]"));
    }

    /*
     * Test equals() method
     */
    @Test
    public void testEquals() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        assert(stack1.equals(stack2));
    }

    @Test
    public void testEqualsEmpty() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        assert(stack1.equals(stack2));
    }

    @Test
    public void testEqualsNull() {
        Stack<Integer> stack = new Stack<>();
        assert(!stack.equals(null));
    }

    @Test
    public void testEqualsDifferent() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(4);
        assert(!stack1.equals(stack2));
    }

    @Test
    public void testEqualsDifferentSize() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        assert(!stack1.equals(stack2));
    }

    @Test
    public void testEqualsDifferentTypes() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Stack<String> stack2 = new Stack<>();
        stack2.push("1");
        stack2.push("2");
        stack2.push("3");
        assert(!stack1.equals(stack2));
    }
}
