package de.lbbw;

public class StartVerbrennen {


	public static void main(String[] args) {
		Ofen o = new Ofen(200);
		Holz h = new Holz();
		Papier p = new Papier();
		
		o.beladen(new Dose());
		
		while (o.getIstTemp() < o.getSollTemp()) {			
			try {
				o.beladen(h);
				Thread.sleep(400);
				
				o.beladen(p);
				Thread.sleep(700);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}