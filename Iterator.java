/**
 * Interface fuer das Iterieren durch Listen
 */
public interface Iterator {

	/**
	 * Zur Abfrage, ob Listenende erreicht
	 * @return false, wenn Ende der Liste erreicht, sonst true
	 */
	public boolean hasNext();
	
	/**
	 * Liefert naechstes Objekt der Liste
	 * @return naechstes Objekt der Liste, null wenn Listenende erreicht (hasNext() == false)
	 */
	public Object next();
}
