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
	public void insert(T value) {
		
		remove(value);
		head = new SetNode<T>(value,head);
	}
	
	/**
	 * fuegt Element vor prev in Set ein. Ist prev nicht enthalten, wird value am Ende eingefuegt
	 * @param elem		wird eingefuegt, falls nicht in Set (wird mit == ueberprueft)
	 */
	public void insert(T value, T prev) {
		
		remove(value);
		SetNode<T> tmp = head;
		
		while (tmp.getNext() != null && tmp.getValue() != prev) {
			
			tmp = tmp.getNext();
		}
		
		tmp.insert(value);
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
	 * liefert Iterator des Sets, Elementfolge des Iterators = umgekehrte Einfuegefolge des Sets
	 */
	public Iterator<T> iterator() {
		
		return new SetIterator<T>(head);
	}
	
	protected SetNode<T> getValue() {
		
		return this.head;
	}
}
