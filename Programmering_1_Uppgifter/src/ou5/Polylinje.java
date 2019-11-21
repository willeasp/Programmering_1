package ou5;

public class Polylinje {
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje() {
		this.horn = new Punkt[0];
	}

	public Polylinje(Punkt[] horn) {
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt(horn[i]);
	}

	//returnerar en sträng med polylinjens punkter, färg och bredd
	@Override
	public String toString() {
		String s = "";
		for(Punkt p : horn) {
			s = s + " " + p;
		}
		s = s + " " + farg + " " + bredd;
		return s;
	}

	public Punkt[] getHorn() {
		return this.horn;
	}

	public String getFarg() {
		return this.farg;
	}

	public int getBredd() {
		return this.bredd;
	}

	public void setFarg(String farg) {
		this.farg = farg;
	}

	public void setBredd(int bredd) {
		this.bredd = bredd;
	}

	public double langd() {
		return this.horn.length;
	}

	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);
		this.horn = h;
	}

	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		h[0] = horn;
		h[0].setNamn(hornNamn);
		for(int i = 0; i < this.horn.length; i++) {
			h[i +1] = this.horn[i];
		}
		this.horn = h;
	}

	public void taBort(String hornNamn) {
		
	}
}
