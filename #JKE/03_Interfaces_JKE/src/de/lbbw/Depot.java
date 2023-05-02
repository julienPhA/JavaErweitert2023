package de.lbbw;

import java.math.BigDecimal;

public class Depot implements Anlage {
	private int nr;
	private BigDecimal wert;
	@Override
	public int getNr() {
		// TODO Auto-generated method stub
		return nr;
	}
	@Override
	public BigDecimal getWert() {
		// TODO berechne tatsächlichen Depotwert
		return wert;
	} 

}
