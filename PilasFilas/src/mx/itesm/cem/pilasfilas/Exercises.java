/*----------------------------------------------------------
 * Práctica 3: Ejercicios con pilas y filas
 * Fecha: 26-Feb-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/


package mx.itesm.cem.pilasfilas;
import java.util.*;

public class Exercises {
	
	public static boolean balancedBrackets(String expr){
		  Deque<Character> stack  = new LinkedList<Character>();		//Crea la pila que comprobara si todo esta funcionando.
		  for(int i = 0; i < expr.length(); i++) {
			  char character = expr.charAt(i);
			  if(character == '['  || character == '{' || character == '(') {
				  stack.push(character);
			  }
			  else if(character == ']' || character == '}' || character == ')')
	            {
	                if(stack.isEmpty())
	                    return false;
	                switch(character)
	                {
	                    
	                    case ']':
	                        if (stack.pop() != '[')
	                            return false;
	                        break;
	                    
	                    case '}':
	                        if (stack.pop() != '{')
	                            return false;
	                        break;
	                        
	                    case ')':
	                        if (stack.pop() != '(')
	                            return false;
	                        break;
	                    default:
	                        break;
	                }
	            }
		  }
		  if(stack.isEmpty())
              return true;
          return false;	  
	                
	}
	
	
	
	
	
	public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2){
		Queue<Integer> queue = new LinkedList<>(); 			// Crea la queue de resultado.
		while(q1.peek() != null && q2.peek() != null) { 	//Toma las heads de cada Queue y si no son nulas hace lo siguiente:
			if(q1.peek() <= q2.peek()) { 					//Si q1 es menor o igual añade a q1 al resultado y la condición de abajo hace lo contrario.
				queue.add(q1.poll());	
			}
			else if(q2.peek() < q1.peek()) {
				queue.add(q2.poll());
			}
		}
		
		//SI UNA FILA QUEDA CON ELEMNTOS LA AÑADE COMO COLECCIÓN A LA SIGUIENTE
		if(q1.peek() == null && q2.peek() != null) {
			queue.addAll(q2);
		}
		if(q2.peek() == null && q1.peek() != null) {
			queue.addAll(q1);
		}
		return queue;
	}
	
	
	
	
	
	public static int postfixEvaluation(String expr) {
		Deque<String> pila = new LinkedList<>();
		Queue<String> tokens = tokenize(expr); //Se crea un tokenizer para iterar el string
		int tamaño = tokens.size();
		int i,j = 0;
		for (int e = 0; e < tamaño; e++) {
			 String a = tokens.remove();
			 if(Character.isDigit(a.charAt(0))) {
				 pila.push(a);
			 }
			 else if(a.charAt(0) == '+' || a.charAt(0) == '-' || a.charAt(0) == '*' || a.charAt(0) == '/') {
				 if(pila.size() < 2) {
					 throw new IllegalArgumentException();
				 }
				 i = Integer.parseInt(pila.pop());
				 j = Integer.parseInt(pila.pop());
				 
				 if(a.charAt(0) == '*') {
					 pila.push(i*j + "");
				 }
				 if(a.charAt(0) == '/') {
					 pila.push(j/i + "");
				 }
				 
				 if(a.charAt(0) == '+') {
					 pila.push(i+j + "");
				 }
				 if(a.charAt(0) == '-') {
					 pila.push(j-i + "");
				 }
				
			 }
			 
			 else {
				 throw new IllegalArgumentException();		 
			 }
		}
		if(pila.size() == 1) {
			return Integer.parseInt(pila.pop());
		}
		else {
			throw new IllegalArgumentException();
		}
	}
		
	
	
	
	
	
	public static String convertInfixToPostfix(String expr) {
		Deque<String> pila = new LinkedList<>(); //Pila de Vacía
		Queue<String> fila = new LinkedList<>(); //Fila Vacía
		Queue<String> tokens = tokenize(expr);	//Crea una fila de Tokens y lo inicializa con el parámetro de nuestra función para poderlo iterar.
		int tamaño = tokens.size();			 	//Asignamos el tamaño de nuestra Fila para iterar
		for (int i = 0; i < tamaño; i++) { 		 //For para iterar a nuestro 
			String a = tokens.remove();			//Sacamos la cabeza y la guardamos
			
			if(Character.isDigit(a.charAt(0))) {
				fila.add(a);
			}
			else if(a.charAt(0) == '(') {
				pila.push(a);
			}
			else if(a.charAt(0) == '*' || a.charAt(0) == '/'  || a.charAt(0) == '+' || a.charAt(0) == '-') {
				while((pila.isEmpty() == false) && (pila.peek().charAt(0) != '(')) {
					if(hasHigherPrecedence(pila.peek(), a)) {
						fila.add(pila.pop());
					}else {
						break;
					}
				}
				pila.push(a);
			}
			else if(a.charAt(0) == ')') {
				while((pila.isEmpty() == false) && pila.peek().charAt(0) != '(') {
					fila.add(pila.pop());
				}
				if(pila.isEmpty() == false) {
					pila.pop();
				}
			}
			
		}
		
		if(pila.isEmpty() == false) {
			int tamaño1 = pila.size();
			for (int i = 0; i < tamaño1; i++) {
				fila.add(pila.pop());
			}
		}
		StringBuilder nuevo_string = new StringBuilder();
		int tamaño2 = fila.size();
		for (int i = 0; i < tamaño2; i++) {
			nuevo_string.append(fila.remove());
			if(fila.size()> 0) {
				nuevo_string.append(" ");
			}
		}
		return nuevo_string.toString();
	}
	
	
	
	
	
	
	
	
	//----------------MÉTODOS NECESARIOS-------------------//
	public static boolean hasHigherPrecedence(
	        String stackTop, String operator) {
	    return !((stackTop.equals("+")
	            || stackTop.equals("-"))
	            && (operator.equals("*")
	                    || operator.equals("/")));
	}
	
	
	public static java.util.Queue<String> tokenize(String in) {
	    java.util.regex.Pattern p = java.util.regex.Pattern
	            .compile("(\\s)|(\\d+)|(.)");
	    java.util.regex.Matcher m = p.matcher(in);
	    java.util.Queue<String> result = 
	        new java.util.LinkedList<String>();
	    while (m.find()) {
	        if (m.group(1) == null) {
	            result.add(m.group());
	        }
	    }
	    return result;
	}
	
	
}

			  
			  
			  
			  
			  
			  
	
