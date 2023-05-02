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
		this.kuehlTemperatur = 30;
		bk = new Brennkammer(this);
	}
	
	public void beladen(Object o) {
		
		try {
			bk.verbrennen((Holz)o);
		} catch (ClassCastException e) {
			System.out.println("Es wurde ein nicht brennbares Objekt in den Ofen geworfen.");
		} catch (TemperaturException e) {
			System.out.println(e.getMessage());
			kuehlen();
		}
	}
	
	public void erhoeheTemperatur(int brennwert) throws TemperaturException {
		this.istTemperatur = this.istTemperatur + brennwert;	
		System.out.println("neue Temperatur: " + this.istTemperatur);
		
		if(istTemperatur > sollTemperatur) {
			throw new TemperaturException(istTemperatur, "Der Ofen ist zu heiss.");
		}
	}
	
	public void kuehlen() {
		this.istTemperatur = this.istTemperatur - this.kuehlTemperatur;
		System.out.println("neue Temperatur nach dem Kuehlen: " + this.istTemperatur);
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
