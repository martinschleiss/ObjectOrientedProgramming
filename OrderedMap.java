import java.util.Iterator;


public class OrderedMap<V extends Shorter, O> extends OrderedSet<V>{
	
	private MapNode<V, O> head;
	private MapNode<V, O> last;

	public OrderedMap() {
		super();
		head = null;
		last = null;
	}
	
	public void insert(V value) {
		O obj = null;
		insert(value, obj);
	}
	
	public void insert(V value, O obj) {
		
		MapNode<V, O> pos = getListHead();
		MapNode<V, O> tmp;

		if (pos == null) {

			head = new MapNode<V, O>(value, obj, null);
			last = head;

		} else {

			tmp = pos.getNext();

			if (tmp == null) {
				
				if (pos.getValue().shorter(value)) {
				
					last.insert(value);
					last = last.getNext();
					
				} else {
					
					head = new MapNode<V, O>(value, obj, head);
				}
				
			} else {

				while (tmp.getNext() != null && tmp.getValue().shorter(value)) {

					pos = pos.getNext();
					tmp = tmp.getNext();
				}

				pos.insert(value, obj);
			}
		}
	}
	
	public MapNode<V, O> getListHead() {
		return this.head;
	}
	
	public Iterator<V> iterator() {

		return new SetIterator<V>(head);
	}
}
