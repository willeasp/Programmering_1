package eu4;

import java.util.Arrays;
import java.util.Iterator;

import eu4.NPolylinje.NPolylinjeIterator;
import ou5.Punkt;

import ou5.ValjPolylinje;

public class NPolylinjeTest {

	public static void main(String[] args) {
		Punkt[] horn = new Punkt[5];
		horn[0] = new Punkt("Greger", 4, 5);
		horn[1] = new Punkt("Peter", 7, 4);
		for(int i = 2; i < horn.length; i++)
			horn[i] = ValjPolylinje.slumpPunkt();
//		System.out.println(Arrays.deepToString(horn));
		NPolylinje np = new NPolylinje(horn);
//		for(Punkt p : np)
//			System.out.println(p);
//		
//		System.out.println("-----------------");
//		Iterator<Punkt> iter = np.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		System.out.println(Arrays.deepToString(np.getHorn())); //skriver ut arajen
		System.out.println(np.langd());
		np.laggTill(new Punkt(ValjPolylinje.slumpPunkt()));
		
		np.laggTillFramfor(new Punkt("Stig-Arne", 6, 2), "Peter");
		np.taBort("Peter");
		System.out.println(Arrays.deepToString(np.getHorn()));
	}

}
