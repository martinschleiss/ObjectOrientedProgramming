
/**
 * Repraesentiert vom Kunden gewuenschte Form der Kekse
 */
public interface WunschForm {
	
	/**
	 * liefert zur Wunschform passende Backmaschine
	 * @return Untertyp von Backmaschine, der gewuenschte Form backen kann
	 */
	public abstract Backmaschine getBackmaschine();
}
