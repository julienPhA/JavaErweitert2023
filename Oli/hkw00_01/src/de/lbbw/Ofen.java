package de.lbbw;

public class Ofen {
	private int istTemperatur = 0;
	private int sollTemperatur = 0;
	private Brennkammer brennkammer;
	
	public Ofen(int sollTemperatur) {
		super();
		this.sollTemperatur = sollTemperatur;
		brennkammer = new Brennkammer(this);
	}

	public void beladen(Object o) {
		brennkammer.verbrennen((Holz) o);	
	}

	public int getIstTemperatur() {
		return istTemperatur;
	}

	public void setIstTemperatur(int istTemperatur) {
		this.istTemperatur = istTemperatur;
	}

	public int getSollTemperatur() {
		return sollTemperatur;
	}

	public void setSollTemperatur(int sollTemperatur) {
		this.sollTemperatur = sollTemperatur;
	}

	@Override
	public String toString() {
		return "Ofen [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur + "]";
	}
	
	
}
