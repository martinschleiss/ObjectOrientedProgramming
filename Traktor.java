
public abstract class Traktor {
	
	private static int aktuelleTraktorAnzahl = 0;
	private final int nummer;
	private int betriebsstunden;
	private TraktorErweiterung erweiterung;
	
	public Traktor() {
		nummer = aktuelleTraktorAnzahl++;
	}
	
	public int serienNummer() {
		return nummer;
	}
	
	public void erhoeheBetriebsstundenUm(int stunden) {
		betriebsstunden += stunden;
	}
	
	public int betriebsstunden() {
		return betriebsstunden;
	}
	
	public void setzeTraktorErweiterung(TraktorErweiterung e) {
		erweiterung = e;
	}
	
	public abstract double bisherigerVerbrauch();
	public abstract void erhoeheVerbrauch(double verbrauch);
	
	public String toString() {
		
		return "Traktor, Nr: " + nummer + ", Betriebsstunden: " + betriebsstunden;
	}
}
