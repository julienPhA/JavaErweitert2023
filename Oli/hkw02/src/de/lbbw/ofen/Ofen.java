package de.lbbw.ofen;

import de.lbbw.TemperaturException;
import de.lbbw.brennelemente.Holz;
import de.lbbw.global.Brennbar;

public class Ofen {
	private int istTemperatur = 0;
	private int sollTemperatur = 0;
	private Brennkammer brennkammer;
	private int kuehlTemperatur = 8;

	public class Brennkammer {
		private Ofen ofen;
		
		public Brennkammer(Ofen ofen) {
			super();
			this.ofen = ofen;
		}

		public void verbrennen(Brennbar material) {
			int wert;
			wert = ofen.getIstTemperatur();
			wert += material.brennen();
			
			//System.out.println("Verbrenne " + material.getTyp() + " mit Brennwert " + material.brennen());
			
			try {
				ofen.setIstTemperatur(wert);
			
			} catch (TemperaturException e) {
				System.out.println(e.getMessage());
				ofen.kuehlen();
				
			}
		}
	}
	
	public Ofen(int sollTemperatur) {
		super();
		this.sollTemperatur = sollTemperatur;
		brennkammer = new Brennkammer(this);
	}

	public void beladen(Object o) {
		try {
			brennkammer.verbrennen((Brennbar) o);
		} catch (ClassCastException e) {
			System.out.println("Diese Objekt ist nicht brennbar! " + e.getMessage());
		}
		
	}

	public int getIstTemperatur() {
		return istTemperatur;
	}

	public void setIstTemperatur(int istTemperatur) throws TemperaturException {
		this.istTemperatur = istTemperatur;
		
		if (istTemperatur > sollTemperatur) {
			throw new TemperaturException("Mir wird zu heiss!! Wert: " + istTemperatur);
		}		
	}

	public int getSollTemperatur() {
		return sollTemperatur;
	}

	public void setSollTemperatur(int sollTemperatur) {
		this.sollTemperatur = sollTemperatur;
	}

	public void kuehlen() {
		System.out.println("Kuehle das System um " +kuehlTemperatur +" Grad runter!");
		this.istTemperatur -= kuehlTemperatur;
	}
	
	@Override
	public String toString() {
		return "Ofen [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur + "]";
	}
	
	
}
