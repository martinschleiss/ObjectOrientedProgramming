import java.util.Iterator;


public class OrderedMap<V extends Shorter, O> extends OrderedSet<V>{
	

	public OrderedMap() {
		super();
	}
	
	public void insert(V value) {
		O obj = null;
		insert(value, obj);
	}
	
	public void insert(V value, O obj) {
		
		super.insert(value);

	}
	
	public Iterator<V> iterator() {

		return new OrderedMapIterator<V, O>(this).it();
	}
	
	public Iterator<V> it () {
		return super.iterator();
	}
}
