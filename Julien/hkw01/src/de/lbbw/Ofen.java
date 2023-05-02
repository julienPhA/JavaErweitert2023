package de.lbbw;

public class Ofen {
	private int istTemp = 0;
	private int sollTemp;
	private Brennkammer bk;
	
	private class Brennkammer{
		private Ofen o;
				
		public Brennkammer(Ofen o) {
			this.o = o;
		}

		public void verbrennen(Brennbar b) throws TemperaturException {
			o.setIstTemp(
					o.getIstTemp()
					+ b.getBrennwert()
					);
			
			if (o.getIstTemp() > o.getSollTemp())
				throw new TemperaturException(o.getIstTemp());
		}
	}
	
	
	
	public Ofen(int sollTemp) {
		this.sollTemp = sollTemp;
		bk = new Brennkammer(this);
	}


	public void beladen(Object o) {
		try {
			bk.verbrennen((Brennbar) o);
			System.out.println(istTemp);
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
			Thread.sleep(200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}