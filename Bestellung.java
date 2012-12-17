import java.util.ArrayList;


public class Bestellung {
	
	public enum teig { muerb, schokolade, zimt }
	public enum form { rund, mond, weihnachtsmann }
	public enum fuellung { marmelade, schokolade }
	private ArrayList<Position> positionen;

	public Bestellung() {
		
		positionen = new ArrayList<Position>();
	}

	public void addPositionEinfachkeks(int anzahl, teig teig, form form) {
		
		positionen.add(new Position(anzahl, teig, form));
	}
	
	public void addPositionDoppelkeks(int anzahl, teig teig, form form, fuellung fuellung) {
		
		positionen.add(new PositionDoppelkeks(anzahl, teig, form, fuellung));
	}
	
	public void drucke() {
		
		for (Position p : positionen) {
			
			System.out.println(p);
		}
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 */
	
	private class Position {
		
		private int anzahl;
		private teig teig;
		private form form;
		
		public Position(int anzahl, teig teig, form form) {
			
			this.anzahl = anzahl;
			this.teig = teig;
			this.form = form;
		}
		
		public String toString() {
			
			return "Anzahl: " + anzahl + ", " + teig + "-" + keks() + "in \"" + form + "\"-Form";
		}
		
		protected String keks() {
			
			return "Keks(e)";
		}
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 */
	
	private class PositionDoppelkeks extends Position {
	
		private fuellung fuellung;
		
		public PositionDoppelkeks(int anzahl, teig teig, form form, fuellung fuellung) {
			
			super(anzahl, teig, form);
			this.fuellung = fuellung;
		}
		
		public String toString() {
			
			return super.toString() + " mit \"" + fuellung + "\"-Fuellung";
		}
		
		protected String keks() {
			
			return "Doppelkeks(e)";
		}
	}
}