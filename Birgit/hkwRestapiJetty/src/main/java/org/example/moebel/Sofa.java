package org.example.moebel;

import org.example.global.Brennbar;

public class Sofa extends Moebel implements Brennbar{
	public Sofa(String typ) {
		super(typ);
	}
	@Override
	public int brennen() {
		return 50;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("ein Objekt vom Typ "+this.getClass().getName()+" ist verbrannt");
	}
	@Override
	public String getMaterial() {
		// TODO Auto-generated method stub
		return "Sofa";
	}
}
