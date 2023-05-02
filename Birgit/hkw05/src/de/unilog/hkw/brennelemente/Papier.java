package de.unilog.hkw.brennelemente;

public class Papier extends Holz {

	static {
		System.out.println("Papier erzeugt");
	}
	
	public Papier(String typ) {
		super(typ);
		brennwert = 20;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Ein Objekt vom Typ "+this.getClass().getName()+" ist verbrannt");
	}
	
	@Override
	public String getMaterial() {
		// TODO Auto-generated method stub
		return "Papier";
	}

}
