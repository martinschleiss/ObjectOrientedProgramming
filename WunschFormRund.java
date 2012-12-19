
/**
 * Repraesentiert den Kundenwunsch Rund-Form
 */
public class WunschFormRund implements WunschForm {

	/**
	 * liefert Backmaschine, die Kekse in Rundform backen kann
	 * @return Untertyp von Backmaschine, der Kekse in Rundform backen kann
	 */
	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineRund();
	}
	
	/**
	 * liefert String-Repraesentation des Wunschs
	 */
	public String toString() {
		
		return "Rund";
	}
}
