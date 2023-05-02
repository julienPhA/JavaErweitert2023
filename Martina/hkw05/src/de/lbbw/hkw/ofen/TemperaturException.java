package de.lbbw.hkw.ofen;


public class TemperaturException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int temperatur;
	public TemperaturException(int temperatur, String message) {
		super(message);
	}
	public int getTemperatur() {
		return temperatur;
	}
}

