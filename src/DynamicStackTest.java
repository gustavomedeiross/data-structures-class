import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStackTest {
    private Stack<Object> sut;

    @BeforeEach
    void setUp() {
        sut = new DynamicStack<Object>();
    }

    @Test
    public void testPushOneItem() {
        Object o = "x";
        sut.push(o);
        assertEquals(o, sut.peek());
        assertEquals(1, sut.size());
        assertFalse(sut.isEmpty());
    }

    @Test
    public void testPushAndPopOneItem() {
        Object o = "x";
        sut.push(o);
        Object r = sut.pop();
        assertEquals(o, r);
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());
        assertFalse(sut.isNotEmpty());
    }

    @Test
    public void testPushTwoItems() {
        Object x = "x";
        Object y = "y";
        sut.push(x);
        sut.push(y);
        assertEquals(y, sut.peek());
        assertFalse(sut.isEmpty());
        assertEquals(2, sut.size());
    }

    @Test
    public void testPeekEmptyStack() {
        try {
            sut.peek();
            fail();
        } catch(StackException e) {
            assertEquals(StackException.ErrorCode.EMPTY, e.getErrorCode());
            assertTrue(sut.isEmpty());
            assertEquals(0, sut.size());
        }
    }

    @Test
    public void testPopEmptyStack() {
        try {
            sut.pop();
            fail();
        } catch(StackException e) {
            assertEquals(StackException.ErrorCode.EMPTY, e.getErrorCode());
            assertTrue(sut.isEmpty());
            assertEquals(0, sut.size());
        }
    }
}
