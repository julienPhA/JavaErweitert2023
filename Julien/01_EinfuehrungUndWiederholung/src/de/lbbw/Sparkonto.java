package de.lbbw;

import java.math.BigDecimal;

public class Sparkonto extends Konto{
	private int verfRahmen; 


	public Sparkonto(int nr, BigDecimal saldo, int verfRahmen) {
		super(nr, saldo);
		this.verfRahmen = verfRahmen;
	}

	
	public int getVerfRahmen() {
		return verfRahmen;
	}


	@Override
	public String toString() {
		return "Sparkonto "
				+ super.toString()
				+ "[verfRahmen = " + verfRahmen + "EUR]";
	}
}