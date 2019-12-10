package eu4;

import ou5.Punkt;
import ou5.ValjPolylinje;

public class VPolylinjeTest {

	public static void main(String[] args) {
		VPolylinje vp = new VPolylinje();
		for(int i = 0; i < 5; i++)
			vp.laggTill(ValjPolylinje.slumpPunkt());
		
		for(Punkt p : vp)
			System.out.println(p + "hej");
		
	}

}
