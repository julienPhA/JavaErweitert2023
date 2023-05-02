package de.lbbw;

import java.math.BigDecimal;

public interface Anlage {

	public static final int MYCONST = 50000;
	// oder
	int MYCONST2 = 50000;
	
	public int getNr();
	public BigDecimal getWert();
	
}
