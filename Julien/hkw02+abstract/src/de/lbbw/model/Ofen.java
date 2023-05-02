package de.lbbw.model;

public class Ofen {
	private int istTemp = 0;
	private int sollTemp;
	private Brennkammer bk;
	
	private class Brennkammer{
		public void verbrennen(Brennbar b) throws TemperaturException {
			Ofen.this.setIstTemp(
					Ofen.this.getIstTemp()
					+ b.getBrennwert()
					);
			System.out.println(
					Ofen.this.istTemp
					+ " ... " + b.getClass().getSimpleName());
			
			if (Ofen.this.getIstTemp() > Ofen.this.getSollTemp())
				throw new TemperaturException(Ofen.this.getIstTemp());
		}
	}
	
	
	
	public Ofen(int sollTemp) {
		this.sollTemp = sollTemp;
		bk = new Brennkammer();
	}


	public void beladen(Object o) {
		try {
			bk.verbrennen((Brennbar) o);
		}
		catch (ClassCastException e) {
			System.out.println(o.getClass().getSimpleName() + " kann nicht verbrannt werden!");
		}
		catch (TemperaturException e) {
			System.out.println(e.getMessage());

			while (istTemp > sollTemp)
				kuehlen();
		}
	}

	public int getSollTemp() {
		return sollTemp;
	}
	public void setSollTemp(int sollTemp) {
		this.sollTemp = sollTemp;
	}

	public int getIstTemp() {
		return istTemp;
	}
	public void setIstTemp(int istTemp) {
		this.istTemp = istTemp;
	}
	
	private void kuehlen() {
		istTemp -= 5;
		System.out.println(istTemp);
		
		try {
			Thread.sleep(300);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}