package ou5;

public class Polylinje1 {
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//skapar en helt tom polylinje med standard-färg och bredd
	public Polylinje1() {
		this.horn = new Punkt[0];
	}

	//kopierar referensen horn
	public Polylinje1(Punkt[] horn) {
		this.horn = horn;
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

	//returnerar referensen till this.horn
	public Punkt[] getHorn() {
		return this.horn;			
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

	//returnerar antalet punkter
	public double langd() {
		return this.horn.length;
	}

	//gör en ny array h, lägger över alla värden från this.horn, 
	//lägger till en kopia av referensen horn
	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = horn;
		this.horn = h;
	}

	
	// Skapar en ny array med längden av this.horn +1
	// forloop för varje p i this.horn, iterator i
	// kollar om namnet på punkten i this.horn == hornNamn
	// Om false: lägg till punkten i this.horn till h
	// Om true: Lägg till en kopia av referensen horn till h sen punkten i this.horn till h	
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for(Punkt p : this.horn) {
			if(hornNamn == p.getNamn()) {
				h[i] = horn;
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
			if(hornNamn == p.getNamn()) {
				continue;
			}
			else
				h[i] = p;
			i++;
		}
		this.horn = h;
	}
	

}
