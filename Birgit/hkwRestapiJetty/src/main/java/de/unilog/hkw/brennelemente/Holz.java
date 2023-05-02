package de.unilog.hkw.brennelemente;

import org.example.global.Brennbar;

public class Holz implements Brennbar{
	
	static {
		System.out.println("Holz erzeugt");
	}
	
	protected int brennwert;
	private String typ;
	
	public Holz(String typ) {
		this.typ = typ;
		brennwert = 30;
	}
	
	public int brennen() {
		return brennwert;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Ein Objekt vom Typ "+this.getClass().getName()+" ist verbrannt");
	}

	@Override
	public String getMaterial() {
		// TODO Auto-generated method stub
		return "Holz";
	}

	
}
