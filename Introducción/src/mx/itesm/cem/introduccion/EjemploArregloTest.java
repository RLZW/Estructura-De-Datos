package mx.itesm.cem.introduccion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EjemploArregloTest {

	@Test //Anotaci�n al igual que @override
	void testIndiceArreglo() {
		
		String[] a = new String[] {
				"Buttercup",
				"Primrose",
				"Katniss",
				"Chiquetere",
				"Peeta",
			};
		
		
		assertEquals(2,EjemploArreglos.indiceArreglo(a, "Katniss"));
		assertEquals(-1,EjemploArreglos.indiceArreglo(a, "Katnip"));
		assertEquals(4,EjemploArreglos.indiceArreglo(a, "Peeta"));
	}
}




