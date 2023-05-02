package de.lbbw;

public class Brennkammer {

	private Ofen ofen;

	public Brennkammer(Ofen o) {
		super();
		this.ofen = o;
	}
	
	public void verbrennen(Holz h) throws TemperaturException {
				
		ofen.erhoeheTemperatur(h.brennen());
	}
	
}
