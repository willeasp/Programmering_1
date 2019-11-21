package ou3;

public class BestamDenKortasteVagen {

	public static void main(String[] args) {
		double[] a = { 6, 3, 4 };// new double[3+1];
		double[][] b = {{ 2, 5, 5, 3 }, 
						{ 2, 6, 7, 6 },
						{ 10, 8, 5, 7 } };// new double[3+1][4+1];
		double[] c = { 11, 9, 8, 12 };// new double[3+1];

		int[] mellanst = DenKortasteVagen.mellanstationer(a, b, c);
		double kortastlangd = DenKortasteVagen.langd(a, b, c);
		System.out.println("Zon 2: " + mellanst[1] + "\nZon 3: " + mellanst[2] +
				"\nZon 4: " + mellanst[3]);
		System.out.println("\n\nKortast längd: " + kortastlangd);
	}

}
