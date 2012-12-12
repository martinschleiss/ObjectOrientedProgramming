/**
 * Repraesentiert einen Bauernhof
 * Bietet Methoden zum Verwalten von Traktoren sowie zur Berechnung von statistischen Werten an
 */

@Gruppenmitglied("Anil")
public class Bauernhof {

	private final String name;
	private Liste liste;

	public Bauernhof(String name) {

		this.name = name;
		liste = new Liste();
	}

	/**
	 * Getter-Methode fuer Namen des Bauernhofs
	 * @return name: unveraenderlich
	 */
	public String name(){

		return name;
	}

	/**
	 * Liefert Traktor anhand der eindeutigen Seriennummer, falls gespeichert
	 * @param seriennummer > 0
	 * @return Traktor mit Seriennummer
	 */
	public Traktor getTraktor(int seriennummer){

		return liste.getTraktor(seriennummer);
	}

	/**
	 * Speichert Traktor t in Liste
	 * @param t != null
	 */
	public void addTraktor(Traktor t) {

		liste.add(t);
	}

	/**
	 * Entfernt erstes Vorkommen von Traktor t aus der Liste
	 * @param t != null
	 */
	public void removeTraktor(Traktor t) {

		liste.remove(t);
	}

	/**
	 * Getter-Methode fuer Betriebsstunden
	 * @param t != null
	 * @return betriebsstunden >= 0: wenn Traktor t enthalten, sonst: -1
	 */
	@Gruppenmitglied("Rafael")
	private int getBetriebsstunden(Traktor t) {

		if (liste.contains(t)) {

			return t.betriebsstunden();

		} else {

			return -1;
		}
	}

	/**
	 * Setter-Methode fuer Betriebsstunden
	 * @param t != null
	 * @param stunden > 0
	 * 
	 * @return true: wenn Traktor enthalten, false: sonst
	 */
	@Gruppenmitglied("Martin")
	public boolean erhoeheBetriebsstunden(Traktor t, int stunden){

		if (liste.contains(t)) {
			t.erhoeheBetriebsstundenUm(stunden);

			return true;

		} else {

			return false;
		}
	}

	/**
	 * Getter-Methode fuer Verbrauch
	 * @param t != null
	 * @return verbrauch >= 0: wenn Traktor t enthalten, sonst: -1
	 */
	@Gruppenmitglied("Rafael")
	private int getVerbrauch(Traktor t) {

		if (liste.contains(t)) {

			return (int)t.bisherigerVerbrauch();

		} else {

			return -1;
		}
	}

	/**
	 * Setter-Methode fuer Verbrauch
	 * @param t != null
	 * @param verbrauch > 0 (steigt), < 0 (sinkt)
	 * 
	 * @return true: wenn Traktor enthalten, false: sonst
	 */
	@Gruppenmitglied("Rafael")
	public boolean setVerbrauch(Traktor t, int verbrauch) {

		if (liste.contains(t)) {

			t.erhoeheVerbrauch(verbrauch);
			return true;

		} else {

			return false;
		}
	}

	/**
	 * Getter-Methode fuer Verbrauch von Diesel-Traktoren
	 * @param t != null
	 * @return verbrauch >= 0: wenn Traktor t enthalten und t von Typ TraktorMitDieselMotor, sonst: -1
	 */
	@Gruppenmitglied("Rafael")
	private int getDieselVerbrauch(Traktor t) {

		if (t instanceof TraktorMitDieselMotor && liste.contains(t)) {

			return (int)t.bisherigerVerbrauch();

		} else {

			return -1;
		}
	}

	/**
	 * Setter-Methode fuer Verbrauch von DieselTraktoren
	 * @param t != null
	 * @param verbrauch > 0 (steigt), < 0 (sinkt)
	 * 
	 * @return true: wenn Traktor enthalten und t von Typ TraktorMitDieselMotor, false: sonst
	 */
	@Gruppenmitglied("Rafael")
	public boolean setDieselVerbrauch(Traktor t, int verbrauch) {

		if (t instanceof TraktorMitDieselMotor && liste.contains(t)) {

			t.erhoeheVerbrauch(verbrauch);
			return true;

		} else {

			return false;
		}
	}

	/**
	 * Getter-Methode fuer Verbrauch von Biogas-Traktoren
	 * @param t != null
	 * @return verbrauch >= 0: wenn Traktor t enthalten und t von Typ TraktorMitBiogasMotor, sonst: -1
	 */
	@Gruppenmitglied("Rafael")
	private double getBiogasVerbrauch(Traktor t) {

		if (t instanceof TraktorMitBiogasMotor && liste.contains(t)) {

			return t.bisherigerVerbrauch();

		} else {

			return -1;
		}
	}

	/**
	 * Setter-Methode fuer Verbrauch von Biogas-Traktoren
	 * @param t != null
	 * @param verbrauch > 0 (steigt), < 0 (sinkt)
	 * 
	 * @return true: wenn Traktor enthalten und t von Typ TraktorMitBiogasMotor, false: sonst
	 */
	@Gruppenmitglied("Rafael")
	public boolean setBiogasVerbrauch(Traktor t, double verbrauch) {

		if (t instanceof TraktorMitBiogasMotor && liste.contains(t)) {

			t.erhoeheVerbrauch(verbrauch);
			return true;

		} else {

			return false;
		}
	}

	/**
	 * Liefert Iterator ueber die Liste der gespeicherten Traktoren
	 * @return Iterator, next() liefert Object, keinen Traktor
	 * 			Ausgabefolge: unbestimmt
	 */
	public Iterator iterator() {

		return liste.iterator();
	}

	/**
	 * @param traktor  je nach Traktortyp entsprechende Ausgabe
	 * @return Durchschnittlicher verbrauch nach Motorart 
	 */
	@Gruppenmitglied("Anil")
	public String avgBetriebsstundenNachMotorart() {

		Iterator it = liste.iterator();

		int sumBiogas=0;
		int sumDiesel=0;
		int counterBiogas=0;
		int counterDiesel=0;

		while(it.hasNext()){

			Traktor t=(Traktor)it.next();

			if( t instanceof TraktorMitBiogasMotor){

				sumBiogas +=t.betriebsstunden();
				counterBiogas++;

			} else if (t instanceof TraktorMitDieselMotor){

				sumDiesel +=t.betriebsstunden();
				counterDiesel++;
			}
		}

		String biogas;
		String diesel;

		if (counterBiogas > 0) {

			biogas = "Biogas: " + (sumBiogas/counterBiogas);

		} else {

			biogas = "Biogas: keine Traktoren verfuegbar";
		}

		if (counterDiesel > 0) {

			diesel = "Diesel: " + (sumDiesel/counterDiesel);

		} else {

			diesel = "Diesel: keine Traktoren verfuegbar";
		}

		return "Durchschnitt Betriebsstunden nach Motorart:\n\t" + diesel + "\n\t" + biogas;
	}

	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnitt der Betriebsstunden von Allen Traktoren und spezifisch nach Erweiterung
	 */
	@Gruppenmitglied("Anil")
	public String avgBetriebsstundenNachErweiterung(){

		Iterator it = liste.iterator();

		int sumDrill=0;
		int sumDuenger=0;
		int counterDrill=0;
		int counterDuenger=0;

		while(it.hasNext()){

			Traktor t=(Traktor)it.next();

			if( t.getErweiterung() instanceof TraktorErweiterungDrillmaschine) {

				sumDrill +=t.betriebsstunden();
				counterDrill++;

			} else if (t.getErweiterung() instanceof TraktorErweiterungDuengestreuer) {

				sumDuenger +=t.betriebsstunden();
				counterDuenger++;
			}
		}

		String drill;
		String duenger;
		String avg;

		if (counterDrill > 0) {

			drill = "Drillmaschine: " + (sumDrill/counterDrill);

		} else {

			drill = "Drillmaschine: keine Traktoren verfuegbar";
		}

		if (counterDuenger > 0) {

			duenger = "Duengerstreuer: " + (sumDuenger/counterDuenger);

		} else {

			duenger = "Duengerstreuer: keine Traktoren verfuegbar";
		}

		if (counterDuenger+counterDrill > 0) {

			avg = "Beide Erweiterungen: " + (sumDrill+sumDuenger)/(counterDuenger+counterDrill);

		} else {

			avg = "Beide Erweiterungen: keine Traktoren verfuegbar";
		}

		return "Durchschnitt Betriebsstunden nach Erweiterungen:\n\t" + drill + "\n\t" + duenger + "\n\t" + avg;
	}

	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnittlicher Verbrauch von Allen Traktoren mit Dieselmotor und spezifisch nach Erweiterung
	 */
	@Gruppenmitglied("Anil")
	public String avgDieselverbrauchNachErweiterung(){

		Iterator it = liste.iterator();

		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;

		while(it.hasNext()){

			Traktor t=(Traktor)it.next();

			if(t instanceof TraktorMitDieselMotor) {

				if (t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){

					sumDrill += t.bisherigerVerbrauch();
					counterDrill++;

				} else if (t.getErweiterung() instanceof TraktorErweiterungDuengestreuer) {

					sumDuenger +=t.bisherigerVerbrauch();
					counterDuenger++;
				}
			}
		}
		String drill;
		String duenger;
		String avg;

		if (counterDrill > 0) {

			drill = "Drillmaschine: " + (sumDrill/counterDrill);

		} else {

			drill = "Drillmaschine: keine Traktoren verfuegbar";
		}

		if (counterDuenger > 0) {

			duenger = "Duengerstreuer: " + (sumDuenger/counterDuenger);

		} else {

			duenger = "Duengerstreuer: keine Traktoren verfuegbar";
		}

		if (counterDuenger+counterDrill > 0) {

			avg = "Beide Erweiterungen: " + (sumDrill+sumDuenger)/(counterDuenger+counterDrill);

		} else {

			avg = "Beide Erweiterungen: keine Traktoren verfuegbar";
		}

		return "Durchschnitt Diesel-Motor Betriebsstunden nach Erweiterungen:\n\t" + drill + "\n\t" + duenger + "\n\t" + avg;
	}
	
	/**
	 * 
	 * @param erweiterung: je nach Erweiterungstyp entsprechende Ausgabe
	 * @return durchschnittlicher Verbrauch von Allen Traktoren mit Biogasmotor und spezifisch nach Erweiterung
	 */
	@Gruppenmitglied("Anil")
	public String avgBiogasverbrauchNachErweiterung(){

		Iterator it = liste.iterator();

		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;

		while(it.hasNext()){

			Traktor t=(Traktor)it.next();

			if(t instanceof TraktorMitBiogasMotor) {

				if (t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){

					sumDrill += t.bisherigerVerbrauch();
					counterDrill++;

				} else if (t.getErweiterung() instanceof TraktorErweiterungDuengestreuer) {

					sumDuenger +=t.bisherigerVerbrauch();
					counterDuenger++;
				}
			}
		}
		String drill;
		String duenger;
		String avg;

		if (counterDrill > 0) {

			drill = "Drillmaschine: " + (sumDrill/counterDrill);

		} else {

			drill = "Drillmaschine: keine Traktoren verfuegbar";
		}

		if (counterDuenger > 0) {

			duenger = "Duengerstreuer: " + (sumDuenger/counterDuenger);

		} else {

			duenger = "Duengerstreuer: keine Traktoren verfuegbar";
		}

		if (counterDuenger+counterDrill > 0) {

			avg = "Beide Erweiterungen: " + (sumDrill+sumDuenger)/(counterDuenger+counterDrill);

		} else {

			avg = "Beide Erweiterungen: keine Traktoren verfuegbar";
		}

		return "Durchschnitt Biogas-Motor Betriebsstunden nach Erweiterungen:\n\t" + drill + "\n\t" + duenger + "\n\t" + avg;
	}
	
	/**
	 * 
	 * @param traktor je nach Traktortyp entsprechende Ausgabe
	 * @return min/max der Saeschare aller Traktoren und spezifisch nach traktortyp
	 */
	@Gruppenmitglied("Anil")
	public String anzahlMinMaxSaeschare(){
		
		Iterator it = liste.iterator();

		int minSaeschareBiogas=Integer.MAX_VALUE;
		int maxSaeschareBiogas=0;
		int minSaeschareDiesel=Integer.MAX_VALUE;
		int maxSaeschareDiesel=0;

		while(it.hasNext()){
			
			Traktor t=(Traktor)it.next();
			
			if(t instanceof TraktorMitBiogasMotor && t.getErweiterung() instanceof TraktorErweiterungDrillmaschine) {
				
				minSaeschareBiogas=(int)Math.min(t.erweiterungsAusmass(),minSaeschareBiogas);
				maxSaeschareBiogas=(int)Math.max(t.erweiterungsAusmass(),maxSaeschareBiogas);
			
			}else if(t instanceof TraktorMitDieselMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareDiesel=(int)Math.min(t.erweiterungsAusmass(),minSaeschareDiesel);
				maxSaeschareDiesel=(int)Math.max(t.erweiterungsAusmass(),maxSaeschareDiesel);
			}
		}
		
		return "Saescharen-Daten aller Traktoren zusammen:\n\tMinimum: "+ Math.min(minSaeschareBiogas,minSaeschareDiesel) + "\n\tMaximum: "
				+ Math.max(maxSaeschareBiogas,maxSaeschareDiesel) + "\n\tDiesel-Motoren: Minimum: " + minSaeschareDiesel + "\n\tMaximum: " + maxSaeschareDiesel + 
				"\n\tBiogas-Motoren: Minimum: " + minSaeschareBiogas + "\n\tMaximum: " + maxSaeschareBiogas;
	}

	/**
	 * 
	 * @param traktor je nach Traktortyp entsprechende Ausgabe
	 * @return durchschnitt des Fassungsvermoegens aller Traktoren und spezifisch nach Traktortyp
	 */
	@Gruppenmitglied("Anil")
	public String avgFassungsVermoegen(){

		Iterator it = liste.iterator();

		double sumBiogas=0;
		double sumDiesel=0;
		int counterBiogas=0;
		int counterDiesel=0;
		
		while(it.hasNext()){
		
			Traktor t=(Traktor)it.next();
			
			if(t instanceof TraktorMitBiogasMotor && t.getErweiterung() instanceof TraktorErweiterungDuengestreuer){
			
				sumBiogas +=t.erweiterungsAusmass();
				counterBiogas++;
			
			}else if(t instanceof TraktorMitDieselMotor && t.getErweiterung() instanceof TraktorErweiterungDuengestreuer){
				
				sumDiesel  +=t.erweiterungsAusmass();
				counterDiesel++;
			}
		}
		
		String diesel;
		String biogas;
		String avg;
		
		if (counterBiogas > 0) {

			biogas = "Biogas: " + (sumBiogas/counterBiogas);

		} else {

			biogas = "Biogas: keine Traktoren verfuegbar";
		}

		if (counterDiesel > 0) {

			diesel = "Diesel: " + (sumDiesel/counterDiesel);

		} else {

			diesel = "Diesel: keine Traktoren verfuegbar";
		}
		
		if (counterDiesel+counterBiogas > 0) {

			avg = "Beide: " + (sumDiesel+sumBiogas)/(counterDiesel+counterBiogas);

		} else {

			avg = "Diesel: keine Traktoren verfuegbar";
		}
		
		return "Durchschnitt Fassungsvermoegen der Duengestreuer nach Motorart:\n\t" + avg + "\n\t" + diesel + "\n\t" + biogas;
	}
}