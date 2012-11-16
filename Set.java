import java.util.Iterator;

public class Set<T> implements Iterable<T> {
	
	private SetNode<T> head;
	
	public Set() {
		
		head = null;
	}

	/**
	 * fuegt Element in Set ein
	 * @param elem		wird eingefuegt, falls nicht in Set (wird mit == ueberprueft)
	 */
	public void insert(T elem) {
		
		remove(elem);
		head = new SetNode<T>(elem,head);
	}
	
	/**
	 * entfernt Element aus Set
	 * @param elem		wird entfernt, falls in Set (wird mit == ueberprueft)
	 */
	public void remove (T elem) {
		
		if (head != null) {
			
			head = head.remove(elem);
		}
	}
	
	/**
	 * liefert Iterator des Sets, Elementfolge des Iterators = Einfuegefolge des Sets
	 */
	public Iterator<T> iterator() {
		
		return new SetIterator<T>(head);
	}
}
