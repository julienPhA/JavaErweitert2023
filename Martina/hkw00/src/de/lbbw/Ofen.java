package de.lbbw;

public class Ofen {
	private int istTemperatur;
	private int sollTemperatur;
	
	private Brennkammer brennkammer; 
	

	public Ofen(int istTemperatur, int sollTemperatur) {
		super();
		this.istTemperatur = istTemperatur;
		this.sollTemperatur = sollTemperatur;
		
		this.brennkammer = new Brennkammer(this);
		
		
			
	}

	public void beladen(Object o) {
	System.out.println("beladen");
		brennkammer.verbrennen((Holz)o);
		
	}

	public void setIstTemperatur(int istTemperatur) {
		this.istTemperatur = istTemperatur;
	}

	public int getIstTemperatur() {
		return istTemperatur;
	}


	public int getSollTemperatur() {
		return sollTemperatur;
	}


	public Brennkammer getBrennkammer() {
		return brennkammer;
	}

	@Override
	public String toString() {
		return "Ofen [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur;
	}
	
	

}
