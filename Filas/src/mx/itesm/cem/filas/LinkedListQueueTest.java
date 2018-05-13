package mx.itesm.cem.filas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListQueueTest {

    private static Queue<Object> emptyQueue;
    private static Queue<Integer> integerQueue;
    private static Queue<String> stringQueue;
    private static Queue<Double> doubleQueue;

    private static Collection<Integer> integerCollection = Arrays
            .asList(4, 8, 15, 16, 23, 42);
    private static Collection<String> stringCollection = Arrays
            .asList("Fili", "Kili", "Oin", "Gloin",
                    "Thorin", "Dwalin", "Balin", "Bifur",
                    "Bofur", "Bombur", "Dori", "Nori",
                    "Ori");
    private static Collection<Double> doubleCollection = Arrays
            .asList(2.99792458e8, 6.67408e-11,
                    6.62607015e-34, 1.602176634e-19,
                    6.02214076e23);

    @BeforeEach
    void setUp() throws Exception {
        emptyQueue = new LinkedListQueue<>();
        integerQueue = new LinkedListQueue<>(
                integerCollection);
        stringQueue = new LinkedListQueue<>(
                stringCollection);
        doubleQueue = new LinkedListQueue<>(
                doubleCollection);
    }

    @Test
    void testSize() {
        assertEquals(0, emptyQueue.size());
        assertEquals(6, integerQueue.size());
        assertEquals(13, stringQueue.size());
        assertEquals(5, doubleQueue.size());
    }

    @Test
    void testOffer() {
        assertTrue(integerQueue.offer(108));
        assertTrue(integerQueue.offer(0));
        assertEquals(8, integerQueue.size());

        assertTrue(stringQueue.offer("Frodo"));
        assertTrue(stringQueue.offer("Gandalf"));
        assertTrue(stringQueue.offer("Beorn"));
        assertEquals(16, stringQueue.size());

        assertTrue(doubleQueue.offer(101325.0));
        assertEquals(6, doubleQueue.size());
    }

    @Test
    void testPoll() {
        assertNull(emptyQueue.poll());

        assertEquals((Integer) 4, integerQueue.poll());
        assertEquals(5, integerQueue.size());

        assertEquals("Fili", stringQueue.poll());
        assertEquals("Kili", stringQueue.poll());
        assertEquals("Oin", stringQueue.poll());
        assertEquals(10, stringQueue.size());

        assertEquals((Double) 2.99792458e8,
                doubleQueue.poll());
        assertEquals(4, doubleQueue.size());
        while (!doubleQueue.isEmpty()) {
            assertNotNull(doubleQueue.poll());
        }
        assertEquals(0, doubleQueue.size());
        assertNull(doubleQueue.poll());
    }

    @Test
    void testPeek() {
        assertNull(emptyQueue.peek());

        assertEquals((Integer) 4, integerQueue.peek());
        assertEquals(6, integerQueue.size());
        assertEquals((Integer) 4, integerQueue.peek());

        assertEquals("Fili", stringQueue.peek());
        assertEquals(13, stringQueue.size());
        assertEquals("Fili", stringQueue.peek());

        assertEquals((Double) 2.99792458e8,
                doubleQueue.peek());
        assertEquals(5, doubleQueue.size());
        assertEquals((Double) 2.99792458e8,
                doubleQueue.peek());
    }

    @Test
    void testIterator() {
        Iterator<Object> emptyIterator = emptyQueue
                .iterator();
        assertFalse(emptyIterator.hasNext());
        assertThrows(NoSuchElementException.class,
                () -> emptyIterator.next());

        Iterator<String> stringIterator1 = stringQueue
                .iterator();
        Iterator<String> stringIterator2 = stringCollection
                .iterator();
        while (stringIterator1.hasNext()) {
            assertTrue(stringIterator1.hasNext());
            assertTrue(stringIterator2.hasNext());
            assertEquals(stringIterator1.next(),
                    stringIterator2.next());
        }
        assertFalse(stringIterator1.hasNext());
        assertFalse(stringIterator2.hasNext());
        assertThrows(NoSuchElementException.class,
                () -> stringIterator1.next());
        assertThrows(NoSuchElementException.class,
                () -> stringIterator2.next());

        assertIterableEquals(integerCollection,
                integerQueue);
        assertIterableEquals(stringCollection, stringQueue);
        assertIterableEquals(doubleCollection, doubleQueue);

        assertEquals("[]", emptyQueue.toString());

        assertEquals((Integer) 4, integerQueue.poll());
        assertTrue(integerQueue.offer(108));
        assertEquals("[8, 15, 16, 23, 42, 108]",
                integerQueue.toString());

        assertEquals("Fili", stringQueue.poll());
        assertTrue(stringQueue.offer("Frodo"));
        assertTrue(stringQueue.offer("Gandalf"));
        assertEquals("Kili", stringQueue.poll());
        assertTrue(stringQueue.offer("Beorn"));
        assertEquals("Oin", stringQueue.poll());
        assertEquals(
                "[Gloin, Thorin, Dwalin, Balin, "
                        + "Bifur, Bofur, Bombur, "
                        + "Dori, Nori, Ori, Frodo, "
                        + "Gandalf, Beorn]",
                stringQueue.toString());

        assertEquals(
                "[2.99792458E8, 6.67408E-11, 6.62607015E-34, "
                        + "1.602176634E-19, 6.02214076E23]",
                doubleQueue.toString());
    }
}
