package ou3;

class DenKortasteVagen {

	// mellanstationer returnerar en vektor med de mellanstationer som finns på den
	// kortaste
	// vägen. Ordningsnummer av den första mellanstationen finns på index 1, och
	// ordningsnummer
	// av den andra mellanstationen på index 2 i vektorn.
	public static int[] mellanstationer(double[] a, double[][] b, double[] c) {
		
		//kolla vilken väg som är kortast och spara mellanstationerna
		double kortast = a[0] + b[0][0] + c[0];
		int stationer[] = new int[3 + 1];
		
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b[i].length; j++) {
				
				if (a[i] + b[i][j] + c[j] < kortast) {
					kortast = a[i] + b[i][j] + c[j];
					//System.out.println(kortast);
					stationer[1] = i;
					stationer[2] = j;
					stationer[3] = 1;
				}					
			}
		return stationer;		
	}

	// langd returnerar längden av den kortaste vägen.
	public static double langd(double[] a, double[][] b, double[] c) {
		//kollar kortaste längden av alla stationer
		int[] stationer = mellanstationer(a, b, c);
		double kortast = a[stationer[1]] + b[stationer[1]][stationer[2]] + c[stationer[2]];	
		return kortast;
	}
}
