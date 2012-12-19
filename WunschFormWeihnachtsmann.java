
/**
 * Repraesentiert den Kundenwunsch Weihnachtsmann-Form
 */
public class WunschFormWeihnachtsmann implements WunschForm {
	
	/**
	 * liefert Backmaschine, die Kekse in Weichnachtsmannform backen kann
	 * @return Untertyp von Backmaschine, der Kekse in Weichnachtsmannform backen kann
	 */
	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineWeihnachtsmann();
	}
	
	/**
	 * liefert String-Repraesentation des Wunschs
	 */
	public String toString() {
		
		return "Weihnachtsmann";
	}
}
