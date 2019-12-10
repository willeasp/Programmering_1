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
	class NPolylinjeIterator implements Iterator<Punkt>{

		@Override
		public boolean hasNext() {
			return horn.nastaNod != null;
		}

		@Override
		public Punkt next() {
			return horn.nastaNod.horn;
		}

	}
	@Override
	public Iterator<Punkt> iterator() {
		Iterator<Punkt> it = new NPolylinjeIterator();
		return it;
	}
	

	@Override
	public Punkt[] getHorn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFarg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBredd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double langd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFarg(String farg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBredd(int bredd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void laggTill(Punkt horn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taBort(String hornNamn) {
		// TODO Auto-generated method stub
		
	}

	
}