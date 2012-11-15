
public class SetNode<T> {
	
	private T elem;
	private SetNode<T> next;
	
	SetNode (T elem, SetNode<T> next) {
		
		this.elem = elem;
		this.next = next;
	}
	
	public T getElem() {
		
		return this.elem;
	}
	public SetNode<T> getNext() {
		
		return this.next;
	}
	
	public SetNode<T> remove(T elem) {
		
		if (this.elem == elem) {
			
			return next;
		
		} else if (next != null) {
			
			next = next.remove(elem);
		}
		return next;
	}
}
