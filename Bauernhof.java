public class Bauernhof {

	private final String name;
	private Traktorliste liste;

	public Bauernhof(String name) {

		this.name = name;
		liste = new Traktorliste();
	}
	
	public void addTraktor(Traktor t) {
		
		liste.add(t);
	}
	public void removeTraktor(Traktor t) {
		
		liste.remove(t);
	}
	
	public boolean containsTraktor(Traktor t) {
		
		return liste.contains(t);
	}
	
	public TraktorIterator iterator() {
		
		return liste.iterator();
	}
	
	/**
	 * ++++++++++++++++++++++++++++++ INNER CLASS ++++++++++++++++++++++++++++++
	 */
	private class Traktorliste {

		private Node head;

		public Traktorliste() {

			head = null;
		}

		public void add(Traktor t) {

			head = new Node(t,head);
		}

		public void remove(Traktor t) {
			
			if (head != null) {
				
				head = head.remove(t);
			}
		}

		public boolean contains(Traktor t) {
			
			return head != null && head.contains(t);
		}
		
		public ListIterator iterator() {
			
			return new ListIterator(head);
		}
		
		/**
		 * ++++++++++++++++++++++++++++++ INNER INNER CLASS ++++++++++++++++++++++++++++++
		 */
		private class Node {

			private Traktor t;
			private Node next;

			public Node(Traktor t, Node next) {

				this.t = t;
				this.next = next;
			}
			
			public Traktor getTraktor() {
				
				return t;
			}
			
			public Node getNext() {

				return next;
			}

			public boolean contains(Traktor t) {
				
				return this.t == t || (next != null && next.contains(t));
			}

			public Node remove(Traktor t) {
				
				if (this.t == t) {
					
					return next;
					
				} else if (next != null) {
					
					next = next.remove(t);
				}
				return this;
			}

		}
		
		/**
		 * ++++++++++++++++++++++++++++++ INNER INNER CLASS ++++++++++++++++++++++++++++++
		 */
		private class ListIterator implements TraktorIterator {

			private Node current;
			
			public ListIterator(Node head) {
				
				current = head;
			}
			
			@Override
			public boolean hasNext() {

				return current != null;
			}

			@Override
			public Traktor next() {
				
				if (current != null) {
					
					Node output = current;
					current = current.getNext();
					return output.getTraktor();
				
				} else {
					
					return null;
				}
			}
		}
	}
}