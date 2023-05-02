package de.lbbw;

public class TemperaturException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int temperatur;
	public TemperaturException(int temperatur, String message) {
		super(message);
		this.temperatur = temperatur;
	}
	public int getTemperatur() {
		return temperatur;
	}
}
