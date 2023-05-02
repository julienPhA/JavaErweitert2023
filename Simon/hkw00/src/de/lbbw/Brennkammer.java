package de.lbbw;

public class Brennkammer {

	private Ofen ofen;
	
	public Brennkammer(Ofen ofen) {
		super();
		this.ofen = ofen;
	}
	
	public void verbrennen(Holz holz) {
		
		int wert;
						
		wert = ofen.getIstTemperatur();
		wert += holz.brennen();
									
		ofen.setIstTemperatur(wert);
	}

	public Ofen getOfen() {
		return ofen;
	}
	
}
