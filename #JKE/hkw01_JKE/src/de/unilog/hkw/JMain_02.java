package de.unilog.hkw;

public class JMain_02 {

	public static void main(String[] args) {
		Ofen ofen = new Ofen();
		for(int i=0; i<2;i++) {
			ofen.beladen(new Dose("Blech"));
			ofen.beladen(new Holz("Birke"));
			ofen.beladen(new Holz("Kirsche"));
			ofen.beladen(new Holz("Eiche"));
			ofen.beladen(new Papier("Pappe"));
		}
	}
}
