package de.lbbw;

public class Brennkammer {
	
	private Ofen ofen;
	
	public Brennkammer(Ofen ofen) {
		super();
		this.ofen = ofen;
	}

	public void verbrennen(Holz holz) {
		
		System.out.println("Temp vor Verbrennen: " + ofen.getIstTemperatur());
		
		int actTemp = this.ofen.getIstTemperatur();
		actTemp += holz.brennen();
		this.ofen.setIstTemperatur(actTemp);
		
		System.out.println("Temp nach Verbrennen: " + ofen.getIstTemperatur());
				
	}

}
