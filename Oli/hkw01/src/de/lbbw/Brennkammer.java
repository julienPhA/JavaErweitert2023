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
		
		System.out.println("Verbrenne " + h.getTyp() + " mit Brennwert " + h.brennen());
		
		try {
			ofen.setIstTemperatur(wert);
		
		} catch (TemperaturException e) {
			System.out.println(e.getMessage());
			ofen.kuehlen();
			
		}
	}
}
