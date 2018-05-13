package mx.itesm.cem.arreglos;

import java.util.AbstractList;


// Versión 1: Lissta inmutable.
public class TecArrayList<E> extends AbstractList<E> {
	//E significa Element, cualquier cosa puede ser E y solo sabremos que es hasya que este instanciada.
	
	private E[] data;
	private int capacity = 10;
	private int size = 0;

	public TecArrayList(E... args) { //Recibe un número variable de argumentos (E...) y se guardaran en args el cual es un arreglo.
		data = (E[])new Object[capacity];
		for(E element: args) {
			add(element);	
		}
	}
	
	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public int size() {
		return size;
	}
	@Override
	public E set(int index, E elemento) {
		// TODO Auto-generated method stub
		E anterior = get(index);
		data[index] = elemento;
		return anterior;
	}

}
