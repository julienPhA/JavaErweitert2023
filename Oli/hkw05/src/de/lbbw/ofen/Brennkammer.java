//package de.lbbw.ofen;
//
//import de.lbbw.TemperaturException;
//import de.lbbw.brennelemente.Holz;
//import de.lbbw.global.Brennbar;
//
//public class Brennkammer {
//	private Ofen ofen;
//	
//	public Brennkammer(Ofen ofen) {
//		super();
//		this.ofen = ofen;
//	}
//
//	public void verbrennen(Brennbar material) {
//		int wert;
//		wert = ofen.getIstTemperatur();
//		wert += material.brennen();
//		
//		//System.out.println("Verbrenne " + material.getTyp() + " mit Brennwert " + material.brennen());
//		
//		try {
//			ofen.setIstTemperatur(wert);
//		
//		} catch (TemperaturException e) {
//			System.out.println(e.getMessage());
//			ofen.kuehlen();
//			
//		}
//	}
//}
