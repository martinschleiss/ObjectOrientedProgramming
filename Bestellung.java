import java.util.ArrayList;


public class Bestellung {
	
	public enum Teig { MUERB, SCHOKOLADE, ZIMT }
	public enum Form { RUND, MOND, WEIHNACHTSMANN }
	public enum Fuellung { MARMELADE, SCHOKOLADE }
	private ArrayList<Position> positionen;

	public Bestellung() {
		
		positionen = new ArrayList<Position>();
	}

	public void addPositionKeks(int anzahl, Teig teig, Form form) {
		
		positionen.add(new Position(anzahl, teig, form));
	}
	
	public void addPositionDoppelkeks(int anzahl, Teig teig, Form form, Fuellung fuellung) {
		
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
		private Teig teig;
		private Form form;
		
		public Position(int anzahl, Teig teig, Form form) {
			
			this.anzahl = anzahl;
			this.teig = teig;
			this.form = form;
		}
		
		public String toString() {
			
			return "Anzahl: "+ anzahl + "\t" + teig + "-" + keks() + " in \"" + form + "\"-Form";
		}
		
		protected String keks() {
			
			return "Keks(e)";
		}
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 */
	
	private class PositionDoppelkeks extends Position {
	
		private Fuellung fuellung;
		
		public PositionDoppelkeks(int anzahl, Teig teig, Form form, Fuellung fuellung) {
			
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