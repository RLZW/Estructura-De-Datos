/*---------------------------------------------------------
 * A01379695 Ra�l Alejandro Fuentes Blanco
 *---------------------------------------------------------
 */

package mx.itesm.cem.examen1;

import java.util.NoSuchElementException;



/**
 * Implementación de una lista sencillamente encadenada, con
 * centinela, que contiene enteros exclusivamente.
 * 
 * @author Ariel Ortiz
 */
public class IntList {
	
	protected int size = 0;
	
    private static class Node {
        int data = 0;
        Node next = null;
    }

    private Node sentinel;

    /**
     * Constructor de la clase.
     */
    public IntList() {
        sentinel = new Node();
    }

    /**
     * Agrega un elemento a esta lista, insertándolo en el
     * lugar correspondiente con el fin de mantener la lista
     * en orden ascendente.
     * 
     * @param newData
     *            El elemento a agregar a esta lista.
     */
    public void add(int newData) {
        Node p = sentinel;
        while (p.next != null && newData > p.next.data) {
            p = p.next;
        }
        Node newNode = new Node();
        newNode.data = newData;
        newNode.next = p.next;
        p.next = newNode;
        size ++;
    }

    /**
     * Devuelve la representación como cadena de caracteres
     * de esta lista.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node p = sentinel.next;
        while (p != null) {
            result.append(p.data);
            if (p.next != null) {
                result.append(", ");
            }
            p = p.next;
        }
        result.append("]");
        return result.toString();
    }

    /**
     * Determina si esta lista contiene elementos.
     * 
     * @return true si la lista está vacía, o false en caso
     *         contrario.
     */
    //Elemento Examen
    public boolean isEmpty() {
        if(sentinel.next == null) {
        	return true;
        }
        else {
        	return false;
        }
    }

    /**
     * Determina el elemento con el valor más grande de esta
     * lista.
     * 
     * @return El elemento más grande de esta lista.
     * 
     * @throws NoSuchElementException
     *             si la lista no contiene elementos.
     */
    
    //Elemento Examen
    public int max() {
    	int max = 0;
    	Node nodeContador = sentinel;
    	for (int i = 0; i <= size; i++) {
			nodeContador = nodeContador.next;
			if(nodeContador.data > max) {
				max = nodeContador.data;
			}
		}
        return max;
    }

    /**
     * Devuelve, como número real de punto flotante, el
     * promedio (media aritmética) de todos los elementos
     * contenidos en esta lista.
     * 
     * @return El promedio de los valores de esta lista.
     * 
     * @throws NoSuchElementException
     *             si la lista no contiene elementos.
     */
    
    //Elemento Examen
    public double average() {
        
        return 0.0;
    }

    /**
     * Remueve de esta lista todos los nodos cuyos valores
     * están comprendidos entre <code>start</code> y
     * <code>end</code>, inclusive.
     * 
     * @param start
     *            inicio inclusivo de rango.
     * @param end
     *            fin inclusivo de rango.
     * @return true si se eliminó por lo menos un nodo, o
     *         false si no se eliminó nodo alguno.
     * @throws IllegalArgumentException
     *             si end es menor que start.
     */
    //Elemento Examen
    public boolean removeBetween(int start, int end) {
        // Coloca tu código aquí.
        return false;
    }
}
