package de.lbbw;


public class TemperaturException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
	private int aktTemperatur;
	
	

	public TemperaturException(int aktTemperatur) {
		super();
		this.aktTemperatur = aktTemperatur;
		
	}


	public TemperaturException(String message) {
		super(message);
		
		System.out.println("aktTemperatur: " + aktTemperatur);
		
	}
	
	

}
