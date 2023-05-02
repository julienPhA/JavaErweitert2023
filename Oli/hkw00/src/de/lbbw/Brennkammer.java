package de.lbbw;

public class Brennkammer {
	private Ofen ofen;
	
	public Brennkammer(Ofen ofen) {
		super();
		this.ofen = ofen;
	}

	public void verbrennen(Holz h) {
		int wert;
		wert = ofen.getIstTemperatur();
		wert += h.brennen();
		ofen.setIstTemperatur(wert);
	}
}
