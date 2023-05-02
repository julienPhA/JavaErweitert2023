/*package de.lbbw.hkw.ofen;

import de.lbbw.hkw.controller.TemperaturException;
import de.lbbw.hkw.global.Brennbar;

public class Brennkammer{
	
	private Ofen ofen;

	public Brennkammerxy(Ofen ofen) {
		super();
		this.ofen = ofen;
	}
	
	public void verbrennen(Brennbar b)   {
		System.out.println("verbrennen");
		
		int istWert;
		int aktuellerBrennwert;
		int kuehlTemp;
		int sollTemp;
		int wert;
		
		istWert = ofen.getIstTemperatur();
		aktuellerBrennwert = b.brennen();
		kuehlTemp = ofen.getKuehlTemperatur();
		sollTemp = ofen.getSollTemperatur();
		
		System.out.println("istWErt: " + istWert + "aktuellerBrennwert: "+ aktuellerBrennwert + "kuehlTemp: " + kuehlTemp + "sollTemp: " + sollTemp  );
		
		
		wert = ofen.getIstTemperatur();
		wert = wert + b.brennen();
		
		try {
			ofen.setIstTemperatur(wert);
		}catch (TemperaturException e) {
			System.out.println("zu heiß");
			System.out.println("kuehlen beginnt "+ ofen.getIstTemperatur());
			ofen.kuehlen();
			System.out.println("kuehlen fertig "+ ofen.getIstTemperatur());
		}
			
			
	}

	@Override
	public int brennen() {
		return 0;
	}
	

		
	

}*/
