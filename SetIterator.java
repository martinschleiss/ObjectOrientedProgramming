import java.util.Iterator;

public class SetIterator<T> implements Iterator<T> {

	private SetNode<T> node;

	public SetIterator (SetNode<T> head) {

		this.node = head;
	}

	public boolean hasNext() {

		return node != null;
	}
	public T next() {

		if (node != null) {

			SetNode<T> result = node;
			node = node.getNext();

			return result.getElem();

		} else {

			return null;
		}

	}

	public void remove() {
		
		node = node.remove(node.getElem());
		
	}
}