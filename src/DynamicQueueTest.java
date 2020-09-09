import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicQueueTest {
    private Queue<String> sut;

    @BeforeEach
    void setUp() {
        sut = new DynamicQueue<String>();
    }

    @Test
    public void testEnqueueOneItem() {
        sut.enqueue("x");
        assertEquals("x", sut.peek());
        assertEquals(1, sut.size());
        assertFalse(sut.isEmpty());
    }

    @Test
    public void testEnqueueAndDequeueOneItem() {
        sut.enqueue("x");
        Object dequeued = sut.dequeue();
        assertEquals("x", dequeued);
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());
        assertFalse(sut.isNotEmpty());
    }

    @Test
    public void testEnqueueTwoItems() {
        sut.enqueue("x");
        sut.enqueue("y");
        assertEquals("x", sut.peek());
        assertFalse(sut.isEmpty());
        assertEquals(2, sut.size());
    }

    @Test
    public void testEnqueueTwoItemsAndDequeueOneItem() {
        sut.enqueue("x");
        sut.enqueue("y");
        assertEquals("x", sut.peek());
        assertFalse(sut.isEmpty());
        assertEquals(2, sut.size());

        String dequeued = sut.dequeue();
        assertEquals("x", dequeued);
        assertEquals(1, sut.size());
        assertEquals("y", sut.peek());
    }

    @Test
    public void testEnqueue3ItemsDequeue2AndEnqueue1() {
        sut.enqueue("x");
        sut.enqueue("y");
        sut.enqueue("z");
        assertEquals(3, sut.size());
        assertEquals("x", sut.peek());

        sut.dequeue();
        sut.dequeue();
        assertEquals(1, sut.size());
        assertEquals("z", sut.peek());

        sut.enqueue("k");
        assertEquals(2, sut.size());
        assertEquals("z", sut.peek());
    }

    @Test
    public void testEnqueue5AndDequeue3() {
        sut.enqueue("1");
        sut.enqueue("2");
        sut.enqueue("3");
        sut.enqueue("4");
        sut.enqueue("5");
        assertEquals(5, sut.size());
        assertEquals("1", sut.peek());

        sut.dequeue();
        sut.dequeue();
        sut.dequeue();
        assertEquals(2, sut.size());
        assertEquals("4", sut.peek());
    }

    @Test
    public void testPeekEmptyQueue() {
        try {
            sut.peek();
            fail();
        } catch(EmptyQueueException e) {
            assertTrue(sut.isEmpty());
            assertEquals(0, sut.size());
        }
    }

    @Test
    public void testPopEmptyStack() {
        try {
            sut.dequeue();
            fail();
        } catch(EmptyQueueException e) {
            assertTrue(sut.isEmpty());
            assertEquals(0, sut.size());
        }
    }
}