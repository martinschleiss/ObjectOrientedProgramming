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

	public int getBetriebsstunden(Traktor t) {

		if (liste.contains(t)) {

			return t.betriebsstunden();

		} else {

			return -1;
		}
	}

	public boolean erhoeheBetriebsstunden(Traktor t, int stunden){

		if (liste.contains(t)) {

			t.erhoeheBetriebsstundenUm(stunden);
			return true;

		} else {

			return false;
		}
	}

	//TODO: Methoden und Argumente der Getter und Setter besprechen:
	
	public int getVerbrauch(Traktor t) {

		if (liste.contains(t)) {

			return (int)t.bisherigerVerbrauch();

		} else {

			return -1;
		}
	}

	public boolean setVerbrauch(Traktor t, int verbrauch) {

		if (liste.contains(t)) {

			t.erhoeheVerbrauch(verbrauch);
			return true;

		} else {

			return false;
		}
	}

	public int getDieselVerbrauch(TraktorMitDieselMotor t) {

		if (liste.contains(t)) {

			return (int)t.bisherigerVerbrauch();

		} else {

			return -1;
		}
	}

	public boolean setDieselVerbrauch(TraktorMitDieselMotor t, int verbrauch) {

		if (liste.contains(t)) {

			t.erhoeheVerbrauch(verbrauch);
			return true;

		} else {

			return false;
		}
	}

	public double getBiogasVerbrauch(TraktorMitBiogasMotor t) {

		if (liste.contains(t)) {

			return t.bisherigerVerbrauch();

		} else {

			return -1;
		}
	}

	public boolean setBiogasVerbrauch(TraktorMitDieselMotor t, double verbrauch) {

		if (liste.contains(t)) {

			t.erhoeheVerbrauch(verbrauch);
			return true;

		} else {

			return false;
		}
	}

	public TraktorIterator iterator() {

		return liste.iterator();
	}

	/**
	 * @param traktor  je nach Traktortyp entsprechende Ausgabe
	 * @return Durchschnittlicher verbrauch nach Motorart 
	 */
	public Double durchschnittArbeitstundenNachMotorart(Traktor traktor){

		TraktorIterator it = iterator();

		Double sumBiogas=0.0;
		Double sumDiesel=0.0;
		int counter=0;
		if(it.hasNext()){
			Traktor t=it.next();
			if( t instanceof TraktorMitBiogasMotor){
				sumBiogas +=t.betriebsstunden();
			}else {
				sumDiesel +=t.betriebsstunden();
			}
			counter ++;
		}

		if(traktor instanceof TraktorMitBiogasMotor){
			return sumDiesel/counter;
		}else{
			return sumBiogas/counter;
		}

	}
	
	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnitt der Betriebsstunden von Allen Traktoren und spezifisch nach Erweiterung
	 */
	public String durchschnittArbeitstundenNachErweiterung(TraktorErweiterung erweiterung){

		TraktorIterator it = iterator();

		Double sumDrill=0.0;
		Double sumDuenger=0.0;
		int counter=0;
		if(it.hasNext()){
			Traktor t=it.next();
			if( t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				sumDrill +=t.betriebsstunden();
			}else {
				sumDuenger +=t.betriebsstunden();
			}
			counter ++;
		}

		if(erweiterung instanceof TraktorErweiterungDrillmaschine){
			return "Alle Traktoren: "+(sumDrill+sumDuenger)/counter+" Traktoren die saeen: "+sumDrill/counter;
		}else{
			return "Alle Traktoren: "+(sumDrill+sumDuenger)/counter+" Traktoren die duengern: "+sumDuenger/counter;
		}
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