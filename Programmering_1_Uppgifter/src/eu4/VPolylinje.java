package eu4;

import java.util.Iterator;

import ou5.Punkt;

public class VPolylinje implements Polylinje{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//skapar en helt tom polylinje med standard-f�rg och bredd
	public VPolylinje() {
		this.horn = new Punkt[0];
	}

	//skapar en ny polylinje utifr�n en redan existerande polylinje
	public VPolylinje(Punkt[] horn) {
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt(horn[i]);
	}

	//returnerar en str�ng med polylinjens punkter, f�rg och bredd
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

	//returnerar l�ngden p� polylinjen
	public double langd() {
		double d = 0;
		for(int i=0; i+1 < this.horn.length; i++) {
			d = d + this.horn[i].avstand(this.horn[i+1]);
		}
		return d;
	}

	//g�r en ny array h, l�gger �ver alla v�rden fr�n this.horn, l�gger till en kopia av horn
	public void laggTill(Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt(horn);
		this.horn = h;
	}

	
	// Skapar en ny array med l�ngden av this.horn +1
	// forloop f�r varje p i this.horn, iterator i
	// kollar om namnet p� punkten i this.horn == hornNamn
	// Om false: l�gg till punkten i this.horn till h
	// Om true: L�gg till en kopia av resursen horn refererar till till h, 
	//sen l�gg till punkten i this.horn till h	
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for(Punkt p : this.horn) {
			if(hornNamn.equals(p.getNamn())) {
				h[i++] = new Punkt(horn);
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
	
	class VPolylinjeIterator implements Iterator<Punkt>{

		int aktuell = 0;
		
		@Override
		public boolean hasNext() {
			return aktuell < VPolylinje.this.horn.length && 
					VPolylinje.this.horn[aktuell] != null;
		}

		@Override
		public Punkt next() {
			// TODO Auto-generated method stub
			return VPolylinje.this.horn[aktuell++];
		}
		
	}
	
	@Override
	public Iterator<Punkt> iterator() {	
		Iterator<Punkt> it = new VPolylinjeIterator();
		return it;
	}
	
}
