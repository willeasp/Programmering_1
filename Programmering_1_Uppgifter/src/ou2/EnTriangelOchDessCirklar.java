package ou2;

import java.util.Scanner;

public class EnTriangelOchDessCirklar {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Skriv in de tre sidorna på triangeln.");
		
		double a = 0;
		while(true) {
			System.out.println("a: ");
			a = in.nextDouble();
			if(a <= 0)
				System.out.println("längden kan inte vara negativ eller 0");
			else
				break;
		}
			
		
		double b = 0;
		while(true) {
			System.out.println("b: ");
			b = in.nextDouble();
			if(b <= 0)
				System.out.println("längden kan inte vara negativ eller 0");
			else
				break;
		}
		
		double c = 0;
		while(true) {
			System.out.println("c: ");
			c = in.nextDouble();
			if(c <= 0)
				System.out.println("längden kan inte vara negativ eller 0");
			else
				break;
		}
		
		in.close();
		
		Triangel t = new Triangel();
		double r = t.innerCirkel(a, b, c);
		System.out.printf("\nRadie inre cirkel i triangeln: %.2f" , r);
		
		double R = Triangel.ytterCirkel(a, b, c);
		System.out.printf("\nRadie yttre cirkel på triangeln: %.2f" , R);
		
		System.out.println("\n\n" + r + " " + R);
	}

}
