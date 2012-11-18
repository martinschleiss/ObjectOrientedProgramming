import java.util.Iterator;

public class OrderedSetIterator<T extends Shorter> implements Iterator<T> {
	
	private SetNode<T> node;
	private SetNode<T> prev;
	private SetNode<T> previousOfPrev;
	private OrderedSet<T> set;

	public OrderedSetIterator (OrderedSet<T> set) {
		this.set = set;
		node = this.set.getListHead();
		prev = null;
	}
	
	/**
	 * liefert true, wenn noch weitere Listenelemente nachfolgen, ansonsten false
	 */
	public boolean hasNext() {

		return node != null;
	}
	
	/**
	 * TODO: liefert das naechste Element, wobei nachfolgende Elemente entsprechend shorter niemals kuerzer sind als vorangegangene
	 */
	public T next() {

		if (node != null) {

			SetNode<T> result = node;
			if(previousOfPrev != null) {
				previousOfPrev = prev;
			}
			prev = node;
			node = node.getNext();

			return result.getValue();

		} else {

			return null;
		}

	}

	/**
	 * entfernt zuletzt zurueckgegebenes Element aus der Liste
	 */
	public void remove() throws IllegalStateException {
		
		if(prev == null) {
			throw new IllegalStateException();
		} else {
			if(previousOfPrev != null) {
				prev.setNext(null);
				prev = null;
				previousOfPrev.setNext(node);
			} else {
				prev = null;
				set.setListHead(node);
			}
		}
	}
}
