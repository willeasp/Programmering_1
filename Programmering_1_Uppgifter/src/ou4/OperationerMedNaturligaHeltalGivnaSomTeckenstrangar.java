package ou4;

import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	public static void main(String[] args) {
		out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in två naturliga heltal
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		out.println("två naturliga heltal:");
		String tal1 = in.next();
		String tal2 = in.next();
		in.close();
		out.println();

		// addera heltalen och visa resultatet
		String summa = addera(tal1, tal2);
		visa(tal1, tal2, summa, '+');
		
		//subtrahera heltalen och visa resultatet 
		String subtr = subtrahera(tal1, tal2); 
		visa(tal1, tal2, subtr, '-');
	}

	// addera tar emot två naturliga heltal givna som teckensträngar, och returnerar
	// deras summa som en teckensträng.
	public static String addera(String tal1, String tal2) {
		int plusett = 0;
		int iter;
		String returnera = "";

		if (tal1.length() > tal2.length())
			iter = tal1.length();
		else
			iter = tal2.length();

		int j = 1;
		int siffra1;
		int siffra2;
		for (int i = iter - 1; i >= 0; i--) {
			if (j <= tal1.length())
				siffra1 = Character.getNumericValue(tal1.charAt(tal1.length() - j));
			else
				siffra1 = 0;

			if (j <= tal2.length())
				siffra2 = Character.getNumericValue(tal2.charAt(tal2.length() - j));
			else
				siffra2 = 0;

			int res = siffra1 + siffra2 + plusett;
			plusett = 0;
			if (res > 9)
				plusett = 1;

			String sres = Integer.toString(res);

			returnera = sres.charAt(sres.length() - 1) + returnera;

			j++;
		}

		if (plusett == 1)
			returnera = "1" + returnera;

		return returnera;
	}

	
	// subtrahera tar emot två naturliga heltal givna som teckensträngar, och
	// returnerar
	// deras differens som en teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.
	public static String subtrahera(String s, String d) {
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

	
	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk
	// operation
	// utförd i samband med hetalen
	public static void visa(String tal1, String tal2, String resultat, char operator) {
		// sätt en lämplig längd på heltalen och resultatet
		int len1 = tal1.length();
		int len2 = tal2.length();
		int len = resultat.length();
		int maxLen = Math.max(Math.max(len1, len2), len);

		tal1 = sattLen(tal1, maxLen - len1);
		tal2 = sattLen(tal2, maxLen - len2);
		resultat = sattLen(resultat, maxLen - len);

		// visa heltalen och resultatet
		out.println(" " + tal1);
		out.println("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println();
		out.println("=" + resultat + "\n");
	}

	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen(String s, int antal) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString();
	}
}
