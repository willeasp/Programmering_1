package ou5;

public class Polylinje1 {
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//skapar en helt tom polylinje med standard-f�rg och bredd
	public Polylinje1() {
		this.horn = new Punkt[0];
	}

	//kopierar referensen horn
	public Polylinje1(Punkt[] horn) {
		this.horn = horn;
	}

	//returnerar en str�ng med polylinjens punkter, f�rg och bredd
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

	//returnerar f�rgen p� polylinjen
	public String getFarg() {
		return this.farg;
	}

	//returnerar bredden p� polylinjen
	public int getBredd() {
		return this.bredd;
	}

	//�ndrar f�rgen p� polylinjen
	public void setFarg(String farg) {
		this.farg = farg;
	}

	//�ndrar bredden p� polylinjen
	public void setBredd(int bredd) {
		this.bredd = bredd;
	}

	//returnerar antalet punkter
	public double langd() {
		return this.horn.length;
	}

	//g�r en ny array h, l�gger �ver alla v�rden fr�n this.horn, 
	//l�gger till en kopia av referensen horn
	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = horn;
		this.horn = h;
	}

	
	// Skapar en ny array med l�ngden av this.horn +1
	// forloop f�r varje p i this.horn, iterator i
	// kollar om namnet p� punkten i this.horn == hornNamn
	// Om false: l�gg till punkten i this.horn till h
	// Om true: L�gg till en kopia av referensen horn till h sen punkten i this.horn till h	
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

	
	// Initierar en ny array h som �r 1 kortare �n this.horn
	// F�r varje punkt p i this.horn:
	// Om hornNamn == namnet p� punkten s� hoppa �ver den punkten
	// Om inte, l�gg till punkten i h
	// l�gg in h i this.horn
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
