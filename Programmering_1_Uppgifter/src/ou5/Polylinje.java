package ou5;

public class Polylinje {
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//skapar en helt tom polylinje med standard-färg och bredd
	public Polylinje() {
		this.horn = new Punkt[0];
	}

	//skapar en ny polylinje utifrån en redan existerande polylinje
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
			s = s + "[" + p + "] ";
		}
		s = s + " " + farg + " " + bredd;
		return s;
	}

	//returnerar en ny array h med likadana punkter i polylinjen
	public Punkt[] getHorn() {
		Punkt[] h = new Punkt[this.horn.length];
		for(int i = 0; i < this.horn.length; i++)
			h[i] = new Punkt(this.horn[i]);
		return h;			
	}

	//returnerar färgen på polylinjen
	public String getFarg() {
		return this.farg;
	}

	//returnerar bredden på polylinjen
	public int getBredd() {
		return this.bredd;
	}

	//ändrar färgen på polylinjen
	public void setFarg(String farg) {
		this.farg = farg;
	}

	//ändrar bredden på polylinjen
	public void setBredd(int bredd) {
		this.bredd = bredd;
	}

	//returnerar längden på polylinjen
	public double langd() {
		double d = 0;
		for(int i=0; i+1 < this.horn.length; i++) {
			d = d + this.horn[i].avstand(this.horn[i+1]);
		}
		return d;
	}

	//gör en ny array h, lägger över alla värden från this.horn, lägger till en kopia av horn
	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);
		this.horn = h;
	}

	
	// Skapar en ny array med längden av this.horn +1
	// forloop för varje p i this.horn, iterator i
	// kollar om namnet på punkten i this.horn == hornNamn
	// Om false: lägg till punkten i this.horn till h
	// Om true: Lägg till en kopia av resursen horn refererar till till h, 
	//sen lägg till punkten i this.horn till h	
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for(Punkt p : this.horn) {
			if(hornNamn == p.namn) {
				h[i] = new Punkt(horn);
				i++;
				h[i] = p;
			}
			else {
				h[i] = p;
			}				
			i++;
		}
		this.horn = h;
	}

	
	// Initierar en ny array h som är 1 kortare än this.horn
	// För varje punkt p i this.horn:
	// Om hornNamn == namnet på punkten så hoppa över den punkten
	// Om inte, lägg till punkten i h
	// lägg in h i this.horn
	public void taBort(String hornNamn) {
		Punkt[] h = new Punkt[this.horn.length - 1];
		int i = 0;
		for(Punkt p : this.horn) {
			if(hornNamn == p.namn) {
				continue;
			}
			else
				h[i] = p;
			i++;
		}
		this.horn = h;
	}
	
	public class PolylinjeIterator {
		private int aktuell = -1;

		public PolylinjeIterator() {
			if (Polylinje.this.horn.length > 0)
				aktuell = 0;
		}

		public boolean finnsHorn() {
			return aktuell != -1;
		}

		public Punkt horn() throws java.util.NoSuchElementException {
			if (!this.finnsHorn())
				throw new java.util.NoSuchElementException("slut av iterationen");
			Punkt horn = Polylinje.this.horn[aktuell];
			return horn;
		}

		public void gaFram() {
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}

	}
}

//kuken