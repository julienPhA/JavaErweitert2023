package de.lbbw;

import java.math.BigDecimal;

public class StartApplication {

	
	public static void demoUncheckedExceptions() {
		int numbers[] = new int[3];
		// unchecked exception #1 : java.lang.ArrayIndexOutOfBoundsException
		// System.out.println(numbers[3]);
		Konto k1 = new Konto();
		Girokonto gk = new Girokonto();
		// geht immer : der sog. "upcast"
		Konto k2 = (Konto)gk;
		// geht nicht immer: der sog. "downcast"
		// unchecked exception #2 : java.lang.ClassCastException
		// gk = (Girokonto)k1;
		gk = null;
		// unchecked exception #3 : java.lang.NullPointerException
		// gk.auszahlen(new BigDecimal(1000));	
	}
	
	public static void demoCheckedExceptions() {
		Girokonto gk1 = new Girokonto();
		Girokonto gk2 = new Girokonto();
		Girokonto gk3 = new Girokonto();
		
		try {
			gk1.auszahlen(new BigDecimal(1001));
		}catch (OverdraftException e) {
			System.out.println("Overdraft Exception: "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Allgemeiner Fehler: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter main");
		// demoUncheckedExceptions();
		demoCheckedExceptions();
		System.out.println("Exit main");

	}

}
