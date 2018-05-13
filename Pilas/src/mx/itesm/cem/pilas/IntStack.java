/*----------------------------------------------------------
 * Práctica 2: Pila de enteros
 * Fecha: 09-Feb-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/

package mx.itesm.cem.pilas;

public class IntStack {
	public int arreglo[];
	public int max, last;
	
	public IntStack(int max) {
		this.max = max;
		arreglo = new int[max];
		last = 0;
	}
	
	public void push(int x) {
		if(last < max) {
			arreglo[last] = x;
			last++;
		}
		else {
			throw new IllegalStateException("Stack Overflow");
		}
	}
	
	public int pop(){
		if(last > 0 ) {
			int regreso = arreglo[last-1];
			arreglo[last-1] = 0;
			last --;
			return regreso;
		}
		else {
			throw new java.util.NoSuchElementException("Stack Underflow");
		}
		
		
	}
	
	public int peek() {
		if(last > 0 ) {
			return arreglo[last-1];
		}
		else {
			throw new java.util.NoSuchElementException("Stack Underflow");
		}
		
	}
	
	public boolean isEmpty() {
		if(last == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return last;
		
	}
	
}
