import java.util.Iterator;

/**
 * Iteratorklasse von Set
 * Ausgabefolge wird durch die Instanz von Set bestimmt
 */
public class SetIterator<T> implements Iterator<T> {

	private SetNode<T> node;

	public SetIterator (SetNode<T> head) {

		this.node = head;
	}

	/**
	 * liefert true, wenn noch weitere Listenelemente nachfolgen, ansonsten false
	 */
	public boolean hasNext() {

		return node != null;
	}
	
	/**
	 * liefert naechstes Listenelement, null wenn Ende erreicht
	 */
	public T next() {

		if (node != null) {

			SetNode<T> result = node;
			node = node.getNext();

			return result.getValue();

		} else {

			return null;
		}

	}

	/**
	 * entfernt aktuelles Element aus der Liste
	 */
	public void remove() {
		
		node = node.remove(node.getValue());
		
	}
}