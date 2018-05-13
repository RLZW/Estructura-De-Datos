package mx.itesm.cem.introduccion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = new String[] {
			"Buttercup",
			"Primrose",
			"Katniss",
			"Chiquetere",
			"Peeta",
			
		};
		
		int i = EjemploArreglos.indiceArreglo(a, "Katniss");
		System.out.println(i);
		i = EjemploArreglos.indiceArreglo(a, "Katnip");
		System.out.println(i);
		
		
		
	}

}
