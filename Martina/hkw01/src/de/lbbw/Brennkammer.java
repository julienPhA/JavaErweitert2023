package de.lbbw;

public class Brennkammer {
	
	private Ofen ofen;

	public Brennkammer(Ofen ofen) {
		super();
		this.ofen = ofen;
	}
	
	public void verbrennen(Holz holz)   {
		System.out.println("verbrennen");
		
		int istWert;
		int aktuellerBrennwert;
		int kuehlTemp;
		int sollTemp;
		int wert;
		
		istWert = ofen.getIstTemperatur();
		aktuellerBrennwert = holz.brennen();
		kuehlTemp = ofen.getKuehlTemperatur();
		sollTemp = ofen.getSollTemperatur();
		
		System.out.println("istWErt: " + istWert + "aktuellerBrennwert: "+ aktuellerBrennwert + "kuehlTemp: " + kuehlTemp + "sollTemp: " + sollTemp  );
		
		
		wert = ofen.getIstTemperatur();
		wert = wert + holz.brennen();
		
		try {
			ofen.setIstTemperatur(wert);
		}catch (TemperaturException e) {
			System.out.println("zu heiß");
			System.out.println("kuehlen beginnt "+ ofen.getIstTemperatur());
			ofen.kuehlen();
			System.out.println("kuehlen fertig "+ ofen.getIstTemperatur());
		}
			
			
	}
	

		
	

}
