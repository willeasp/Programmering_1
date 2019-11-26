package ou5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Ett antal slumpm�ssiga polylinjer skapas och visas. 
 *En polylinje har ett slumpm�ssigt antal h�rn, och f�rgen �r antingen bl�,
 *r�d eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i engelska alfabetet. 
 *Namnen best�ms slumpm�ssigt, men tv� h�rn kan inte ha likadana namn. 
 *Programmet best�mmer och visar den kortaste av de gula polylinjerna.
 */

public class ValjPolylinje {
	public static final Random rand = new Random();
	public static final int ANTAL_POLYLINJER = 10;

	public static void main(String[] args) {
		// skapa ett antal slumpm�ssiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje();
		
		// visa polylinjerna
		String s = Arrays.deepToString(polylinjer);
		Scanner in = new Scanner(s);
		in.useDelimiter(",");
		int num = 0;
		while(in.hasNext()) {
			num++;
			System.out.println(num + ": " + in.next());
		}
		in.close();
		
		
		// best�m den kortaste av de polylinjer som �r gula
		double kortast = Double.POSITIVE_INFINITY;
		Polylinje kortaste_gula = null;
		// int raknare = 0;
		// om f�rgen inte �r gul, b�rja om loopen
		// om l�ngden p� den gula polylinjen �r kortare �n den tidigare, 
		// s�tter man det v�rdet i kortast, och kopierar referensen till kortaste gula.	
		for(Polylinje p : polylinjer) {
			if(p.getFarg().equals("Gul")) {	
				if (p.langd() < kortast) {
					kortast = p.langd();
					kortaste_gula = p;
				}
			}				
		}
			

		// visa den valda polylinjen
		if(kortaste_gula == null) {
			System.out.println("Det fanns ingen gul polylinje.");
		}
		else
			System.out.println("\nKortaste gula polylinjen: " + " " + kortaste_gula.toString());
		
	}

	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor
	// bokstav i det engelska alfabetet, och slumpm�ssiga koordinater, 0-10.
	public static Punkt slumpPunkt() {
		String n = "" + (char) (65 + rand.nextInt(26)); //stor bokstav i engelska alfabetet
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);
		return new Punkt(n, x, y);
	}

	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen
	// bl�, eller r�d eller gul. Namn p� polylinjens h�rn �r 
	// stora bokst�ver i det engelska alfabetet. 
	// Tv� h�rn kan inte ha samma namn.
	public static Polylinje slumpPolylinje() {
		
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje();	// Ny tom polylinje
		int antalHorn = 2 + rand.nextInt(7);	// Antalet h�rn den nya polylinjen ska ha
		int antalValdaHorn = 0;					// Hittils nyskapade slumpade h�rn
		boolean[] valdaNamn = new boolean[26];	// Array med true eller false om man valt ett visst namn
		
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn) {
			valdPunkt = slumpPunkt();	// skapar en slumpm�ssig punkt i valdPunkt
			valtChar = valdPunkt.getNamn().charAt(0);	// H�mtar namnet p� punkten som en character
			int c = valtChar - 65;	//c f�r teckenv�rdet som c har
			if(valdaNamn[c] == true)	//om det tecknet har anv�nts innan, hoppa till b�rjan p� loopen
				continue;
			else {		//l�gg till den valda punkten i polylinjen, s�tt att namnet anv�nts, r�kna upp
				polylinje.laggTill(valdPunkt);	
				valdaNamn[c] = true;
				antalValdaHorn++;
			}
		}
		
		
		// s�tt f�rg
		int f = rand.nextInt(3); // en slumpm�ssig siffra mellan 0 och 2
		switch(f) {
		case 0:
			polylinje.setFarg("Gul");
			break;
		case 1:
			polylinje.setFarg("R�d");
			break;
		case 2:
			polylinje.setFarg("Bl�");
			break;
		}
		
		return polylinje;
	}
}
