/*----------------------------------------------------------
 * Práctica 7: Fork/Join
 * Fecha: 23-Abr-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/


package mx.itesm.cem.forkjoin;

import java.util.concurrent.RecursiveAction;


@SuppressWarnings("serial")
public class CountSortAction extends RecursiveAction {
	
	int limit = 100;
	private int[] a, tmp;
	private int low, high; 
	
	CountSortAction(int[] a, int[] tmp, int low, int high) {
		this.a = a;
		this.tmp = tmp;
		this.low = low;
		this.high = high;
	}

	@Override
	protected void compute() {
		
		if(high-low < limit) {
	        //Para cada elemento a[i] del arreglo a, contamos el número de elementos del arreglo que son menores a a[i].
			for (int i = low; i < high; i++) {
	            
				int count = 0;
	            for (int j = 0; j < a.length; j++) {
	                
	            	if (a[j] < a[i]) {
	                    count++;
	                } 
	            	
	            	else if (a[i] == a[j] && j < i) {
	                    count++;
	                }
	            }
	            //Insertamos a[i] a un arreglo temporal usando como índice el resultado del conteo correspondiente.
	            tmp[count] = a[i];
	        }
		}
		else {
			
			int mid = (high+low) / 2;
			
			CountSortAction try_1 = new CountSortAction(a, tmp, low, mid);
			CountSortAction try_2 = new CountSortAction(a, tmp, mid, high);
			
			invokeAll(try_1,try_2);
			
		}
		

	}

}
