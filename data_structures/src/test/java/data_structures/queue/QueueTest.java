package data_structures.queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.data_structures.queue.Queue;

public class QueueTest {
    /*
     * Test size() method
     */
    @Test
    public void testSize() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.size() == 3);
    }

    @Test
    public void testSizeEmpty() {
        Queue<Integer> queue = new Queue<>();
        assert(queue.size() == 0);
    }

    /*
     * Test isEmpty() method
     */
    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>();
        assert(queue.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        assert(!queue.isEmpty());
    }

    /*
     * Test clear() method
     */
    @Test
    public void testClear() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.clear();
        assert(queue.isEmpty());
    }

    /*
     * Test add() method
     */
    @Test
    public void testAdd() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.size() == 3);
        assertArrayEquals(new Integer[] {1, 2, 3}, queue.toArray());
    }

    /*
     * Test element() method
     */
    @Test
    public void testElement() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.element() == 1);
    }

    @Test
    public void testElementEmpty() {
        Queue<Integer> queue = new Queue<>();
        try {
            queue.element();
        } catch (IllegalStateException e) {
            assert(e.getMessage().equals("Queue is empty"));
        }
    }

    /*
     * Test peek() method
     */
    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.peek() == 1);
    }

    @Test
    public void testPeekEmpty() {
        Queue<Integer> queue = new Queue<>();
        assert(queue.peek() == null);
    }

    /*
     * Test poll() method
     */
    @Test
    public void testPoll() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.poll() == 1);
        assert(queue.size() == 2);
        assertArrayEquals(new Integer[] {2, 3}, queue.toArray());
    }
    
    @Test
    public void testPollEmpty() {
        Queue<Integer> queue = new Queue<>();
        assert(queue.poll() == null);
    }

    @Test
    public void testPollAll() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.poll();
        queue.poll();
        queue.poll();
        assert(queue.poll() == null);
        assert(queue.size() == 0);
    }

    /*
     * Test remove() method
     */
    @Test
    public void testRemove() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.remove() == 1);
        assert(queue.size() == 2);
        assertArrayEquals(new Integer[] {2, 3}, queue.toArray());
    }

    @Test
    public void testRemoveEmpty() {
        Queue<Integer> queue = new Queue<>();
        try {
            queue.remove();
        } catch (IllegalStateException e) {
            assert(e.getMessage().equals("Queue is empty"));
        }
    }

    @Test
    public void testRemoveAll() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.remove();
        queue.remove();
        try {
            queue.remove();
        } catch (IllegalStateException e) {
            assert(e.getMessage().equals("Queue is empty"));
        }
    }

    /*
     * Test toArray() method
     */
    @Test
    public void testToArray() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, queue.toArray());
    }

    @Test
    public void testToArrayEmpty() {
        Queue<Integer> queue = new Queue<>();
        assertArrayEquals(new Integer[] {}, queue.toArray());
    }

    /*
     * Test toString() method
     */
    @Test
    public void testToString() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assert(queue.toString().equals("[1, 2, 3]"));
    }

    @Test
    public void testToStringEmpty() {
        Queue<Integer> queue = new Queue<>();
        assert(queue.toString().equals("[]"));
    }

    /*
     * Test equals() method
     */
    @Test
    public void testEquals() {
        Queue<Integer> queue1 = new Queue<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        Queue<Integer> queue2 = new Queue<>();
        queue2.add(1);
        queue2.add(2);
        queue2.add(3);
        assert(queue1.equals(queue2));
    }

    @Test
    public void testEqualsEmpty() {
        Queue<Integer> queue1 = new Queue<>();
        Queue<Integer> queue2 = new Queue<>();
        assert(queue1.equals(queue2));
    }

    @Test
    public void testEqualsDifferent() {
        Queue<Integer> queue1 = new Queue<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        Queue<Integer> queue2 = new Queue<>();
        queue2.add(1);
        queue2.add(2);
        assert(!queue1.equals(queue2));
    }

    @Test
    public void testEqualsNull() {
        Queue<Integer> queue = new Queue<>();
        assert(!queue.equals(null));
    }

    @Test
    public void testEqualsDifferentTypes() {
        Queue<Integer> queue1 = new Queue<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        Queue<String> queue2 = new Queue<>();
        queue2.add("1");
        queue2.add("2");
        queue2.add("3");
        assert(!queue1.equals(queue2));
    }
}
