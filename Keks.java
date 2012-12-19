
/**
 * Interface repraesentiert Kekse und Doppelkekse in verschiedenen Formen und Teigarten
 */
public interface Keks {

	/**
	 * Klont Keks, auch Referenzen werden geklont
	 * @return aequvivalentes Keks zu this
	 */
	public Keks clone();
	
	/**
	 * liefert String-Repraesentation des Keks
	 */
	public String toString();
}
