package de.lbbw;

public class Ofen {
	
	private int istTemperatur;
	private int sollTemperatur;
	private Brennkammer brennkammer;
	

	
	
	public Ofen(int istTemperatur) {
		super();
		this.istTemperatur = istTemperatur;
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
	}
	

}
