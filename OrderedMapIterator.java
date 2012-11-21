import java.util.Iterator;

/**
 * Iteratorklasse fuer OrderedMap
 */
public class OrderedMapIterator<S extends Shorter<? super S>,P> implements Iterator<S> {

	private MapNode<S,P> next;
	private MapNode<S,P> current;
	private MapNode<S,P> prev;
	private OrderedMap<S,P> map;

	public OrderedMapIterator (OrderedMap<S,P> map) {

		this.map = map;
		next = map.getMapHead();
		current = null;
		prev = null;
	}

	/**
	 * liefert true, wenn noch weitere Listenelemente nachfolgen, ansonsten false
	 */
	public boolean hasNext() {

		return next != null;
	}

	/**
	 * liefert das naechste Element, wobei nachfolgende Elemente entsprechend shorter niemals kuerzer sind als vorangegangene
	 */
	public S next() {

		if (next != null) {

			MapNode<S,P> result = next;

			prev = current;
			current = next;
			next = next.getNext();

			return result.getValue();

		} else {

			return null;
		}
	}

	/**
	 * entfernt zuletzt zurueckgegebenes Element aus der Liste
	 * kann nur einmal pro next() aufgerufen werden.
	 */
	public void remove() throws IllegalStateException {

		if(current == null) {

			throw new IllegalStateException();

		} else {

			if(prev != null) {

				map.remove(current.getValue());
				current = null;
				prev = null;

			} else {

				map.setListHead(next);
				current = null;
			}
		}
	}

	public Iterator<P> iterator() throws IllegalStateException{

		if (current != null) {

			return current.getObjects().iterator();

		} else {

			throw new IllegalStateException();
		}
	}
}
