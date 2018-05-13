/*----------------------------------------------------------
 * Práctica 7: Fork/Join
 * Fecha: 23-Abr-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/


package mx.itesm.cem.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.Random;



@SuppressWarnings("serial")
public class MonteCarloTask extends RecursiveTask<Integer> {
	int limit = 1000;
	private int low, high;
	
	public MonteCarloTask(int low,int high)  {
		this.high = high;
		this.low = low;
	}
	
	@Override
	protected Integer compute() {
		if (high-low < limit) {
			  Random rnd = new Random();
		        int sum = 0;
		        for (int i = low; i < high; i++) {
		        	
		        	// Generar dos números aleatorios entre -1 y 1.
		            
		        	double x = rnd.nextDouble() * 2 - 1;
		            double y = rnd.nextDouble() * 2 - 1;
		            
		            // Aplicar teorema de Pitágoras.
		            double h = x * x + y * y;
		            
		            // Verificar si el tiro cayó dentro del círculo.
		            if (h <= 1) {
		                sum++;
		            }
		        }
		        return sum;
		}
		
		else {
			int mid = ((low + high) / 2);
			
			
			MonteCarloTask try_1 = new MonteCarloTask(low, mid);
			MonteCarloTask try_2 = new MonteCarloTask(mid, high+1);
			
			try_1.fork();
			
			Integer res_1 = try_2.compute();
			Integer res_2 = try_1.join();
			
			Integer resultado_final = res_1 + res_2;
			return resultado_final;
		}
	}

}
