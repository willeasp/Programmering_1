package eu4;

import ou5.ValjPolylinje;

public class Polylinjer {

	public static void main(String[] args) {
		// VPolylinje
		VPolylinje[] vpArray = new VPolylinje[5];
		for(int i = 0; i < vpArray.length; i++)
			vpArray[i] = new VPolylinje(ValjPolylinje.slumpPolylinje().getHorn());
		vpArray[2].setFarg("Gul");
		vpArray[4].setFarg("Gul");
		System.out.println(vpArray[2].langd());
		System.out.println(vpArray[4].langd());
		System.out.println("Den kortaste gula polylinjen i vpArray: " + kortaste_gula(vpArray));
		
		// NPolylinje
		NPolylinje[] npArray = new NPolylinje[5];
		for(int i = 0; i < npArray.length; i++)
			npArray[i] = new NPolylinje(ValjPolylinje.slumpPolylinje().getHorn());
		npArray[3].setFarg("Gul");
		npArray[0].setFarg("Gul");
		System.out.println("\nDen kortaste gula polylinjen i npArray: " + kortaste_gula(npArray));
		
		// VPolylinje & NPolylinje tillsammans
		Polylinje[] pArray = new Polylinje[6];
		for(int i = 0; i < pArray.length; i++) {
			pArray[i++] = new VPolylinje(ValjPolylinje.slumpPolylinje().getHorn());
			pArray[i] = new NPolylinje(ValjPolylinje.slumpPolylinje().getHorn());
		}
		pArray[1].setFarg("Gul");
		pArray[3].setFarg("Gul");
		System.out.println("\nDen kortaste gula polylinjen i pArray: " + kortaste_gula(pArray));

	}
	
	public static Polylinje kortaste_gula (Polylinje[] polylinjer) {
		// bestäm den kortaste av de polylinjer som är gula
				double kortast = Double.POSITIVE_INFINITY;
				Polylinje kortaste_gula = null;
				// int raknare = 0;
				// om färgen inte är gul, börja om loopen
				// om längden på den gula polylinjen är kortare än den tidigare, 
				// sätter man det värdet i kortast, och kopierar referensen till kortaste gula.	
				for(Polylinje p : polylinjer) {
					if(p.getFarg().equals("Gul")) {	
						if (p.langd() < kortast) {
							kortast = p.langd();
							kortaste_gula = p;
						}
					}				
				}
				
				return kortaste_gula;
	}

}
