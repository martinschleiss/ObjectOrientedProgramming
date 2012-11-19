import java.util.Iterator;

public class OrderedMapIterator<S extends Shorter, O> implements Iterator<S> {
	public OrderedMapIterator () {
		super();
	}
	
	private S node;
	
	private OrderedMap<S, O> map;
	private Iterator<S> it;
	
	public OrderedMapIterator (OrderedMap<S, O> map) {
		this.map = map;
		it = map.it();
	}
	
	/**
	 * liefert true, wenn noch weitere Listenelemente nachfolgen, ansonsten false
	 */
	public boolean hasNext() {

		return it.hasNext();
	}
	
	/**
	 * liefert das naechste Element, wobei nachfolgende Elemente entsprechend shorter niemals kuerzer sind als vorangegangene
	 */
	public S next() {
		node = it.next();
		return node;

	}

	/**
	 * entfernt zuletzt zurueckgegebenes Element aus der Liste
	 */
	public void remove() throws IllegalStateException {
		it.remove();
	}
	
	public Iterator<S> it() {
		return this;
	}
	
	public Iterator<O> iterator() {
		//TODO: hier kommt der Zaubertrick mit einer inneren Klasse rein.
		return null;
	}
}
