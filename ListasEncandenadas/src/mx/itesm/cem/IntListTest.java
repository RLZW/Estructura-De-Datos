package mx.itesm.cem.examen1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntListTest {

    private IntList a;
    private IntList b;
    private IntList c;
    private IntList d;

    @BeforeEach
    void setUp() throws Exception {
        a = new IntList();
        Arrays.asList(8, 23, 42, 15, 4, 16)
                .forEach(elem -> a.add(elem));
        b = new IntList();
        b.add(100);
        c = new IntList();
        d = new IntList();
        Arrays.asList(-8, 34, 99, -84, 98, -37, 37, -64,
                -64, 12, -90, -31, -71, -27, 16, -66, 41, 3,
                -4, 41, 70, 55, 77, -52, -76, 3, 56, 14, 48,
                14, 88, -22, 11, -22, -46, 93, -89, 73, 94,
                -97, 56, 99, 14, 2, -42, -27, -47, 86, -90,
                -48).forEach(elem -> d.add(elem));
    }

    @Test
    void testToString() {
        assertEquals("[4, 8, 15, 16, 23, 42]",
                a.toString());
        assertEquals("[100]", b.toString());
        assertEquals("[]", c.toString());
        assertEquals("[-97, -90, -90, -89, -84, -76, "
                + "-71, -66, -64, -64, -52, -48, -47, "
                + "-46, -42, -37, -31, -27, -27, -22, "
                + "-22, -8, -4, 2, 3, 3, 11, 12, 14, 14, "
                + "14, 16, 34, 37, 41, 41, 48, 55, 56, 56, "
                + "70, 73, 77, 86, 88, 93, 94, 98, 99, 99]",
                d.toString());
    }

    @Test
    void testIsEmpty() {
        assertFalse(a.isEmpty());
        assertFalse(b.isEmpty());
        assertTrue(c.isEmpty());
        assertFalse(d.isEmpty());
    }

    @Test
    void testMax() {
        assertEquals(42, a.max());
        assertEquals(100, b.max());
        assertThrows(NoSuchElementException.class, () -> {
            c.max();
        });
        assertEquals(99, d.max());
    }

    @Test
    void testAverage() {
        assertEquals(18.0, a.average());
        assertEquals(100.0, b.average());
        assertThrows(NoSuchElementException.class, () -> {
            c.average();
        });
        assertEquals(2.6, d.average());
    }

    @Test
    void testRemoveBetween() {
        assertFalse(a.removeBetween(-10, 0));
        assertEquals("[4, 8, 15, 16, 23, 42]",
                a.toString());
        assertTrue(a.removeBetween(10, 30));
        assertEquals("[4, 8, 42]", a.toString());
        assertTrue(a.removeBetween(42, 42));
        assertEquals("[4, 8]", a.toString());
        assertTrue(a.removeBetween(1, 50));
        assertEquals("[]", a.toString());
        assertFalse(a.removeBetween(1, 50));
        assertEquals("[]", a.toString());

        assertFalse(b.removeBetween(0, 90));
        assertEquals("[100]", b.toString());
        assertTrue(b.removeBetween(0, 100));
        assertEquals("[]", b.toString());

        assertFalse(c.removeBetween(-100, 100));
        assertEquals("[]", c.toString());
        assertFalse(c.removeBetween(-100, 100));
        assertEquals("[]", c.toString());
        assertThrows(IllegalArgumentException.class, () -> {
            c.removeBetween(5, 0);
        });

        assertTrue(d.removeBetween(0, 100));
        assertEquals("[-97, -90, -90, -89, -84, -76, -71, "
                + "-66, -64, -64, -52, -48, -47, -46, -42, "
                + "-37, -31, -27, -27, -22, -22, -8, -4]",
                d.toString());
        assertTrue(d.removeBetween(-100, -90));
        assertEquals("[-89, -84, -76, -71, -66, -64, "
                + "-64, -52, -48, -47, -46, -42, -37, "
                + "-31, -27, -27, -22, -22, -8, -4]",
                d.toString());
        assertThrows(IllegalArgumentException.class, () -> {
            d.removeBetween(-50, -70);
        });
        assertTrue(d.removeBetween(-42, -42));
        assertEquals("[-89, -84, -76, -71, -66, -64, "
                + "-64, -52, -48, -47, -46, -37, -31, "
                + "-27, -27, -22, -22, -8, -4]",
                d.toString());
        assertTrue(d.removeBetween(-89, -64));
        assertEquals("[-52, -48, -47, -46, -37, "
                + "-31, -27, -27, -22, -22, -8, -4]",
                d.toString());
        assertTrue(d.removeBetween(-48, -8));
        assertEquals("[-52, -4]", d.toString());
        assertTrue(d.removeBetween(-100, 100));
        assertEquals("[]", d.toString());
        assertFalse(d.removeBetween(-100, 100));
        assertEquals("[]", d.toString());
    }
}
