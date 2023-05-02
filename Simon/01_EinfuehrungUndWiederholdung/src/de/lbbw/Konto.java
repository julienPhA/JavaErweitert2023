package de.lbbw;

import java.math.BigDecimal;

public abstract class Konto {

	private int nr;
	private BigDecimal saldo;
	
	public Konto(int nr, BigDecimal saldo) {
		super();
		this.nr = nr;
		this.saldo = saldo;
	}

	public int getNr() {
		return nr;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	void einzahlen(BigDecimal betrag) {
		saldo = saldo.add(betrag);
	}
	
	void auszahlen(BigDecimal betrag) {
		saldo = saldo.subtract(betrag);
	}

	@Override
	public String toString() {
		return "Konto [nr=" + nr + ", saldo=" + saldo + "]";
	}
	
}