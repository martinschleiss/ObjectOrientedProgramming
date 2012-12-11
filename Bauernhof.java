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

	public boolean setDieselVerbrauch(Traktor t, int verbrauch) {

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

	public boolean setBiogasVerbrauch(Traktor t, double verbrauch) {

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

	//TODO rueckgabeTypen aller Statistiken besprechen, ob String oder double
	/**
	 * @param traktor  je nach Traktortyp entsprechende Ausgabe
	 * @return Durchschnittlicher verbrauch nach Motorart 
	 */
	public double durchschnittArbeitstundenNachMotorart(Traktor traktor){

		TraktorIterator it = liste.iterator();

		double sumBiogas=0.0;
		double sumDiesel=0.0;
		int counterBiogas=0;
		int counterDiesel=0;
		while(it.hasNext()){
			Traktor t=it.next();
			if( t instanceof TraktorMitBiogasMotor){
				sumBiogas +=t.betriebsstunden();
				counterBiogas++;
			}else {
				sumDiesel +=t.betriebsstunden();
				counterDiesel++;
			}
		}

		if(traktor instanceof TraktorMitBiogasMotor){
			return sumBiogas/counterBiogas;
		}else{
			return sumDiesel/counterDiesel;
		}

	}

	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnitt der Betriebsstunden von Allen Traktoren und spezifisch nach Erweiterung
	 */
	public String durchschnittArbeitstundenNachErweiterung(TraktorErweiterung erweiterung){

		TraktorIterator it = liste.iterator();


		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;
		while(it.hasNext()){
			Traktor t=it.next();
			if( t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				sumDrill += t.betriebsstunden();
				counterDrill++;
			}else {
				sumDuenger +=t.betriebsstunden();
				counterDuenger++;
			}
		}

		String out="Durchschnittliche Arbeitstunden aller Traktoren: "+(sumDrill+sumDuenger)/(counterDrill+counterDuenger);

		if(erweiterung instanceof TraktorErweiterungDrillmaschine){

			return out+" Traktoren die saeen: "+sumDrill/counterDrill;
		}else{
			return out+" Traktoren die duengern: "+sumDuenger/counterDuenger;
		}
	}
	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnittlicher Verbrauch von Allen Traktoren mit Dieselmotor und spezifisch nach Erweiterung
	 */
	public String durchschnittDieselverbrauchNachErweiterung(TraktorErweiterung erweiterung){

		TraktorIterator it = liste.iterator();


		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;
		while(it.hasNext()){
			Traktor t=it.next();
			if(t instanceof TraktorMitDieselMotor && t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				sumDrill += t.bisherigerVerbrauch();
				counterDrill++;
			}else if(t instanceof TraktorMitDieselMotor) {
				sumDuenger +=t.bisherigerVerbrauch();
				counterDuenger++;
			}
		}
		String out="Durchschnittlicher Verbrauch aller DieselTraktoren: "+(sumDrill+sumDuenger)/(counterDrill+counterDuenger);

		if(erweiterung instanceof TraktorErweiterungDrillmaschine){
			return out+" Traktoren die saeen: "+sumDrill/counterDrill;
		}else{
			return out+" Traktoren die duengern: "+sumDuenger/counterDuenger;
		}
	}
	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnittlicher Verbrauch von Allen Traktoren mit Biogasmotor und spezifisch nach Erweiterung
	 */
	public String durchschnittGasverbrauchNachErweiterung(TraktorErweiterung erweiterung){

		TraktorIterator it = liste.iterator();


		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;
		while(it.hasNext()){
			Traktor t=it.next();
			if(t instanceof TraktorMitBiogasMotor && t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				sumDrill += t.bisherigerVerbrauch();
				counterDrill++;
			}else if(t instanceof TraktorMitBiogasMotor) {
				sumDuenger +=t.bisherigerVerbrauch();
				counterDuenger++;
			}
		}
		String out="Durchschnittlicher Verbrauch aller BiogasTraktoren: "+(sumDrill+sumDuenger)/(counterDrill+counterDuenger);

		if(erweiterung instanceof TraktorErweiterungDrillmaschine){
			return out+" Traktoren die saeen: "+sumDrill/counterDrill;
		}else{
			return out+" Traktoren die duengern: "+sumDuenger/counterDuenger;
		}
	}
	/**
	 * 
	 * @param traktor je nach Traktortyp entsprechende Ausgabe
	 * @return min/max der Saeschare aller Traktoren und spezifisch nach traktortyp
	 */
	public String anzahlMinMaxSaeschare(Traktor traktor){
		TraktorIterator it = liste.iterator();

		double minSaeschareBiogas=Double.MAX_VALUE;
		double maxSaeschareBiogas=0;
		double minSaeschareDiesel=Double.MAX_VALUE;
		double maxSaeschareDiesel=0;

		while(it.hasNext()){
			Traktor t=it.next();
			//System.out.println(t.serienNummer());
			if(t instanceof TraktorMitBiogasMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareBiogas=min(t.erweiterungsAusmasz(),minSaeschareBiogas);
				maxSaeschareBiogas=max(t.erweiterungsAusmasz(),maxSaeschareBiogas);
				//System.out.println(t.serienNummer() +" "+minSaeschareBiogas+" "+maxSaeschareBiogas);


			}else if(t instanceof TraktorMitDieselMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareDiesel=min(t.erweiterungsAusmasz(),minSaeschareDiesel);
				maxSaeschareDiesel=max(t.erweiterungsAusmasz(),maxSaeschareDiesel);
				//System.out.println(t.serienNummer() +" "+minSaeschareDiesel+" "+maxSaeschareDiesel);

			}
		}

		String out="Saescharen aller Traktoren zusammen: min: "+min(minSaeschareBiogas,minSaeschareDiesel)+" max: "+max(maxSaeschareBiogas,maxSaeschareDiesel);
		if(traktor instanceof TraktorMitBiogasMotor ){
			return out+" mit Biogas min: "+minSaeschareBiogas+" max: "+maxSaeschareBiogas;
		}else{
			return out+" mit Diesel min: "+minSaeschareDiesel+" max: "+maxSaeschareDiesel;
		}

	}

	private double min(double a, double b){
		if(a<b){
			return a;
		}else {
			return b;
		}

	}

	private double max(double a, double b){
		if(a>b){
			return a;
		}else {
			return b;
		}

	}

	/**
	 * 
	 * @param traktor je nach Traktortyp entsprechende Ausgabe
	 * @return durchschnitt des Fassungsvermoegens aller Traktoren und spezifisch nach Traktortyp
	 */
	public String durchschnittFassungsVermoegen(Traktor traktor){

		TraktorIterator it = liste.iterator();

		double sumFassungsvermoegenBiogas=0;
		double sumFassungsvermoegenDiesel=0;
		int counterBiogas=0;
		int counterDiesel=0;
		while(it.hasNext()){
			Traktor t=it.next();
			if(t instanceof TraktorMitBiogasMotor && t.getErweiterung() instanceof TraktorErweiterungDuengestreuer){
				sumFassungsvermoegenBiogas +=t.erweiterungsAusmasz();
				counterBiogas++;
			}else if(t instanceof TraktorMitDieselMotor && t.getErweiterung() instanceof TraktorErweiterungDuengestreuer){
				sumFassungsvermoegenDiesel  +=t.erweiterungsAusmasz();
				counterDiesel++;
			}
		}
		String out="Durchschnittliches Fassungsvermoegen aller Traktoren: "+(sumFassungsvermoegenBiogas+sumFassungsvermoegenDiesel)/(counterDiesel+counterBiogas);

		if(traktor instanceof TraktorMitBiogasMotor ){
			return out+" Mit Biogas: "+(sumFassungsvermoegenBiogas/counterBiogas);
		}else{
			return out+" Mit Diesel: "+(sumFassungsvermoegenDiesel/counterDiesel);
		}
	}

	/**
	 * ++++++++++++++++++++++++++++++ INNER CLASS ++++++++++++++++++++++++++++++
	 * 
	 * Nicht-generische, verkettete Liste zum Speichern von Traktoren
	 */
	private class Traktorliste {

		private Node head;

		public Traktorliste() {

			head = null;
		}

		/**
		 * speichert Traktor t in der Liste
		 * @param t != null
		 */
		public void add(Traktor t) {

			head = new Node(t,head);
		}

		/**
		 * loescht erstes Vorkommen von Traktor t aus der Liste
		 * @param t != null
		 */
		public void remove(Traktor t) {

			if (head != null) {

				head = head.remove(t);
			}
		}

		/**
		 * liefert Wahrheitswert zur Bestimmung, ob Traktor t in Liste enthalten ist
		 * @param	t != null
		 * @return	true: wenn enthalten, false: sonst
		 */
		public boolean contains(Traktor t) {

			return head != null && head.contains(t);
		}

		/**
		 * erzeugt Iterator ueber die Traktorliste
		 * @return	TraktorIterator: Ausgabefolge unbestimmt
		 */
		public ListIterator iterator() {

			return new ListIterator(head);
		}

		/**
		 * ++++++++++++++++++++++++++++++ INNER INNER CLASS ++++++++++++++++++++++++++++++
		 * 
		 * Knoten einer Liste, speichert je einen Traktor und eine Referenz auf den Nachfolgerknoten
		 */
		private class Node {

			private Traktor t; // != null
			private Node next;

			public Node(Traktor t, Node next) {

				this.t = t;
				this.next = next;
			}

			/**
			 * Getter-Methode
			 * @return gespeicherten Traktor t != null
			 */
			public Traktor getTraktor() {

				return t;
			}

			/**
			 * Getter-Methode fuer naechsten Knoten der Liste
			 * @return null: wenn letztes Element der Liste, Nachfolgerknoten: sonst 
			 */
			public Node getNext() {

				return next;
			}

			/**
			 * liefert Wahrheitswert zur Bestimmung, ob Traktor t in diesem oder einem Nachfolgerknoten enthalten ist
			 * @param	t != null
			 * @return	true: wenn enthalten, false: sonst
			 */
			public boolean contains(Traktor t) {

				return this.t == t || (next != null && next.contains(t));
			}

			/**
			 * loescht erstes Vorkommen von Traktor t aus diesem oder einem Nachfolgerknoten
			 * @param	t != null
			 * @return	Nachfolgerknoten: wenn t gespeichert, this: sonst
			 */
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
		 * 
		 * Nicht-generischer Iterator fuer Traktorliste
		 * Ausgabefolge unbestimmt
		 */
		private class ListIterator implements TraktorIterator {

			private Node current;

			public ListIterator(Node head) {

				current = head;
			}

			/**
			 * Zur Abfrage, ob Listenende erreicht
			 * @return false, wenn Ende der Liste erreicht, sonst true
			 */
			@Override
			public boolean hasNext() {

				return current != null;
			}

			/**
			 * Liefert naechsten Traktor der Liste
			 * @return naechsten Traktor der Liste, null wenn Listenende erreicht (hasNext() == false)
			 */
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