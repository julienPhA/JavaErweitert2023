package de.lbbw;

public class Brennkammer {
	
	private Ofen ofen;

	public Brennkammer(Ofen ofen) {
		super();
		this.ofen = ofen;
	}
	
	public void verbrennen(Holz holz)  {
		System.out.println("verbrennen");
		
		int istWert;
		int aktuellerBrennwert;
		
		istWert = ofen.getIstTemperatur();
		aktuellerBrennwert = holz.brennen();
		
		ofen.setIstTemperatur(istWert + aktuellerBrennwert);
	
			
	}
	public void kuehlen() {
		
		
	}

		
	

}
