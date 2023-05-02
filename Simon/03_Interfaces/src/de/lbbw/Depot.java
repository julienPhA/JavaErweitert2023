package de.lbbw;

import java.math.BigDecimal;

public class Depot implements Anlage {

	private int nr;
	private BigDecimal wert;
	
	@Override
	public int getNr() {
		return nr;
	}
	@Override
	public BigDecimal getWert() {
		return wert;
	}
		
}
