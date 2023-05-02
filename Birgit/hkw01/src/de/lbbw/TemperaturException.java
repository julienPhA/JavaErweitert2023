package de.lbbw;

public class TemperaturException extends Exception{

	public TemperaturException(int temperatur) {
		
		System.out.println("zu heiss: " + temperatur + " Grad");
				
	}
	 

}
