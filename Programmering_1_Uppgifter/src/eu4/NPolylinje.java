package eu4;

import java.util.Iterator;

import ou5.Punkt;

public class NPolylinje implements Polylinje {
	private static class Nod {
		public Punkt horn;
		public Nod nastaNod;

		public Nod(Punkt horn) {
			this.horn = horn;
			nastaNod = null;
		}
		
		public String toString() {
			return " Punkt: " + this.horn.toString() + " Nästa nod: " + this.nastaNod.horn.toString();
		}
	}

	private Nod horn;
	private String farg = "svart";
	private int bredd = 1; // pixlar

	public NPolylinje() {
		this.horn = null;
	}

	public NPolylinje(Punkt[] horn) {
		if (horn.length > 0) {
			Nod nod = new Nod(new Punkt(horn[0]));
			this.horn = nod;
			int pos = 1;
			while (pos < horn.length) {
				nod.nastaNod = new Nod(new Punkt(horn[pos++]));
				nod = nod.nastaNod;
			}
		}
	}
	// ytterligare kod här
	
	//returnerar en sträng med polylinjens punkter, färg och bredd
	@Override
	public String toString() {
		String s = "";
		for (Punkt p : this) {
			s = s + "[" + p + "] ";
		}
		s = s + " " + farg + " " + bredd;
		return s;
	}
		
	class NPolylinjeIterator implements Iterator<Punkt>{
		Nod nod = horn;
		
		@Override
		public boolean hasNext() {
			return nod != null;
		}
		@Override
		public Punkt next() {
			Punkt p = nod.horn;
			nod = nod.nastaNod;
			return p;
		}

	}
	@Override
	public Iterator<Punkt> iterator() {
		Iterator<Punkt> it = new NPolylinjeIterator();
		return it;
	}
	
	@Override
	public Punkt[] getHorn() {
		int counter = 0;
		for(Punkt p : this)
			counter++;
		Punkt[] punkter = new Punkt[counter];
		int pos = 0;
		for(Punkt p : this)
			punkter[pos++] = p;
		return punkter;
	}

	@Override
	public String getFarg() {
		return this.farg;
	}

	@Override
	public int getBredd() {
		return this.bredd;
	}

	@Override
	public double langd() {
		double d = 0;
		Nod nod = horn;
		while(nod.nastaNod != null) {
			d = d + nod.horn.avstand(nod.nastaNod.horn);
			nod = nod.nastaNod;			
		}
		return d;
	}

	@Override
	public void setFarg(String farg) {
		this.farg = farg;
	}

	@Override
	public void setBredd(int bredd) {
		this.bredd = bredd;
	}

	@Override
	public void laggTill(Punkt horn) {
		Nod nod = this.horn;
		while(nod.nastaNod != null) {
			nod = nod.nastaNod;
		}
		nod.nastaNod = new Nod(horn);
		nod = nod.nastaNod;
	}

	@Override
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Nod nod = new Nod(new Punkt("Temporary Node", -1, -1));
		nod.nastaNod = this.horn;
		while(!(nod.nastaNod.horn.getNamn().equals(hornNamn))) {
			System.out.println("Inne i while-loop. " + nod.nastaNod.horn.getNamn());
			nod = nod.nastaNod;
		}
		System.out.println("Nästa nod stämmer överens med hornNamn: " + (boolean) (nod.nastaNod.horn.getNamn().equals(hornNamn)));
		System.out.println("Nuvarande hörn: " + nod.horn);
		Nod newNod = new Nod(horn);
		newNod.nastaNod = nod.nastaNod;
		nod.nastaNod = newNod;
	}

	@Override
	public void taBort(String hornNamn) {
		Nod nod = this.horn;
		while(!(nod.nastaNod.horn.getNamn().equals(hornNamn))) {
			nod = nod.nastaNod;
		}
		nod.nastaNod = nod.nastaNod.nastaNod;
	}

	
}