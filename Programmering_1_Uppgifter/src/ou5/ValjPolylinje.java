package ou5;

import java.util.Arrays;
import java.util.Random;

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
		System.out.println(Arrays.deepToString(polylinjer));
		
		// bestäm den kortaste av de polylinjer som är gula

		// visa den valda polylinjen
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
	// blå, eller röd
	// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska
	// alfabetet. Två hörn
	// kan inte ha samma namn.
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
			polylinje.laggTill(slumpPunkt());
			antalValdaHorn++;
		}
		
		
		// sätt färg
	}
}
