public class Liste {


	private Node head;

	public Liste() {

		head = null;
	}

	public void add(Object t) {
		

		head = new Node(t,head);
	}

	public void remove(Object t) {

		if (head != null) {

			head = head.remove(t);
		}
	}

	public boolean contains(Object t) {

		return head != null && head.contains(t);
	}

	public ListIterator iterator() {

		return new ListIterator(head);
	}

	/**
	 * ++++++++++++++++++++++++++++++ INNER INNER CLASS ++++++++++++++++++++++++++++++
	 */
	private class Node {

		private Object t;
		private Node next;

		public Node(Object t, Node next) {

			this.t = t;
			this.next = next;
		}

		public Object getTraktor() {

			return t;
		}

		public Node getNext() {

			return next;
		}

		public boolean contains(Object t) {

			return this.t == t || (next != null && next.contains(t));
		}

		public Node remove(Object t) {

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
	private class ListIterator implements ObjectIterator{

		private Node current;

		public ListIterator(Node head) {

			current = head;
		}


		public boolean hasNext() {

			return current != null;
		}

		public Object next() {

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

