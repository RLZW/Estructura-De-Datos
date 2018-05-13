package mx.itesm.cem;

public class TecLista<E> {
    
    private static class Node<E> {
        public E info;
        public Node<E> next;
        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
        public Node(E info) {
            this(info, null);
        }
    }
    
    public int size() {
    	
    }
    
    private Node<E> start = new Node<>(null);
    
    public void add(E info) {
        Node<E> nuevo = new Node<>(info, start.next);
        start.next = nuevo;
    }
    
    @Override
    public String toString() {
    	StringBuilder resultado = new StringBuilder("[");
        Node<E> nodo = start.next;
        while (nodo != null) {
            resultado.append(nodo.info);
            if(nodo.next != null) {
            	resultado.append(", ");
            }
        }
        resultado.append("]");
        return resultado.toString();
    }
}