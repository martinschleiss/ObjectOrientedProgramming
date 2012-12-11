
public interface ObjectIterator {

	/**
	 * Zur Abfrage, ob Listenende erreicht
	 * @return false, wenn Ende der Liste erreicht, sonst true
	 */
	public boolean hasNext();
	
	/**
	 * Liefert naechsten Traktor der Liste
	 * @return naechsten Traktor der Liste, null wenn Listenende erreicht (hasNext() == false)
	 */
	public Object next();
}
