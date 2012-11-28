import java.util.Iterator;
import java.util.TreeMap;

/**
 * Speichert Androiden, die der Verordnung entsprechen. Androiden koennen z.B. gesucht, ausgegeben und eingefuegt werden.
 * Wird ein bereits enthaltener Androide veraendert und erneut eingefuegt, muss er ebenfalls der Verordnung entsprechen.
 */
public class Shop {
	
	private TreeMap<Integer, Androide> liste = new TreeMap<Integer, Androide>();
	
	/**
	 * Vorbedingung: a (Androide) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			a entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String insert(Androide a) {

		return a.insertWennGueltig(liste);
	}
	
	/**
	 * Liefert den gesuchten Androiden anhand seiner Seriennummer
	 * @param key	>= 0
	 * @return		Androide mit der Seriennummer key
	 */
	public String find(int key) {
		
		if (liste.get(key) != null) {
			
			return liste.get(key).toString();
		
		} else {
			
			return null;
		}
	}
	
	/**
	 * Liefert Iterator, der die Androiden des Shops geordnet nach Auslieferdatum (= aufsteigend sortiert nach Seriennummer) ausgibt
	 */
	public Iterator<Androide> iterator() {
		
		return new ShopIterator<Androide>(liste);
	}
	
	/**
	 * Iterator liefert Elemente des Shops geordnet nach Auslieferdatum (= aufsteigend sortiert nach Seriennummer)
	 */
	private class ShopIterator<T> implements Iterator<T> {

		private TreeMap<Integer,T> list;
		private T value;
		private Integer currentKey;
		
		public ShopIterator(TreeMap<Integer,T> list) {
			
			this.list = list;
			currentKey = list.firstKey();
			value = list.get(currentKey);
			
		}
		
		/**
		 * Liefert true, wenn noch mindestens ein Element nachfolgt, ansonsten false
		 */
		public boolean hasNext() {

			return currentKey != null;
		}

		/**
		 * Vorbedingung: hasNext == true
		 * Nachbedingung: liefert naechstes Element in Reihenfolge des Auslieferdatums != null
		 */
		public T next() {
	
			if (currentKey != null) {
				
				value = list.get(currentKey);
				currentKey = list.higherKey(currentKey);
			
				return value; 
			}
			
			return null;
		}

		/**
		 * Vorbedingung: next() wurde aufgerufen (kann nur einmal pro next()-Aufruf ausgefuehrt werden
		 * Nachbedingung: entfernt aktuelles Element aus der Liste
		 */
		public void remove() {
			
			list.remove(currentKey);
		}
	}
}
