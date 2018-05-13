package mx.itesm.cem.arboles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeSetTest {

    private BinarySearchTreeSet<String> stringTreeSet1;
    private BinarySearchTreeSet<String> stringTreeSet2;
    private BinarySearchTreeSet<String> stringTreeSet3;
    private BinarySearchTreeSet<String> stringTreeSet4;
    private BinarySearchTreeSet<Integer> integerTreeSet1;
    private BinarySearchTreeSet<Integer> integerTreeSet2;
    private BinarySearchTreeSet<Integer> integerTreeSet3;
    private BinarySearchTreeSet<Integer> integerTreeSet4;

    @BeforeEach
    public void setUp() throws Exception {
        stringTreeSet1 = new BinarySearchTreeSet<>();
        stringTreeSet2 = new BinarySearchTreeSet<>();
        stringTreeSet2.add("a");
        stringTreeSet3 = new BinarySearchTreeSet<>();
        stringTreeSet3.addAll(Arrays.asList("m", "r", "p",
                "z", "g", "k", "a"));
        stringTreeSet4 = new BinarySearchTreeSet<>();
        stringTreeSet4.addAll(Arrays.asList("d", "c", "e",
                "b", "f", "a", "g"));

        integerTreeSet1 = new BinarySearchTreeSet<>();
        integerTreeSet1.addAll(Arrays.asList(22, 30, 25, 35,
                10, 5, 33, 15, 12, 40, 17, 19, 20, 18, 16));
        integerTreeSet2 = new BinarySearchTreeSet<>();
        integerTreeSet2.addAll(
                Arrays.asList(8, 1, 7, 2, 6, 3, 5, 4));
        integerTreeSet3 = new BinarySearchTreeSet<>();
        integerTreeSet3.addAll(Arrays.asList(1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        integerTreeSet4 = new BinarySearchTreeSet<>();
        integerTreeSet4.addAll(Arrays.asList(8, 4, 12, 2, 6,
                1, 5, 3, 7, 10, 11, 14, 15, 9, 13));
    }

    @Test
    public void testHeight() {
        assertEquals(-1, stringTreeSet1.height());
        assertEquals(0, stringTreeSet2.height());
        assertEquals(2, stringTreeSet3.height());
        assertEquals(3, stringTreeSet4.height());
        assertEquals(5, integerTreeSet1.height());
        assertEquals(7, integerTreeSet2.height());
        assertEquals(14, integerTreeSet3.height());
        assertEquals(3, integerTreeSet4.height());
    }

    @Test
    public void testIsFull() {
        assertTrue(stringTreeSet1.isFull());
        assertTrue(stringTreeSet2.isFull());
        assertTrue(stringTreeSet3.isFull());
        assertFalse(stringTreeSet4.isFull());
        assertTrue(integerTreeSet1.isFull());
        assertFalse(integerTreeSet2.isFull());
        assertFalse(integerTreeSet3.isFull());
        assertTrue(integerTreeSet4.isFull());
    }

    @Test
    public void testLeafCount() {
        assertEquals(0, stringTreeSet1.leafCount());
        assertEquals(1, stringTreeSet2.leafCount());
        assertEquals(4, stringTreeSet3.leafCount());
        assertEquals(2, stringTreeSet4.leafCount());
        assertEquals(8, integerTreeSet1.leafCount());
        assertEquals(1, integerTreeSet2.leafCount());
        assertEquals(1, integerTreeSet3.leafCount());
        assertEquals(8, integerTreeSet4.leafCount());
    }

    @Test
    public void testIsPerfect() {
        assertTrue(stringTreeSet1.isPerfect());
        assertTrue(stringTreeSet2.isPerfect());
        assertTrue(stringTreeSet3.isPerfect());
        assertFalse(stringTreeSet4.isPerfect());
        assertFalse(integerTreeSet1.isPerfect());
        assertFalse(integerTreeSet2.isPerfect());
        assertFalse(integerTreeSet3.isPerfect());
        assertTrue(integerTreeSet4.isPerfect());
    }

    @Test
    public void testIsDegenerate() {
        assertFalse(stringTreeSet1.isDegenerate());
        assertFalse(stringTreeSet2.isDegenerate());
        assertFalse(stringTreeSet3.isDegenerate());
        assertFalse(stringTreeSet4.isDegenerate());
        assertFalse(integerTreeSet1.isDegenerate());
        assertTrue(integerTreeSet2.isDegenerate());
        assertTrue(integerTreeSet3.isDegenerate());
        assertFalse(integerTreeSet4.isDegenerate());
    }
}