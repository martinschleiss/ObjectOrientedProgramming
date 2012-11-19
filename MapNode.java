
public class MapNode<V, O> extends SetNode<V> {
	
	private O obj;
	private MapNode<V, O> next;

	MapNode(V value, O obj, MapNode<V, O> next) {
		super(value, null);
		this.obj = obj;
		this.next = next;
	}
	
	public O getObject() {
		return this.obj;
	}
	
	public MapNode<V, O> getNext() {
		return this.next;
	}
	
	/**
	 * Entfernt Element aus verketteten Liste
	 * @param value 
	 * @param obj
	 * @return
	 */
	public MapNode<V, O> remove(V value, O obj) {
		
		if (getValue() == value && this.obj == obj) {
			
			return next;
		
		} else if (next != null) {
			
			next = next.remove(value, obj);
		}
		return this;
	}
	
	public void insert(V value) {
		next = new MapNode<V, O>(value, null, this.next);
	}
	
	public void insert(V value, O obj) {
		next = new MapNode<V, O>(value, obj, this.next);
	}
}
