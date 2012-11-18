import java.util.Iterator;

/**
 * Iteratorklasse von Set
 * Ausgabefolge wird durch die Instanz von Set bestimmt
 */
public class SetIterator<T> implements Iterator<T> {

	private SetNode<T> node;
	private SetNode<T> prev;

	public SetIterator (SetNode<T> head) {

		this.node = head;
		prev = null;
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
			prev = node;
			node = node.getNext();

			return result.getValue();

		} else {

			return null;
		}

	}

	/**
	 * entfernt aktuelles Element aus der Liste TODO: head loeschbar machen
	 */
	public void remove() {
		
		node = node.remove(node.getValue());
		if(prev != null) {
			prev.setNext(node);
		}
		
	}
}