/*----------------------------------------------------------
 * Práctica 5: Fila genérica
 * Fecha: 15-Mar-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Núñez   
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/



package mx.itesm.cem.filas;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javafx.scene.chart.PieChart.Data;

public class LinkedListQueue<E> extends java.util.AbstractQueue<E>{
	public int size;
	private Node sentinel = new Node();
	
	
	public LinkedListQueue() {
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}
	
	public LinkedListQueue(Collection<E> coll) {
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		
		for(E element:coll) {
			offer(element);
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean offer(E arg0) {
		
        if (arg0 == null){
        	throw new NullPointerException();
        }
        else
        {
        	Node temp = new Node();
    		temp.data = arg0;
    		temp.next = sentinel;
    		temp.prev = sentinel.prev;
    		sentinel.prev.next =  temp;
    		sentinel.prev = temp;
    		size++;
    		return true;  
        }
	}

	@Override //REGRESA PERO NO ELIMINA EL PRIMER ELEMENTO
	public E peek() { 
		if(size == 0){
			return null;
		}
		else {
			Node temp = new Node();
			temp = sentinel.next;
			return temp.data;
		}
		
	}

	@Override //REGRESA Y ELIMINA EL PRIMER ELEMENTO
	public E poll() {
		if(size == 0){
			return null;
		}
		else {
			Node temp = new Node();
			temp = sentinel.next;
			E respuesta = temp.data;
			temp.next.prev = sentinel;
			sentinel.next = temp.next;
			size--;
			return respuesta;		}
	}

	

		
		
	@Override
	public Iterator<E> iterator() {
		return new LinkedListQueueIterator();
	}

	
	public class Node{
		protected E data;
		protected Node next, prev;
		
		public Node() {
			data = null;
			next = null;
			prev = null;
			
		}
		
		public Node(E ddata, Node nnext, Node pprev)
	    {
	        data = ddata;
	        next = nnext;
	        prev = pprev;
	    }
	    	    
	}
	
	 private class LinkedListQueueIterator implements Iterator<E>{
		private Node current = sentinel;
		
		@Override
		public boolean hasNext() {
			return current.next != sentinel;
        }

		@Override
		public E next() {if (!hasNext()) {
            throw new NoSuchElementException();
        }
        current = current.next;
        return (E) current.data;
		}
		 
		}
}
