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
	 * Liefert Wahrheitswert zur Bestimmung, ob Traktor t in Liste enthalten
	 * @param t != null
	 * @return true: wenn enthalten, false: sonst
	 */
	private boolean containsTraktor(Traktor t) {

		return liste.contains(t);
	}

	/**
	 * Getter-Methode fuer Betriebsstunden
	 * @param t != null
	 * @return betriebsstunden >= 0: wenn Traktor t enthalten, sonst: -1
	 */
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
				
				} else if (t.getErweiterung() instanceof TraktorErweiterungDuengerstreuer) {
				
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

		Iterator it = liste.iterator();


		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;
		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
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
		Iterator it = liste.iterator();

		double minSaeschareBiogas=Double.MAX_VALUE;
		double maxSaeschareBiogas=0;
		double minSaeschareDiesel=Double.MAX_VALUE;
		double maxSaeschareDiesel=0;

		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
			if(t instanceof TraktorMitBiogasMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareBiogas=min(t.erweiterungsAusmass(),minSaeschareBiogas);
				maxSaeschareBiogas=max(t.erweiterungsAusmass(),maxSaeschareBiogas);
			}else if(t instanceof TraktorMitDieselMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareDiesel=min(t.erweiterungsAusmass(),minSaeschareDiesel);
				maxSaeschareDiesel=max(t.erweiterungsAusmass(),maxSaeschareDiesel);
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

		Iterator it = liste.iterator();

		double sumFassungsvermoegenBiogas=0;
		double sumFassungsvermoegenDiesel=0;
		int counterBiogas=0;
		int counterDiesel=0;
		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
			if(t instanceof TraktorMitBiogasMotor && t.getErweiterung() instanceof TraktorErweiterungDuengestreuer){
				sumFassungsvermoegenBiogas +=t.erweiterungsAusmass();
				counterBiogas++;
			}else if(t instanceof TraktorMitDieselMotor && t.getErweiterung() instanceof TraktorErweiterungDuengestreuer){
				sumFassungsvermoegenDiesel  +=t.erweiterungsAusmass();
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
}