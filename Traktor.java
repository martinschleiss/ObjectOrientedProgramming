
public abstract class Traktor {
	
	private static int aktuelleTraktorAnzahl = 0;
	private final int nummer;
	private int betriebsstunden;
	private TraktorErweiterung erweiterung;
	
	public Traktor() {
		nummer = aktuelleTraktorAnzahl++;
	}
	public TraktorErweiterung getErweiterung(){
		return erweiterung;
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
	
	
	public Double erweiterungsAusmasz() {
		return erweiterung.erweiterungsAusmasz();
	}

	
	public abstract double bisherigerVerbrauch();
	public abstract void erhoeheVerbrauch(double verbrauch);
	
	public String toString() {
		
		return "Nr: " + nummer + ", Betriebsstunden: " + betriebsstunden+ " Erweiterung: "+erweiterung+" "+erweiterungsAusmasz();
	}
}
