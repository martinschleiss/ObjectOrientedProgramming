import java.util.ArrayList;
import java.util.Iterator;


public class Bestellung {

	private ArrayList<Position> positionen;
	private Iterator<Position> it;
	private Position current;

	public Bestellung() {
		
		positionen = new ArrayList<Position>();
		it = null;
		current = null;
	}

	public void addPositionKeks(int anzahl, WunschTeig teig, WunschForm form) {
		
		positionen.add(new Position(anzahl, teig, form));
	}
	
	public void addPositionDoppelkeks(int anzahl, WunschTeig teig, WunschForm form, WunschFuellung fuellung) {
		
		positionen.add(new PositionDoppelkeks(anzahl, teig, form, fuellung));
	}
	
	public void drucke() {
		
		for (Position p : positionen) {
			
			System.out.println(p);
		}
	}
	
	public boolean next() {
		
		if (it == null) {
			
			it = positionen.iterator();
		}
		
		if (it.hasNext()) {
			
			current = it.next();
			return true;
			
		} else {
			
			return false;
		}
	}
	
	public Backmaschine getCurrentBackmaschine() {
		
		if (current != null) {
			
			return current.getBackmaschine();
			
		} else {
			
			return null;
		}
	}
	
	public Teig getCurrentTeig() {
		
		if (current != null) {
			
			return current.getTeig();
			
		} else {
			
			return null;
		}
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 */
	
	private class Position {
		
		private int anzahl;
		private WunschTeig teig;
		private WunschForm form;
		
		public Position(int anzahl, WunschTeig teig, WunschForm form) {
			
			this.anzahl = anzahl;
			this.teig = teig;
			this.form = form;
		}
		
		public Backmaschine getBackmaschine() {
			
			return form.getBackmaschine();
		}
		
		public Teig getTeig() {
			
			return teig.getTeig();
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
	
		private WunschFuellung fuellung;
		
		public PositionDoppelkeks(int anzahl, WunschTeig teig, WunschForm form, WunschFuellung fuellung) {
			
			super(anzahl, teig, form);
			this.fuellung = fuellung;
		}
		
		/*public Backmaschine getBackmaschine() {
			
		return new BackmaschineDoppelt();
		}*/
		
		public String toString() {
			
			return super.toString() + " mit \"" + fuellung + "\"-Fuellung";
		}
		
		protected String keks() {
			
			return "Doppelkeks(e)";
		}
	}
}