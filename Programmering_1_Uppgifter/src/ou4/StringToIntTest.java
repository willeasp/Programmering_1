package ou4;

import java.util.Scanner;

public class StringToIntTest {

	public static void main(String[] args) {
		System.out.println(subtraktion("10","9"));
	}

	public static String subtraktion(String s, String d) {
		String tal1 = "";
		String tal2 = "";
		int iter = 0; // räknare
		boolean negativ = false; // om resultatet blir negativt
		
		//vilken av s och d är störst
		if (s.length() > d.length()) {
			iter = s.length();
			tal1 = s;
			tal2 = d;
			negativ = false;
			System.out.println("s är längre än d: ");			
		} 
		else if(d.length() > s.length()) {
			iter = d.length();
			tal1 = d;
			tal2 = s;
			negativ = true;
			System.out.println("d är längre än s: ");
		}
		else if(s.length() == d.length()) {
			int k = (s.length() > d.length())? s.length() : d.length(); //största värdet mellan s och d längd
			for(int i = 0; i < k; i++) {
				if (Character.getNumericValue(s.charAt(0)) > Character.getNumericValue(d.charAt(0))) {
					iter = s.length();
					tal1 = s;
					tal2 = d;
					negativ = false;
					System.out.println("s är längre än d: ");
					break;
				}
				else if(Character.getNumericValue(s.charAt(0)) < Character.getNumericValue(d.charAt(0))) {
					iter = d.length();
					tal1 = d;
					tal2 = s;
					negativ = true;
					System.out.println("d är längre än s: ");
					break;
				}
			}
		}
		System.out.println("Tal1: " + tal1 + " Tal2: " + tal2 + " Iter: " + iter);
		
		// arbeta igenom varje tal från höger
		int j = 1;
		int siffra1;
		int siffra2;
		int minusett = 0; // om man lånar tiotal från talet till vänster ska det minskas med ett
		String returnera = "";
		String sres = ""; //resultatet som ska in i returnera
		int res = 0; //resultat av subtraktion av siffrorna
		for (int i = iter - 1; i >= 0; i--) {
			//sätt värdet på siffra1 och siffra2:
			
			//siffra1
			siffra1 = Character.getNumericValue(tal1.charAt(tal1.length() - j)); // siffra1 får värdet från stringen
			siffra1 = siffra1 - minusett;
			//siffra2
			if(j <= tal2.length())
				siffra2 = Character.getNumericValue(tal2.charAt(tal2.length() - j));
			else
				siffra2 = 0;
			
			//kolla om man kan göra siffra1 - siffra2 eller inte
			if(siffra1 >= siffra2) {
				res = siffra1 - siffra2;
				minusett = 0;
			}
			else if(siffra1 < siffra2){
				siffra1 = siffra1 + 10;
				res = siffra1 - siffra2;
				minusett = 1;
			}
			
			//kolla om man är i slutet och får en nolla
			if(res == 0 & j == iter)
				break;
			
			//Skriv in resultatet i strängen
			sres = Integer.toString(res);
			returnera = sres + returnera;
			
			j++;
		}	
		
		if(negativ == true)
			returnera = "-" + returnera;
		return returnera;

	}
			

	public static String addition(String s, String d) {
		int plusett = 0;
		int iter;
		String returnera = "";

		if (s.length() > d.length())
			iter = s.length();
		else
			iter = d.length();		
		

		int j = 1;
		int siffra1;
		int siffra2;
		for (int i = iter - 1; i >= 0; i--) {
			
			//sätt siffrorna på platsen längst till höger - iter-1
			if (j <= s.length())
				siffra1 = Character.getNumericValue(s.charAt(s.length() - j));
			else
				siffra1 = 0;

			if (j <= d.length())
				siffra2 = Character.getNumericValue(d.charAt(d.length() - j));
			else
				siffra2 = 0;

			//ta bort resten från siffra1

			
		}

		if (plusett == 1)
			returnera = "1" + returnera;

		return returnera;

	}

}
