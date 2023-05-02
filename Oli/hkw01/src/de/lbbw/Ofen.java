package de.lbbw;

public class Ofen {
	private int istTemperatur = 0;
	private int sollTemperatur = 0;
	private Brennkammer brennkammer;
	private int kuehlTemperatur = 8;
	
	public Ofen(int sollTemperatur) {
		super();
		this.sollTemperatur = sollTemperatur;
		brennkammer = new Brennkammer(this);
	}

	public void beladen(Object o) {
		try {
			brennkammer.verbrennen((Holz) o);
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
