package de.lbbw;

import java.math.BigDecimal;

public class Girokonto extends Konto {
	private int dispo = 1000;
	private BigDecimal saldo = new BigDecimal(0);
	
	// der statische Block wird genau einmal 
	// von der VM aufgerufen
	static {
		System.out.println("Static block of class Girokonto called");
	}
	
	public Girokonto() {
		System.out.println("Constructor of class Girokonto called");
	}
	
	public  BigDecimal auszahlen(BigDecimal betrag) throws Exception {
		if  (saldo.subtract(betrag).intValue()  < -dispo ) {
			throw new OverdraftException("Betrag "+betrag+ " kann nicht ausbezahlt werden ");
		} else {
			saldo = saldo.subtract(betrag);
		}
		return saldo;
	}
}
