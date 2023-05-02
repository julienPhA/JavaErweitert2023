package de.lbbw;

import java.math.BigDecimal;

public class Girokonto extends Konto {

	private int dispo;
	
	public Girokonto(int nr, BigDecimal saldo, int dispo) {
		super(nr, saldo);
		this.dispo = dispo;
	}

	public int getDispo() {
		return dispo;
	}

	@Override
	public String toString() {
		return super.toString() + " Girokonto [dispo=" + dispo + "]";
	}
	
}
