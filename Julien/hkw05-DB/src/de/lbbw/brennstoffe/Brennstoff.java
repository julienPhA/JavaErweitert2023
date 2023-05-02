package de.lbbw.brennstoffe;

import de.lbbw.model.Brennbar;

public abstract class Brennstoff implements Brennbar {
	protected int brennwert;

	static {
		System.out.println("Brennstoff verfuegbar.");
	}
	
	public Brennstoff(int brennwert) {
		this.brennwert = brennwert;
	}
	
	public int getBrennwert() {
		return brennwert;
	}

	@Override
	public void finalize() throws Throwable {
		System.out.println(this.getClass().getSimpleName() + " vollstaendig verbrannt!");
	}
}