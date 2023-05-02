package de.lbbw;

public class TemperaturException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int aktuelleTemperatur;
	private String warnmeldung;
	
		
	public TemperaturException(int aktuelleTemperatur, String warnmeldung) {
		super(warnmeldung);
		this.aktuelleTemperatur = aktuelleTemperatur;
		this.warnmeldung = warnmeldung;
	}

	@Override
	public String toString() {
		return "TemperaturException [aktuelleTemperatur=" + aktuelleTemperatur + ", warnmeldung=" + warnmeldung + "]";
	}
		
}
