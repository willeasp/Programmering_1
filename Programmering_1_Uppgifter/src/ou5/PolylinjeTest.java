package ou5;

import java.util.Arrays;

public class PolylinjeTest {

	public static void main(String[] args) {
		System.out.println("POLYLINJETEST: \n");
		//TODO Skapa en polylinje
		Polylinje poly = new Polylinje();
		
		//TODO laggTill
		poly.laggTill(new Punkt("P1", 0, 0));
		poly.laggTill(new Punkt("P2", 0, 1));
		poly.laggTill(new Punkt("P3", 2, 1));
		
		//TODO Testa toString
		System.out.println("toString: " + poly.toString());
		
		//TODO getHorn
		System.out.println("getHorn: " + Arrays.toString(poly.getHorn()));
		
		//TODO setFarg
		poly.setFarg("Rosa");
		
		//TODO setBredd
		poly.setBredd(3);
				
		//TODO getFarg
		System.out.println("getFarg: " + poly.getFarg());
		
		//TODO getBredd
		System.out.println("getBredd: " + poly.getBredd());
		
		//TODO langd
		System.out.println("langd: " + poly.langd());
		
		//TODO laggTillFramfor
		poly.laggTillFramfor(new Punkt("PX", 7, 2), "P3");
		System.out.println("laggTillFramfor: " + Arrays.toString(poly.getHorn()));
		
		//TODO taBort
		poly.taBort("P1");
		System.out.println("taBort: " + Arrays.toString(poly.getHorn()));
		
		//TODO Skapa en kopia av polylinjen du har
		Polylinje poly2 = new Polylinje (poly.getHorn());
		System.out.println("poly2: " + poly2.toString());
		
		
		//TODO PolylinjeIterator
		Polylinje.PolylinjeIterator polyIt = poly.new PolylinjeIterator();
		System.out.println("\n\nPolylinjeIterator: ");
		while(polyIt.finnsHorn()) {
			System.out.println("Hörn: " + polyIt.horn() + ", gå fram");
			polyIt.gaFram();
		}
	}

}
