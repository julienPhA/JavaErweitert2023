package de.lbbw;

public class Papier extends Holz {
	
	
	static {
		System.out.println("Static block of class Papier called");
	}

	public Papier(String typ, int brennwert) {
		super(typ, brennwert);
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize called for " + toString() + "on thread " +Thread.currentThread().getName());
	}


}
