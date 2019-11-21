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

	public String toString() {
		String s = "";
		int i = 1;
		for(Punkt p : horn) {
			s = s + horn[i].toString() + " ";
			i++;
		}
		s = s + farg + " " + bredd;
		return s;
	}

	public Punkt[] getHorn() {
	}

	public String getFarg() {
	}

	public int getBredd() {
	}

	public void setFarg(String farg) {
	}

	public void setBredd(int bredd) {
	}

	public double langd() {
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
	}

	public void taBort(String hornNamn) {
	}
}
