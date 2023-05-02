package de.lbbw;

public class Ofen {
	
	private int istTemperatur;
	private int sollTemperatur;
	private Brennkammer brennkammer;
	

	
	
	public Ofen(int istTemperatur, int sollTemperatur) {
		super();
		this.istTemperatur = istTemperatur;
		this.sollTemperatur = sollTemperatur;
		brennkammer = new Brennkammer(this);
	}



	public Brennkammer getBrennkammer() {
		return brennkammer;
	}



	public int getIstTemperatur() {
		return istTemperatur;
	}


	public void setIstTemperatur(int istTemperatur) {
		this.istTemperatur = istTemperatur;
	}



	public void beladen(Object obj) {
		
		brennkammer.verbrennen((Holz)obj);

		try {
		if (istTemperatur > sollTemperatur) {
			throw new TemperaturException(istTemperatur);
		}
		} catch (TemperaturException e) {
			System.out.println("Fehler: istTemperatur zu hoch");
			kuehlen();
			System.out.println("nach Kuehlung: " + istTemperatur);
		}
			
	}
	
	public void kuehlen() {
		istTemperatur = istTemperatur - 40;
	}
	

}
