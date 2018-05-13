package mx.itesm.cem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Prueba {
	private List<String> stringList;
    private List<Integer> integerList;
    private List<Float> floatList;

    @BeforeEach
    void setUp() throws Exception {
        stringList = new TecLinkedList<>("Katniss", "Peeta",
                "Gale", "Haymitch", "Primrose", "Effie");
        integerList = new TecLinkedList<>(0, 1, 1, 2, 3, 5,
                8, 13, 21, 34, 55, 89);
        floatList = new TecLinkedList<>();
    }

    @Test
    void testSize() {
        assertEquals(6, stringList.size());
        assertEquals(12, integerList.size());
        assertEquals(0, floatList.size());
    }

    @Test
    void testGet() {
        assertEquals("Katniss", stringList.get(0));
        assertEquals("Effie", stringList.get(5));
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.get(6));
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.get(-1));

        assertEquals(5, (int) integerList.get(5));
        assertEquals(55, (int) integerList.get(10));
        assertThrows(IndexOutOfBoundsException.class,
                () -> integerList.get(12));

        assertThrows(IndexOutOfBoundsException.class,
                () -> floatList.get(0));
    }

    @Test
    void testSet() {
        assertEquals("Effie", stringList.set(5, "Cinna"));
        assertEquals("Haymitch",
                stringList.set(3, "Portia"));
        assertEquals("Peeta", stringList.set(1, "Flavius"));
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.set(6, "Coriolanus"));
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.set(-1, "Rue"));
        assertIterableEquals(
                List.of("Katniss", "Flavius", "Gale",
                        "Portia", "Primrose", "Cinna"),
                stringList);

        assertEquals(0, (int) integerList.set(0, -1));
        assertEquals(3, (int) integerList.set(4, 4));
        assertEquals(89, (int) integerList.set(11, 88));
        assertThrows(IndexOutOfBoundsException.class,
                () -> integerList.set(12, 1729));
        assertIterableEquals(List.of(-1, 1, 1, 2, 4, 5, 8,
                13, 21, 34, 55, 88), integerList);

        assertThrows(IndexOutOfBoundsException.class,
                () -> floatList.set(0, 6.022140857e23F));
    }

    @Test
    void testAdd() {
        stringList.add(0, "Buttercup");
        assertEquals(7, stringList.size());
        stringList.add(7, "Seneca");
        assertEquals(8, stringList.size());
        stringList.add(5, "Octavia");
        assertEquals(9, stringList.size());
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.add(10, "Venia"));
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.add(-1, "Venia"));
        assertIterableEquals(
                List.of("Buttercup", "Katniss", "Peeta",
                        "Gale", "Haymitch", "Octavia",
                        "Primrose", "Effie", "Seneca"),
                stringList);

        integerList.add(0, 0);
        integerList.add(144);
        assertEquals(14, integerList.size());
        assertThrows(IndexOutOfBoundsException.class,
                () -> integerList.add(15, 233));
        assertIterableEquals(List.of(0, 0, 1, 1, 2, 3, 5, 8,
                13, 21, 34, 55, 89, 144), integerList);

        assertThrows(IndexOutOfBoundsException.class,
                () -> floatList.add(1, 3.35988F));
        floatList.add(0, 1.30357F);
        floatList.add(1, 1.41421F);
        floatList.add(1, 1.61803F);
        assertEquals(3, floatList.size());
        assertIterableEquals(
                List.of(1.30357F, 1.61803F, 1.41421F),
                floatList);
    }

    @Test
    void testRemove() {
        assertEquals("Katniss", stringList.remove(0));
        assertEquals(5, stringList.size());
        assertEquals("Peeta", stringList.remove(0));
        assertEquals(4, stringList.size());
        assertEquals("Effie", stringList.remove(3));
        assertEquals(3, stringList.size());
        assertEquals("Haymitch", stringList.remove(1));
        assertEquals(2, stringList.size());
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.remove(2));
        assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.remove(-1));
        assertIterableEquals(List.of("Gale", "Primrose"),
                stringList);

        for (int x : List.of(0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89)) {
            assertEquals(x, (int) integerList.remove(0));
        }
        assertThrows(IndexOutOfBoundsException.class,
                () -> integerList.remove(0));
        assertEquals(0, integerList.size());
        assertIterableEquals(List.of(), integerList);

        assertThrows(IndexOutOfBoundsException.class,
                () -> floatList.remove(0));
    }
}