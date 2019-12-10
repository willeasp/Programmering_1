package eu4;

import java.util.Iterator;

import ou5.Punkt;

public class VPolylinje implements Polylinje{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//skapar en helt tom polylinje med standard-färg och bredd
	public VPolylinje() {
		this.horn = new Punkt[0];
	}

	//skapar en ny polylinje utifrån en redan existerande polylinje
	public VPolylinje(Punkt[] horn) {
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
