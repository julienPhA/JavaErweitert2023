package de.lbbw.hkw.ofen;

import de.lbbw.hkw.controller.TemperaturException;
import de.lbbw.hkw.global.Brennbar;

public class Ofen{
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	
	private Brennkammer brennkammer; 
	

	public Ofen() {
		super();
		istTemperatur = 20;
		sollTemperatur = 150;
		kuehlTemperatur = 80;
		
		brennkammer = new Brennkammer(this);
	
	}
	
	private class Brennkammer{
		
		private Ofen ofen;

		public Brennkammer (Ofen ofen) {
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
			
			System.out.println("istWErt: " + istWert + " aktuellerBrennwert: "+ aktuellerBrennwert + " kuehlTemp: " + kuehlTemp + " sollTemp: " + sollTemp  );
			
			
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
	
	}	
	public void beladen(Object o)  {
		
	System.out.println("beladen");
	
	try{
		brennkammer.verbrennen((Brennbar)o);
	}catch (ClassCastException e) {
		System.out.println("nicht brennbare Objekte duerfen nicht beladen werden ");
	}
	}
		
	
	public void setIstTemperatur(int istTemperatur) throws TemperaturException {
		this.istTemperatur = istTemperatur;
		System.out.println(istTemperatur);
		System.out.println(sollTemperatur);
		
		
		if(istTemperatur >= sollTemperatur) {
			throw new TemperaturException(istTemperatur);
			
		}
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
	
	public int getKuehlTemperatur() {
		return kuehlTemperatur;
	}

	@Override
	public String toString() {
		return "Ofen [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur + "]";
	}
	
    public void kuehlen() {
        	
	     this.istTemperatur -=  kuehlTemperatur;	
    			
	}
    
    

}
