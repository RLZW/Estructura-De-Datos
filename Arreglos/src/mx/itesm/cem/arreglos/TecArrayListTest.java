package mx.itesm.cem.arreglos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TecArrayListTest {
	
	private TecArrayList<String> as;
	private TecArrayList<Integer> ai;
	private TecArrayList<Float> af;
	
	@BeforeEach
	void setUp() throws Exception {
		as = new TecArrayList<>("verde", "rojo", "amarillo", "azul");
		ai = new TecArrayList<>(4, 8, 15, 16, 23, 42);
		af = new TecArrayList<>();
	}

	
	@Test
	void testGet() {
		assertEquals("rojo",as.get(1));
		assertEquals("azul",as.get(3));
		assertEquals((Integer)4,ai.get(0));
		assertEquals((Integer)42,ai.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			af.get(0);
		});
	}
	
	void testSize() {
		assertEquals(4, as.size());
		assertEquals(6, ai.size());
		assertEquals(0, af.size());
		
	}
	
	@Test
	void testIsEmpty() {
		assertFalse(as.isEmpty());
		assertFalse(ai.isEmpty());
		assertTrue(af.isEmpty());
	}
	
	@Test
	void testSet() {
		assertEquals("verde", as.set(0,"blanco"));
		assertEquals("blanco", as.set(0, "negro"));
		assertEquals("negro", as.get(0));
		assertEquals(42,(int) ai.set(5, -10));
		assertEquals(-10,(int) ai.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			af.set(5,3.14f);
		});
		
	}
}

