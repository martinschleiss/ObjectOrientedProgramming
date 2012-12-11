@Gruppenmitglied("Anil")
public class Bauernhof {

	private final String name;
	private Liste liste;

	public Bauernhof(String name) {

		this.name = name;
		liste = new Liste();
	}
	public String getName(){
		return name;
	}
	
	@Gruppenmitglied("Rafael")
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
	public Traktor getTraktor(int seriennummer){
		
		return liste.getTraktor(seriennummer);
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

	public ObjectIterator iterator() {

		return liste.iterator();
	}

	//TODO rueckgabeTypen aller Statistiken besprechen, ob String oder double
	/**
	 * @param traktor  je nach Traktortyp entsprechende Ausgabe
	 * @return Durchschnittlicher verbrauch nach Motorart 
	 */
	public double durchschnittArbeitstundenNachMotorart(Traktor traktor){

		ObjectIterator it = liste.iterator();

		double sumBiogas=0.0;
		double sumDiesel=0.0;
		int counterBiogas=0;
		int counterDiesel=0;
		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
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

		ObjectIterator it = liste.iterator();


		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;
		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
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

		ObjectIterator it = liste.iterator();


		double sumDrill=0.0;
		double sumDuenger=0.0;
		int counterDrill=0;
		int counterDuenger=0;
		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
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

		ObjectIterator it = liste.iterator();


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
		ObjectIterator it = liste.iterator();

		double minSaeschareBiogas=Double.MAX_VALUE;
		double maxSaeschareBiogas=0;
		double minSaeschareDiesel=Double.MAX_VALUE;
		double maxSaeschareDiesel=0;

		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
			if(t instanceof TraktorMitBiogasMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareBiogas=min(t.erweiterungsAusmasz(),minSaeschareBiogas);
				maxSaeschareBiogas=max(t.erweiterungsAusmasz(),maxSaeschareBiogas);
			}else if(t instanceof TraktorMitDieselMotor&& t.getErweiterung() instanceof TraktorErweiterungDrillmaschine){
				minSaeschareDiesel=min(t.erweiterungsAusmasz(),minSaeschareDiesel);
				maxSaeschareDiesel=max(t.erweiterungsAusmasz(),maxSaeschareDiesel);
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

		ObjectIterator it = liste.iterator();

		double sumFassungsvermoegenBiogas=0;
		double sumFassungsvermoegenDiesel=0;
		int counterBiogas=0;
		int counterDiesel=0;
		while(it.hasNext()){
			Traktor t=(Traktor)it.next();
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
}