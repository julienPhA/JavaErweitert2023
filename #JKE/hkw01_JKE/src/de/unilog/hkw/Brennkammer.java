package de.unilog.hkw;



public class Brennkammer {
	private Ofen ofen;
	public void verbrennen(Holz holz) throws TemperaturException {
		int brennwert = holz.brennen();
		System.out.println("Brennkammer: verbrenne Holz mit Brennwert "+brennwert);
		ofen.erhoeheTemperatur(brennwert);
		if(ofen.getIstTemperatur()>ofen.getSollTemperatur()) {
			throw new TemperaturException(ofen.getIstTemperatur()," Ofentemperatur zu hoch ");
		}
		
	}
	public Brennkammer(Ofen ofen) {
		this.ofen = ofen;
	}
}
