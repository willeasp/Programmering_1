package ou5;

public class Punkt {
	int x;
	int y;
	String namn;
	
	public Punkt (String namn, int x, int y) {
		this.namn = namn;
		this.x = x;
		this.y = y;
	}
	
	public Punkt (Punkt that) {
		this.x = that.x;
		this.y = that.y;
		this.namn = that.namn;
	}
	
	@Override
	public String toString() {
		return namn + ": x=" + x + " y=" + y;
	}
	
	public String getNamn() {
		return namn;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double avstand (Punkt that) {
		double d = Math.sqrt( Math.pow( (that.x - this.x), 2)
				+ Math.pow( (that.y - this.y), 2) );
		return d;
	}
	
	public boolean equals (Punkt that) {
		if(that.x == this.x & that.y == this.y)
			return true;
		else 
			return false;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}

