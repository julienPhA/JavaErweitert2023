package de.lbbw;

public class Ofen {

	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	private Brennkammer bk;
		
	public Ofen(int istTemperatur, int sollTemperatur) {
		super();
		this.istTemperatur = istTemperatur;
		this.sollTemperatur = sollTemperatur;
		bk = new Brennkammer(this);
	}
	
	public void kuehlen() {
		
	}
	
	public void beladen(Object o) {
		bk.verbrennen((Holz)o);		
	}
	
	public void erhoeheTemperatur(int brennwert) {
		this.istTemperatur = this.istTemperatur + brennwert;
		System.out.println("neue Temperatur: " + this.istTemperatur);
	}

	public int getIstTemperatur() {
		return this.istTemperatur;
	}

	public void setIstTemperatur(int istTemperatur) {
		this.istTemperatur = istTemperatur;
	}

	public int getSollTemperatur() {
		return sollTemperatur;
	}

	public int getKuehlTemperatur() {
		return kuehlTemperatur;
	}
	
	
}
