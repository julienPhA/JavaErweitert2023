package de.lbbw;

public class JMain {
	
	public static void main(String[] args) {
				
		Holz holz1 = new Holz(10);
		Holz holz2 = new Holz(20);

		Ofen ofen = new Ofen(24);		

		ofen.beladen(holz1);
		ofen.beladen(holz2);
		
		System.out.println("akt. Temp: " + ofen.getIstTemperatur());

		
		
	}

}
