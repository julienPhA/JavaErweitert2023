package de.lbbw;

import java.math.BigDecimal;

public class Sparkonto extends Konto {

	private int verfRahmen;
	
	public int getVerfRahmen() {
		return verfRahmen;
	}

	public Sparkonto(int nr, BigDecimal saldo, int verfRahmen) {
		super(nr, saldo);
		this.verfRahmen = verfRahmen;
	}

	@Override
	public String toString() {
		// super.toString() ruft die toString() der Basisklasse
		return super.toString()+" verfRahmen=" + verfRahmen + "]";
	}
	
}
