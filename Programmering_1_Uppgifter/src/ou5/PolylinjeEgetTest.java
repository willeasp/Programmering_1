package ou5;

public class PolylinjeEgetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polylinje p = new Polylinje(); //p är ett objekt av typen Polylinje
		System.out.println(p.toString());
		Punkt a = new Punkt("a", 3, 5);
		p.laggTill(a);
		System.out.println(p.toString());
	}

}
