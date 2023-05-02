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
		return super.toString() + " Sparkonto [verfRahmen=" + verfRahmen + "]";
	}
	
}
