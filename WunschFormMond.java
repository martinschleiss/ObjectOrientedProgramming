
/**
 * Repraesentiert den Kundenwunsch Mond-Form
 */
public class WunschFormMond implements WunschForm {

	/**
	 * liefert Backmaschine, die Kekse in Mondform backen kann
	 * @return Untertyp von Backmaschine, der Kekse in Mondform backen kann
	 */
	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineMond();
	}
	
	/**
	 * liefert String-Repraesentation des Wunschs
	 */
	public String toString() {
		
		return "Mond";
	}
}
