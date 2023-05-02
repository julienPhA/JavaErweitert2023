package de.lbbw;

public class TemperaturException extends Exception{

	public TemperaturException(int temperatur, String message) {
		super(message + temperatur + " Grad");
	}
	
	
}
