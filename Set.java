import java.util.Iterator;

public class Set<T> implements Iterable<T> {
	
	SetNode<T> head;
	
	public Set() {
		
		head = null;
	}

	public void insert(T elem) {
		
		head.remove(elem); //keine Duplikate
		head = new SetNode<T>(elem,head);
	}
	public void remove (T elem) {
		
		if (head != null) {
			
			head = head.remove(elem);
		}
	}
	
	public Iterator<T> iterator() {
		
		return new SetIterator<T>(head);

	}
}
