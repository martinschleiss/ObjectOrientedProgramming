
/**
 * Beschreibt Backmaschinen, die eine Position entgegennehmen (eine Position beschreibt Anzahl, Form und eine optionale Fuellung)
 * und liefert eine Keksdose, die die Kekse enthaelt, die in der Position gewuenscht waren.
 */
public class BackmaschineWeihnachtsmann implements Backmaschine {

	/**
	 * Liefert eine Keksdose entsprechend der Anzahl und Teigwuensche von p, beruecksichtigt nicht die Wunschform von p
	 * @param p != null, p.getForm() == WunschFormMond (Wunschform von p muss Mond sein, da andere Kekse nicht gebacken werden)
	 * @return	Keksdose: gefuellt mit n Keksen in Mondform, wobei n die Anzahl der in p geforderten Kekse ist (n = p.getAnzahl())
	 */
	@Override
	public Keksdose backe(Position p) {

		Keksdose k = new Keksdose();
		
		for(int i = 0; i < p.getAnzahl(); i++) {
			
			k.befuelle(new KeksWeihnachtsmann(p.getTeig()));
		}
		
		return k;
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 * 
	 * Innere Klasse spezifieziert Einfach-Keks in Mondform
	 */
	private class KeksWeihnachtsmann implements Keks {
		
		private Teig teig;
		
		/**
		 * Konstruktor
		 * @param teig != null
		 */
		public KeksWeihnachtsmann(Teig teig) {
			
			this.teig = teig;
		}
		
		/**
		 * Liefert Klon der Klasse, wobei auch Referenzen geklont werden
		 */
		public Keks clone() {
			
			return new KeksWeihnachtsmann(teig);
		}
		
		/**
		 * Liefert String-Repraesentation der Klasse
		 */
		public String toString() {
			
			return "Keks in Weichnachtsmann-Form aus " + teig;
		}
	}
}
