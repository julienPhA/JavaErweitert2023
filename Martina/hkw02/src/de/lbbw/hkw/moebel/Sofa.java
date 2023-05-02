package de.lbbw.hkw.moebel;

import de.lbbw.hkw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar{
	public String getTyp() {
		return typ;
	}

	public int getBrennwert() {
		return brennwert;
	}

	private String typ;
	private int brennwert;
	
	public Sofa(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize called for " + toString() + "on thread " +Thread.currentThread().getName());
	}

	@Override
	public String toString() {
		return "Sofa [typ=" + typ + ", brennwert=" + brennwert + "]";
	}

	@Override
	public int brennen() {
		// TODO Auto-generated method stub
		return brennwert;
	}

	public Sofa() {
		typ="weich";
		brennwert=80;
				
	}

	
	
		

}
