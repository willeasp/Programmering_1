package eu4;

import java.util.Arrays;

import ou5.Punkt;

import ou5.ValjPolylinje;

public class NPolylinjeTest {

	public static void main(String[] args) {
		Punkt[] horn = new Punkt[5];
		for(int i = 0; i < horn.length; i++)
			horn[i] = ValjPolylinje.slumpPunkt();
		NPolylinje np = new NPolylinje(horn);
		for(Punkt p : np)
			System.out.println(p);
		

	}

}
