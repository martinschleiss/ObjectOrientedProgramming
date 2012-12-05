/**
 * Autodrom-Auto: Kann nach nicht nach rechts und links lenken und ist schneller als das bewegliche Auto
 */
public class AutoSchnell extends Auto {

	private int wartezeit; // > 0
	
	public AutoSchnell(Fahrbahn f, Feld startfeld, ausrichtung a, Strategie s, int wartezeit) {

		super(f, startfeld, a, s);
		this.wartezeit = wartezeit;
	}

	/**
	 * Liefert fixe Dauer, die der Thread wartet.
	 * @return wartezeit > 0
	 */
	public final int wartezeit() {

		return wartezeit;
	}

	/**
	 * Auto kann nicht nach links lenken
	 * @return null
	 */
	public Feld lenkeLinks() {
		
		return null;
	}

	/**
	 * Auto kann nicht nach rechts lenken
	 * @return null
	 */
	public Feld lenkeRechts() {
		
		return null;
	}
}