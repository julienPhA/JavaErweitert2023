package de.lbbw.ofen;

import de.lbbw.TemperaturException;
import de.lbbw.brennelemente.Holz;
import de.lbbw.global.Brennbar;

public class Ofen {

	private class Brennkammer {

		public Brennkammer() {
			super();
		}
		
		public void verbrennen(Brennbar b) throws TemperaturException {
			Ofen.this.erhoeheTemperatur(b.brennen());
		}	
	}

	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	private Brennkammer bk;
		
	public Ofen(int istTemperatur, int sollTemperatur) {
		super();
		this.istTemperatur = istTemperatur;
		this.sollTemperatur = sollTemperatur;
		this.kuehlTemperatur = 30;
		bk = new Brennkammer();
	}
	
	public void beladen(Object o) {
		
		try {
			bk.verbrennen((Brennbar)o);
		} catch (ClassCastException e) {
			System.out.println("Es wurde ein nicht brennbares Objekt in den Ofen geworfen: " + o.getClass());
		} catch (TemperaturException e) {
			System.out.println(e.getMessage());
			kuehlen();
		} catch (NullPointerException e) {
			System.out.println("Unbekanntes Objekt kann nicht verbrannt werden.");
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
