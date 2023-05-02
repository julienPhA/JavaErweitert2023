package de.lbbw.model;

public final class TemperaturException extends Exception{
	public TemperaturException(int temperatur) {
		super("Temperatur zu hoch! " + temperatur);
	}
}