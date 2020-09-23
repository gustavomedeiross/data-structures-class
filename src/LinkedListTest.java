import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> sut;

    @BeforeEach
    protected void setUp() {
        sut = new LinkedListImpl<>();
    }

    @Test
    public void testAddOneItem() {
        sut.add(5);
        assertEquals(5, sut.first());
        assertEquals(5, sut.last());
        assertEquals(1, sut.size());
        assertFalse(sut.isEmpty());
    }

    @Test
    public void testAddTwoItems() {
        sut.add(5);
        sut.add(2);
        assertEquals(5, sut.first());
        assertEquals(2, sut.last());
        assertEquals(2, sut.size());
        assertFalse(sut.isEmpty());
    }

    @Test
    public void testGetElement() {
        sut.add(5);
        sut.add(2);
        sut.add(10);
        assertEquals(2, sut.get(1));
        assertEquals(5, sut.get(0));
        assertEquals(10, sut.get(2));
    }

    @Test
    public void testIndexOf() {
        sut.add(5);
        sut.add(2);
        sut.add(10);
        sut.add(2);
        assertEquals(0, sut.indexOf(5));
        assertEquals(2, sut.indexOf(10));
        assertEquals(1, sut.indexOf(2));
        assertEquals(-1, sut.indexOf(8));
    }
}