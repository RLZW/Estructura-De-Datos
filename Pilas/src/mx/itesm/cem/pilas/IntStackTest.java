package mx.itesm.cem.pilas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class IntStackTest {

    @Test
    public void test1() {
        IntStack s = new IntStack(5);
        s.push(4);
        assertEquals(4, s.peek());
        s.push(8);
        assertEquals(8, s.peek());
        s.push(15);
        assertEquals(15, s.peek());
        s.push(16);
        assertEquals(16, s.peek());
        s.push(23);
        assertEquals(23, s.peek());
        assertEquals("Stack Overflow",
                assertThrows(IllegalStateException.class,
                        () -> s.push(42)).getMessage());
    }

    @Test
    public void test2() {
        IntStack s = new IntStack(10);
        s.push(4);
        s.push(8);
        s.push(15);
        s.push(16);
        s.push(23);
        s.push(42);
        assertEquals(42, s.peek());
        assertEquals(42, s.pop());
        assertEquals(23, s.peek());
        assertEquals(23, s.pop());
        assertEquals(16, s.peek());
        assertEquals(16, s.pop());
        assertEquals(15, s.peek());
        assertEquals(15, s.pop());
        assertEquals(8, s.peek());
        assertEquals(8, s.pop());
        assertEquals(4, s.peek());
        assertEquals(4, s.pop());
        assertEquals("Stack Underflow",
                assertThrows(NoSuchElementException.class,
                        () -> s.pop()).getMessage());
        assertEquals("Stack Underflow",
                assertThrows(NoSuchElementException.class,
                        () -> s.peek()).getMessage());
    }

    @Test
    public void test3() {
        IntStack s = new IntStack(10);
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
        s.push(4);
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
        s.push(8);
        assertFalse(s.isEmpty());
        assertEquals(2, s.size());
        s.push(15);
        assertFalse(s.isEmpty());
        assertEquals(3, s.size());
        s.push(16);
        assertFalse(s.isEmpty());
        assertEquals(4, s.size());
        s.push(23);
        assertFalse(s.isEmpty());
        assertEquals(5, s.size());
        s.push(42);
        assertFalse(s.isEmpty());
        assertEquals(6, s.size());
        assertEquals(42, s.pop());
        assertFalse(s.isEmpty());
        assertEquals(5, s.size());
        assertEquals(23, s.pop());
        assertFalse(s.isEmpty());
        assertEquals(4, s.size());
        assertEquals(16, s.pop());
        assertFalse(s.isEmpty());
        assertEquals(3, s.size());
        assertEquals(15, s.pop());
        assertFalse(s.isEmpty());
        assertEquals(2, s.size());
        assertEquals(8, s.pop());
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
        assertEquals(4, s.pop());
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
    }

    @Test
    public void test4() {
        IntStack s1 = new IntStack(10);
        IntStack s2 = new IntStack(10);
        s1.push(4);
        s1.push(8);
        s1.push(15);
        s1.push(16);
        s1.push(23);
        s1.push(42);
        s2.push(s1.pop());
        s2.push(s1.pop());
        s2.push(s1.pop());
        s2.push(s1.pop());
        s2.push(s1.pop());
        s2.push(s1.pop());
        assertTrue(s1.isEmpty());
        assertEquals(4, s2.pop());
        assertEquals(8, s2.pop());
        assertEquals(15, s2.pop());
        assertEquals(16, s2.pop());
        assertEquals(23, s2.pop());
        assertEquals(42, s2.pop());
        assertTrue(s2.isEmpty());
    }
}