/*----------------------------------------------------------
 * Práctica 1: Listas encadenadas
 * Fecha: 02-Feb-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/

package mx.itesm.cem;

import java.util.AbstractList;

public class TecLinkedList<E> extends AbstractList<E> {
	
	 
		public static class Node<E> {
		        public E info;
		        public Node<E> next;
		        public Node<E> prev;
		        public Node() {
		        	this.info = null;
		        	this.next = null;
		        	this.prev = null;
		        }
		        
		        public Node(E info, Node<E> next) {
		            this.info = info;
		            this.next = next;
		        }
		        
		        public Node(E info, Node<E> next, Node<E> prev) {
		            this.info = info;
		            this.next = next;
		            this.prev = prev;
		        }
		        public Node(E info) {
		            this(info, null);
		        }
		        
		    }
		
	    
	
	
	protected Node<E> start = new Node<>(null);
	protected Node<E> end = new Node<>(null);
    protected int size = 0;
    
   
    
    public TecLinkedList() {
		this.size = 0;
		this.start = new Node<E>();
		this.end = new Node<E>();
		this.start.next = this.end;
		this.end.prev = this.start;
	}
    
    @SuppressWarnings("unchecked")
	public TecLinkedList(E...args){
//    	this.size = args.length;
//		this.start = new Node<E>();
//		this.end = new Node<E>();
//		this.start.next = this.end;
//		this.end.prev = this.start;
    	for(E element : args) {
    		add(element);
    	} 	
    }
    
    
    
   
    public E set(int index, E element) {
    	E elementoquitado; 
    	if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
    	if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
    	
    	Node<E> nodeSet = start;
    	
    	for (int i = 0; i <= index; i++) {
			nodeSet = nodeSet.next;
		}
    	
    	elementoquitado = nodeSet.info;
    	nodeSet.info = element;
    	return elementoquitado;
    }
	
	public E remove(int index) {
		E elementoquitado;
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		
		Node<E> nodeSet = start;
    	for (int i = 0; i < index; i++) {
			nodeSet = nodeSet.next;
		}
    	elementoquitado = nodeSet.next.info;
    	nodeSet.next = nodeSet.next.next;
    	size--;
		return elementoquitado;
		}
    
    
	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException("Invalid element input!");
		}
		
		Node<E> nodeAdd = new Node<E>(element);
		Node<E> nodeIndex = start;
		
		for (int i = 0; i < index; i++) {
			nodeIndex = nodeIndex.next;
		}
		nodeAdd.next = nodeIndex.next;
		nodeIndex.next = nodeAdd;
		size++;
		
	}
	
	
	
	
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		
		Node<E> focus = start;
		for (int i = 0; i <= index; i++) {
			focus = focus.next;
		}
		
		E valor = focus.info;
		return valor;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
