package ou2;

public class Triangel {
	
	public static void main(String[] args) {
		double[] b = bisektris(3, 4, 5, 60, 50, 30);
		System.out.println(b[0] + "\n" + b[1] + "\n" + b[2]);
		
		for (double item: b) {
	         System.out.println(item);
	      }
	}

	public static double area(double bas, double hojd) {
		double a = bas * hojd / 2;
		return a;
	}
	
	public static double semiperimeter(double a, double b, double c) {
		double s = (a + b + c) / 2;
		return s;
	}
	
	public static double[] bisektris (double a, double b, double c, double alfa, double beta, double charlie){
		double[] bisarray = new double[3];
		
		//Första bisektrisen
		double    p = 2 * b * c * Math.cos (alfa / 2);
		bisarray[0] = p / (b + c);
		
		//andra bisektrisen
		p = 2 * a * c * Math.cos (beta / 2);
		bisarray[1] = p / (a + c);
		
		//tredje bisektrisen
		p = 2 * a * b * Math.cos (charlie / 2);
		bisarray[2] = p / (a + b);
		
		return bisarray;
	}
	
	public double innerCirkel (double a, double b, double c) {
		double s = Triangel.semiperimeter(a, b, c);
		double r = Math.sqrt((s - a)*(s - b)*(s - c) / s);
		return r;		
	}
	
	public static double ytterCirkel (double a, double b, double c) {
		double s = Triangel.semiperimeter(a, b, c);
		double r = (a * b * c) /
				(4 * Math.sqrt(s * (s - a) * (s - b) * (s - c)));
		return r;
	}
}
