package de.unilog.hkw.ofen;

public class TemperaturException extends Exception {
	int temperatur;
	public TemperaturException(int temperatur, String message) {
		super(message);
	}
	public int getTemperatur() {
		return temperatur;
	}
}
