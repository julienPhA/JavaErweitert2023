package de.lbbw;


public class Ofen {
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	
	private Brennkammer brennkammer; 
	

	public Ofen() {
		super();
		istTemperatur = 20;
		sollTemperatur = 150;
		kuehlTemperatur = 30;
		
		brennkammer = new Brennkammer(this);
	
	}
	

	public void beladen(Object o)  {
		
	System.out.println("beladen");
	
	try{
		brennkammer.verbrennen((Holz)o);
	}catch (ClassCastException e) {
		System.out.println("nicht brennbare Objekte duerfen nicht beladen werden " + e.getMessage());
	}
	}
		
	
	public void setIstTemperatur(int istTemperatur) throws TemperaturException {
		this.istTemperatur = istTemperatur;
		
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
