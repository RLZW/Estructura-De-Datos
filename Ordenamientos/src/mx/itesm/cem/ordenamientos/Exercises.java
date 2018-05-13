/*----------------------------------------------------------
 * Práctica 4: Ordenamientos
 * Fecha: 08-Mar-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/


package mx.itesm.cem.ordenamientos;
import java.util.Arrays;
import java.util.*;
import java.util.List;

public class Exercises{
	
	public static <T extends Comparable<T>> List<T> selectionSort(List<T> list){
		List<T> ListEmpty = new ArrayList<T>();
		List<T> ListSorter = new ArrayList<T>();
		ListSorter.addAll(list);
		int size = ListSorter.size();
			while(size > 0) {
				T min = ListSorter.get(0);
				for(T element:ListSorter) {
					if(min.compareTo(element) >= 0) {
						min = element;
					}
				}
				ListSorter.remove(ListSorter.indexOf(min));
				size--;
				ListEmpty.add(min);
			}
		return ListEmpty;
		}
		
		
	
	
	public static List<Integer> bucketSort(List<Integer> list) {
		List<Integer> EmptyList0 = new ArrayList<Integer>();
		List<Integer> EmptyList1 = new ArrayList<Integer>();
		List<Integer> EmptyList2 = new ArrayList<Integer>();
		List<Integer> EmptyList3 = new ArrayList<Integer>();
		List<Integer> EmptyList4 = new ArrayList<Integer>();
		List<Integer> EmptyList5 = new ArrayList<Integer>();
		List<Integer> EmptyList6 = new ArrayList<Integer>();
		List<Integer> EmptyList7 = new ArrayList<Integer>();
		List<Integer> EmptyList8 = new ArrayList<Integer>();
		List<Integer> EmptyList9 = new ArrayList<Integer>();
		
		List<Integer> Concatenada = new ArrayList<Integer>();
		Collections.sort(list);
		
		for(Integer element: list) {
				if(element >= 0 && element < 9) {
					EmptyList0.add(element);
				}
				if(element > 9 && element < 19) {
					EmptyList1.add(element);
				}
				if(element >= 19 && element < 29) {
					EmptyList2.add(element);	
				}
				if(element >= 29 && element < 39) {
					EmptyList3.add(element);
					
				}
				if(element >= 39 && element < 49) {
					EmptyList4.add(element);
					
				}
				if(element >= 49 && element < 59) {
					EmptyList5.add(element);
					
				}
				if(element >= 59 && element < 69) {
					EmptyList6.add(element);
				}
				if(element >= 69 && element < 79) {
					EmptyList7.add(element);
				}
				if(element >= 79 && element < 89) {
					EmptyList8.add(element);
				}
				if(element >= 89 && element <= 99) {
					EmptyList9.add(element);
				}
				
				
		}
		Concatenada.addAll(EmptyList0);
		Concatenada.addAll(EmptyList1);
		Concatenada.addAll(EmptyList2);
		Concatenada.addAll(EmptyList3);
		Concatenada.addAll(EmptyList4);
		Concatenada.addAll(EmptyList5);
		Concatenada.addAll(EmptyList6);
		Concatenada.addAll(EmptyList7);
		Concatenada.addAll(EmptyList8);
		Concatenada.addAll(EmptyList9);
		
		return Concatenada;
		
	}
		
		
		
	
	public static <T extends Comparable<T>> List<T> bogoSort(List<T> list){
		List<T> Copia = new ArrayList<T>();
		List<T> Resultado = new ArrayList<T>();
		Copia.addAll(list);
		Resultado.addAll(list);
		Collections.sort(Copia);
		boolean igualdad = false;
		while(!igualdad) {
			if(Copia.equals(Resultado)){
				igualdad = true;
			}
			else{
				Collections.shuffle(Resultado);
			}
		}
		return Resultado;
		
	}
	
	public static <T extends Comparable<T>> List<T> quickSort(List<T> list){
		List<T> Menores = new ArrayList<T>();
		List<T> Mayores = new ArrayList<T>();
		List<T> Resultado = new ArrayList<T>();
		
		
	
		int size = list.size();
		
		if(size <= 0) {
			return list;
		}
		else {
			T pivote = list.get(0);
			for(T element:list){
				if(element.compareTo(pivote) < 0) {
					Menores.add(element);
				}
				if(element.compareTo(pivote) > 0){
					Mayores.add(element);
		
				}	
				
			}
			
		}
		T pivote = list.get(0);
		Collections.sort(Menores);
		Resultado.addAll(Menores);
		Resultado.add(pivote);
		Collections.sort(Mayores);
		Resultado.addAll(Mayores);
		return Resultado;
		
	}
}
