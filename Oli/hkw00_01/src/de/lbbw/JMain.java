package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		
		System.out.println("Fahre Heizkraftwerk hoch!");
		
		Ofen myOfen = new Ofen(21);
		Holz myHolz = new Holz();
		
		myOfen.beladen(myHolz);
		System.out.println("aktuelle Temp: " + myOfen);
		
		System.out.println("Fahre Heizkraftwerk runter!");
	}

}
