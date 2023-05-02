package de.lbbw;

public class Ofen {

	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;	
	private Brennkammer brennkammer;
	
	void beladen(Object material) {
		
		System.out.println("Jetzt wird beladen mit: " + material.getClass());
		
		try {
			brennkammer.verbrennen((Holz) material);
		} catch (ClassCastException e)  {
			System.out.println("!!! Nicht brennbare Objekte koennen nicht beladen werden !!!");
			System.out.println();e.getMessage();
		} catch (TemperaturException e) {
			e.toString();
			this.kuehlen();
		}
		
	}

	public void setIstTemperatur(int istTemperatur) throws TemperaturException {
		
		this.istTemperatur = istTemperatur;
		
		if (istTemperatur >= this.kuehlTemperatur) {
			throw new TemperaturException(istTemperatur, "!!! Achtung, Achtung:Temperatur ist zu heiss !!!");
		} 

				
	}

	public Ofen(int sollTemperatur, int kuehlTemperatur) {
		super();
		this.istTemperatur = 0;
		this.sollTemperatur = sollTemperatur;
		this.kuehlTemperatur = kuehlTemperatur;
		
		this.brennkammer = new Brennkammer(this);
	}

	public int getIstTemperatur() {
		return istTemperatur;
	}

	public int getSollTemperatur() {
		return sollTemperatur;
	}

	public int getKuehlTemperatur() {
		return kuehlTemperatur;
	}
	
	public Brennkammer getBrennkammer() {
		return brennkammer;
	}
	
	public void kuehlen() {
		
		int kuehlung = 30;
		
		System.out.println("--- Kuehlung beginnt! ---" + this.istTemperatur);
		this.istTemperatur -= kuehlung;
		System.out.println("--- Kuehlung beendet! ---" + this.istTemperatur);
	}

	@Override
	public String toString() {
		return "Ofen [istTemperatur=" + istTemperatur + ", sollTemperatur=" + sollTemperatur + ", kuehlTemperatur="
				+ kuehlTemperatur + "]";
	}
		
}
