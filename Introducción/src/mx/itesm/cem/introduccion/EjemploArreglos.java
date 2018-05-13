package mx.itesm.cem.introduccion;

public class EjemploArreglos {
	
	public static int indiceArreglo(String[] info, String elemento){
		for (int i = 0; i < info.length; i++) {
			if(info[i].equals(elemento)) {
				return(i);
			}	
		}
		return -1;
	}
}
