package de.lbbw;

public class Ofen {

	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;	
	private Brennkammer brennkammer;
	
	void beladen(Object o) {
		System.out.println("Jetzt wird beladen mit: ");
		System.out.println((Holz)o);
		brennkammer.verbrennen((Holz) o);	
	}

	public void setIstTemperatur(int istTemperatur) {
		this.istTemperatur = istTemperatur;
	}

	public Ofen(int sollTemperatur, int kuehlTemperatur) {
		super();
		this.istTemperatur = 0;
		this.sollTemperatur = sollTemperatur;
		this.kuehlTemperatur = kuehlTemperatur;
		
		this.brennkammer = new Brennkammer(this);
	}

	public int getIstTemperatur() {
		return istTemperatur;
	}

	public int getSollTemperatur() {
		return sollTemperatur;
	}

	public int getKuehlTemperatur() {
		return kuehlTemperatur;
	}
	
	public Brennkammer getBrennkammer() {
		return brennkammer;
	}

	@Override
	public String toString() {
		return "Ofen [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur + ", kuehlTemperatur="
				+ kuehlTemperatur + "]";
	}
		
}
