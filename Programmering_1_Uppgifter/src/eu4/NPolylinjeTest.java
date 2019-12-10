package eu4;

import java.util.Arrays;
import java.util.Iterator;

import eu4.NPolylinje.NPolylinjeIterator;
import ou5.Punkt;

import ou5.ValjPolylinje;

public class NPolylinjeTest {

	public static void main(String[] args) {
		Punkt[] horn = new Punkt[5];
		horn[0] = new Punkt("greger", 4, 5);
		for(int i = 1; i < horn.length; i++)
			horn[i] = ValjPolylinje.slumpPunkt();
		System.out.println(Arrays.deepToString(horn));
		NPolylinje np = new NPolylinje(horn);
//		for(Punkt p : np)
//			System.out.println(p);
//		
//		System.out.println("-----------------");
//		Iterator<Punkt> iter = np.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		System.out.println(Arrays.deepToString(np.getHorn()));
		System.out.println(np.langd());
		np.laggTill(new Punkt(ValjPolylinje.slumpPunkt()));
		System.out.println(Arrays.deepToString(np.getHorn()));
		np.laggTillFramfor(new Punkt(ValjPolylinje.slumpPunkt()), "greger");
	}

}
