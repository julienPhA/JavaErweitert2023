package org.example;

public class JMain_01 {

	public static void main(String[] args) {
		Ofen ofen = new Ofen();
		ofen.beladen(new Holz("Birke"));
		ofen.beladen(new Holz("Kirsche"));
		ofen.beladen(new Holz("Eiche"));
	}

}
