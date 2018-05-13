/*----------------------------------------------------------
 * Práctica 6: Recursión
 * Fecha: 06-Abr-2018
 * Autores:
 *           A01378843 Sonia Leilani Ramos Nuñez
 *           A01379695 Raúl Alejandro Fuentes Blanco
 *----------------------------------------------------------*/

package mx.itesm.cem.recursion;

import java.util.List;

public class RecursiveAlgorithms {
	
	//Métodos
	
	
	public static int pow(int base, int exponent) {
		 if(exponent == 0) return 1;
		 if(exponent == 1) return base;
		 return base * pow(base, exponent-1);
	}
	public static int gcd(int m, int n) {
		if(m == n) return m;
		else if(m > n) {
			return gcd((m-n),n);
		}
		else if(m < n) {
			return gcd(m,(n-m));
		}
		
		else return n;
	
	}
	
	public static int max(List<Integer> list) {
		if(list.size() == 1) {
			return(list.get(0));
		}
		if(list.size() == 0) {
			return(Integer.MIN_VALUE);
		}
		else {
			if(list.get(0) <= list.get(list.size()-1)) {
				List<Integer> l = list.subList(1, list.size());
				return(max(l));
			}
			if(list.get(0) > list.get(list.size()-1)){
				List<Integer> l = list.subList(0, list.size()-1);
				return(max(l));
				
			}
		}
		return 0;
	}
	
	
	public static int consecutiveAddition(int start, int end) {
		if(start > end) return 0;
		if(start == end){
			return start;
		}
		else {
			System.out.println(start);
			return start + consecutiveAddition(start+1, end);
		}
		
	}
	
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("\\s+","");
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z]", "");
		System.out.print(s);
		if(s.length() == 0 || s.length() == 1) return true;
		if(!(s.charAt(0) == s.charAt(s.length()-1))) return false;
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			String substring = s.substring(1,s.length()-1);
				return isPalindrome(substring);
		}
		return true;
		
		
	}
	
	public static String toBinary(int n) {
		String cadena = "";
		if(n == 0) return cadena;
		if(n > 0) {
			cadena = cadena + toBinary(n/2) + n%2;
		}
		return cadena;
	}



}
