package ou5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Ett antal slumpmässiga polylinjer skapas och visas. 
 *En polylinje har ett slumpmässigt antal hörn, och färgen är antingen blå,
 *röd eller gul. Namn på polylinjens hörn är stora bokstäver i engelska alfabetet. 
 *Namnen bestäms slumpmässigt, men två hörn kan inte ha likadana namn. 
 *Programmet bestämmer och visar den kortaste av de gula polylinjerna.
 */

public class ValjPolylinje {
	public static final Random rand = new Random();
	public static final int ANTAL_POLYLINJER = 10;

	public static void main(String[] args) {
		// skapa ett antal slumpmässiga polylinjer
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
		
		
		// bestäm den kortaste av de polylinjer som är gula
		double kortast = 1000000000000000.0;
		Polylinje kortaste_gula = null;
		int raknare = 0;
		for(Polylinje p : polylinjer) {
			if(p.getFarg() != "Gul") {	
				continue;
			}				
			else if (p.langd() < kortast) {
				kortast = p.langd();
				kortaste_gula = p;
			}	
			raknare++;
		}
			

		// visa den valda polylinjen
		System.out.println("\nKortaste gula polylinjen: " + raknare + " " + kortaste_gula.toString());
		
	}

	// slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor
	// bokstav i det engelska alfabetet, och slumpmässiga koordinater, 0-10.
	public static Punkt slumpPunkt() {
		String n = "" + (char) (65 + rand.nextInt(26)); //stor bokstav i engelska alfabetet
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);
		return new Punkt(n, x, y);
	}

	// slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen
	// blå, eller röd eller gul. Namn på polylinjens hörn är 
	// stora bokstäver i det engelska alfabetet. 
	// Två hörn kan inte ha samma namn.
	public static Polylinje slumpPolylinje() {
		
		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje();	// Ny tom polylinje
		int antalHorn = 2 + rand.nextInt(7);	// Antalet hörn den nya polylinjen ska ha
		int antalValdaHorn = 0;					// Hittils nyskapade slumpade hörn
		boolean[] valdaNamn = new boolean[26];	// Array med true eller false om man valt ett visst namn
		
		// ett och samma namn kan inte förekomma flera gånger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn) {
			valdPunkt = slumpPunkt();
			valtChar = valdPunkt.namn.charAt(0);
			int c = valtChar - 65;	//c får teckenvärdet som c har
			if(valdaNamn[c] == true)	//om det tecknet har använts innan, börja om
				continue;
			else {		//lägg till den valda punkten i polylinjen, sätt att namnet redan använts, räkna upp
				polylinje.laggTill(valdPunkt);	
				valdaNamn[c] = true;
				antalValdaHorn++;
			}
		}
		
		
		// sätt färg
		int f = rand.nextInt(3);
		switch(f) {
		case 0:
			polylinje.setFarg("Gul");
			break;
		case 1:
			polylinje.setFarg("Röd");
			break;
		case 2:
			polylinje.setFarg("Blå");
			break;
		}
		
		return polylinje;
	}
}
