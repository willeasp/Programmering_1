package ou4;

import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	public static void main(String[] args) {
		out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in tv� naturliga heltal
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		out.println("tv� naturliga heltal:");
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

	// addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar
	// deras summa som en teckenstr�ng.
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

	
	// subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och
	// returnerar
	// deras differens som en teckenstr�ng.
	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.
	public static String subtrahera(String s, String d) {
		String tal1 = "";
		String tal2 = "";
		int iter = 0; // r�knare
		boolean negativ = false; // om resultatet blir negativt
		
		//vilken av s och d �r st�rst
		if (s.length() > d.length()) {
			iter = s.length();
			tal1 = s;
			tal2 = d;
			negativ = false;
			System.out.println("s �r l�ngre �n d: ");			
		} 
		else if(d.length() > s.length()) {
			iter = d.length();
			tal1 = d;
			tal2 = s;
			negativ = true;
			System.out.println("d �r l�ngre �n s: ");
		}
		else if(s.length() == d.length()) {
			int k = (s.length() > d.length())? s.length() : d.length(); //st�rsta v�rdet mellan s och d l�ngd
			for(int i = 0; i < k; i++) {
				if (Character.getNumericValue(s.charAt(0)) > Character.getNumericValue(d.charAt(0))) {
					iter = s.length();
					tal1 = s;
					tal2 = d;
					negativ = false;
					System.out.println("s �r l�ngre �n d: ");
					break;
				}
				else if(Character.getNumericValue(s.charAt(0)) < Character.getNumericValue(d.charAt(0))) {
					iter = d.length();
					tal1 = d;
					tal2 = s;
					negativ = true;
					System.out.println("d �r l�ngre �n s: ");
					break;
				}
			}
		}
		System.out.println("Tal1: " + tal1 + " Tal2: " + tal2 + " Iter: " + iter);
		
		// arbeta igenom varje tal fr�n h�ger
		int j = 1;
		int siffra1;
		int siffra2;
		int minusett = 0; // om man l�nar tiotal fr�n talet till v�nster ska det minskas med ett
		String returnera = "";
		String sres = ""; //resultatet som ska in i returnera
		int res = 0; //resultat av subtraktion av siffrorna
		for (int i = iter - 1; i >= 0; i--) {
			//s�tt v�rdet p� siffra1 och siffra2:
			
			//siffra1
			siffra1 = Character.getNumericValue(tal1.charAt(tal1.length() - j)); // siffra1 f�r v�rdet fr�n stringen
			siffra1 = siffra1 - minusett;
			//siffra2
			if(j <= tal2.length())
				siffra2 = Character.getNumericValue(tal2.charAt(tal2.length() - j));
			else
				siffra2 = 0;
			
			//kolla om man kan g�ra siffra1 - siffra2 eller inte
			if(siffra1 >= siffra2) {
				res = siffra1 - siffra2;
				minusett = 0;
			}
			else if(siffra1 < siffra2){
				siffra1 = siffra1 + 10;
				res = siffra1 - siffra2;
				minusett = 1;
			}
			
			//kolla om man �r i slutet och f�r en nolla
			if(res == 0 & j == iter)
				break;
			
			//Skriv in resultatet i str�ngen
			sres = Integer.toString(res);
			returnera = sres + returnera;
			
			j++;
		}	
		
		if(negativ == true)
			returnera = "-" + returnera;
		return returnera;
	}

	
	// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk
	// operation
	// utf�rd i samband med hetalen
	public static void visa(String tal1, String tal2, String resultat, char operator) {
		// s�tt en l�mplig l�ngd p� heltalen och resultatet
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

	// sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng
	public static String sattLen(String s, int antal) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString();
	}
}
