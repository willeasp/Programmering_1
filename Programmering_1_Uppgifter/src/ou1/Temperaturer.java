package ou1;

import java.util.*; // Scanner, Locale

class Temperaturer {
	public static void main(String[] args) {
		System.out.println("TEMPERATURER\n");

		// inmatningsverktyg
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		
		// mata in uppgifter om antalet veckor och antalet m�tningar
		System.out.print("Skriv in hur m�nga veckor som m�tningarna utf�rs p�! \n");
		int antalVeckor = in.nextInt();
		System.out.print("Hur m�nga m�tningar g�rs per vecka? \n");
		int antalMatningarPerVecka = in.nextInt();
		
		// plats att lagra temperaturer
		double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
		
		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++) {
			System.out.println("Skriv in temperaturerna f�r vecka " + vecka + ":");
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
				t[vecka][matning] = in.nextDouble();
		}
		in.close();
		System.out.println();
		
		// visa temperaturerna
		System.out.println("Temperaturerna �r:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++) {
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
				System.out.print(t[vecka][matning] + " ");
			System.out.println();
		}
		System.out.println();
		
		// den minsta, den st�rsta och medeltemperaturen � veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];	
		
				
		// visa den minsta, den st�rsta och medeltemperaturen f�r varje vecka		
		//best�m minsta st�rsta och medeltemperaturen f�r varje vecka
		for(int vecka = 1; vecka<=antalVeckor; vecka++) {
			minT[vecka] = t[vecka][1];
			maxT[vecka] = t[vecka][1];
			sumT[vecka] = t[vecka][1];
			for(int matning = 2; matning <= antalMatningarPerVecka; matning++) {
				if(t[vecka][matning] < minT[vecka])
					minT[vecka] = t[vecka][matning];
				
				if(t[vecka][matning] > maxT[vecka])
					maxT[vecka] = t[vecka][matning];
				
				sumT[vecka] += t[vecka][matning];
			}
			medelT[vecka] = (sumT[vecka] / (antalMatningarPerVecka));
		}
		
		
		//Skriv ut minsta st�rsta och medeltemperaturen f�r varje vecka
		System.out.println("\nMinsta, st�rsta, och medeltemperaturen f�r varje vecka: \n");
		for(int vecka=1; vecka <= antalVeckor; vecka++)
			System.out.println("Vecka " + vecka + ": \nMin: " + minT[vecka] + 
					" | Max: " + maxT[vecka] + " | Medel: " + medelT[vecka] + "\n");
			
		
		// den minsta, den st�rsta och medeltemperaturen - hela m�tperioden
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumMedelTemp = medelT[1];
		double medelTemp = 0;		
		// koden ska skrivas h�r
		
		// visa den minsta, den st�rsta och medeltemperaturen i hela m�tperioden
		//ber�knar minsta st�rsta och medel f�r hela m�tperioden
		for(int vecka=2; vecka <= antalVeckor; vecka++) {
			if(minT[vecka] < minTemp)
				minTemp = minT[vecka];
			if(maxT[vecka] > maxTemp)
				maxTemp = maxT[vecka];
			sumMedelTemp += medelT[vecka];			
		}
		medelTemp = (sumMedelTemp / antalVeckor);
		
		//skriver ut minsta st�rsta och medel f�r hela m�tperioden
		System.out.println("\nMinsta, st�rsta och medel f�r hela m�tperioden: \n");
		System.out.println("Minsta: "+ minTemp +" | St�rsta: "+ maxTemp +" | Medel: "+ medelTemp);
		
		// koden ska skrivas h�r
	}
}
