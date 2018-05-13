	/*----------------------------------------------------------
	 * Práctica 8: Árboles binarios 
	 * Fecha: 07-May-2018
	 * Autores:
	 *           A01378843 Sonia Leilani Ramos Nuñez
	 *           A01379695 Raúl Alejandro Fuentes Blanco
	 *----------------------------------------------------------*/
	package mx.itesm.cem.arboles;
	
	import java.util.AbstractSet;
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Queue;
	
	public class BinarySearchTreeSet<E extends Comparable<E>>
	        extends AbstractSet<E> {
	
		//Se crea la clase Node con sus respectivos constructores
	    private static class Node<E> {
	        private E data;
	        private Node<E> izq;
	        private Node<E> der;
	    //Contructor nodos
	        public Node(E data, Node<E> izq, Node<E> der) {
	            this.data = data;
	            this.izq = izq;
	            this.der = der;
	        }
	        
	    //Constructor Nodos
	        public Node(E data) {
	            this(data, null, null);
	        }
	    }
	
	    
	    
	    private Node<E> root = null;  //Root node is created
	    private int size = 0; 		 //Size 
	    private int height = 0;		//Height
	
	    
	    //Iterador
	    @Override
	    public Iterator<E> iterator() {        
	        return inOrderList().iterator();
	    }
	    
	    //PreOrderList
	    public List<E> preOrderList() {
	        List<E> result = new LinkedList<>();
	        preOrder(root, result);
	        return result;
	    }
	
	    //PreOrderMethod
	    private void preOrder(Node<E> p, List<E> result) {
	        if (p != null) {
	        	height++;
	            result.add(p.data);
	            preOrder(p.izq, result);
	            preOrder(p.der, result);
	        }
	    }
	
	    //inOrderList
	    public List<E> inOrderList() {
	        List<E> result = new LinkedList<>();
	        inOrder(root, result);
	        return result;
	    }
	
	    //inOrderMethod
	    private void inOrder(Node<E> p, List<E> result) {
	        if (p != null) {
	            inOrder(p.izq, result);
	            result.add(p.data);
	            inOrder(p.der, result);
	        }
	    }
	
	    //postOrderList
	    public List<E> postOrderList() {
	        List<E> result = new LinkedList<>();
	        postOrder(root, result);
	        return result;
	    }
	
	    //postOrderMethod
	    private void postOrder(Node<E> p, List<E> result) {
	        if (p != null) {
	        	postOrder(p.izq, result);
	            postOrder(p.der, result);
	            result.add(p.data);
	        }
	    }
	    
	    //levelOrderList
	    public List<E> levelOrderList() {
	        List<E> result = new LinkedList<>();
	        Queue<Node<E>> queue = new LinkedList<>();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            Node<E> p = queue.poll();
	            if (p != null) {
	                queue.offer(p.izq);
	                queue.offer(p.der);
	                result.add(p.data);
	            }
	        }
	        return result;
	    }
	
	    @Override
	    public int size() {
	        return size;
	    }
	
	    @Override
	    public boolean add(E element) {
	        if (root == null) {
	            root = new Node<>(element);
	            size++;
	            return true;
	        } else {
	            Node<E> p = root;
	            while (true) {
	                if (element.compareTo(p.data) == 0) {
	                    return false;
	                } else if (element.compareTo(p.data) < 0) {
	                    if (p.izq == null) {
	                        p.izq = new Node<>(element);
	                        size++;
	                        return true;
	                    } else {
	                        p = p.izq;
	                    }
	                } else { // element > p.data
	                    if (p.der == null) {
	                        p.der = new Node<>(element);
	                        size++;
	                        return true;
	                    } else {
	                        p = p.der;
	                    }
	                }
	            }
	        }
	    }
	    
	    
	    
	    
	    //NUEVOS MÉTODOS
	    
	    public int height() {
	    	return maxHeight(root);
	    }
	    
	    public int leafCount() {
	    	return getLeafCount(root);
	    }
	    
	    public boolean isPerfect() {
			Queue<Node<E>> queue = toList();
			
			
			if(queue.size() <= 1) { 
				return true;
			}
			
			if(queue.size() > Math.pow(2, height()) && isFull()) {
				
				while(queue.size() != Math.pow(2, height())) {
					queue.poll();
				}
				
				for(Node<E> e: queue) {
					if(!haveLeaf(e)) return false;
				}
				
				return true;
			}
			return false;
		}
	    
	    public boolean isDegenerate() {
	    	
	    	Queue<Node<E>> list = toList();
	    	int i = 0;
			
	    	if(list.size() <= 1) {
				return false;
			}
			
			for(Node<E> element: list) {
				
				if(element.der!= null && element.izq != null) return false;
		
				else if(element.der != null && element.izq == null || !(element.der != null && element.izq == null)) {
					i++;
				}
			}
			return i == size();
	    }
	    
	    
	    public boolean isFull() {
	    	Queue<Node<E>> list = toList();
			int i = 0;
			
			for(Node<E> element: list) {
				
				if((element.der != null & element.izq != null) || (haveLeaf(element))) {
					i++;
				}
			}
			return i == size();
	    }
	    
	    
	    public int heightNode(Node<E> node){
	    	int res = 0;
	    	while(node != null){
	    		res++;
	    		node = node.izq;
	    	}
	    	return res;
	    	
	    }
	    
	    public int maxHeight(Node<E> node) {
	    	if (node == null)
	            return -1;
	        else
	        {
	            int izqDepth = maxHeight(node.izq);
	            int derDepth = maxHeight(node.der);
	  
	            if (izqDepth > derDepth)
	                return (izqDepth + 1);
	             else
	                return (derDepth + 1);
	        }
	    }
	    
	    
	    private boolean haveLeaf(Node<E> element) {
	    	boolean respuesta = element != null && element.izq == null && element.der == null;
			return respuesta;
		}
	    
	    
	    public int getLeafCount(Node<E> node) {
	        if (node == null)
	            return 0;
	        if (node.izq == null && node.der == null)
	            return 1;
	        else
	            return getLeafCount(node.izq) + getLeafCount(node.der);
	    }
	    
	    
	    private Queue<Node<E>> toList(){
	    	Queue<Node<E>> queue = new LinkedList<>();
	    	
	    	
	    	Queue<Node<E>> list = new LinkedList<>();
			
	 
			queue.offer(root);
			
			while(!queue.isEmpty()) {
				Node<E> coso = queue.poll();
				if(coso != null) {
					queue.offer(coso.izq);
					queue.offer(coso.der);
					list.add(coso);
				}
			}
			return list;
		}
				
	}
			