import java.util.TreeMap;


public abstract class Androide {
	
	private static int serie = 0; //= fortlaufende Seriennummer 
	private final int seriennummer;
	private Kit kit;
	private Skin skin;
	private Software software;
	private String protokoll;
	
	public Androide() {
		serie++;
		seriennummer = serie;
		protokoll = "";
	}
	
	/**
	 * Getter-Methode
	 * @return Seriennummer des Androiden
	 */
	public final int seriennummer() {
		return seriennummer;
	}
	
	/**
	 * Getter-Methode
	 * @return Aktuell installierte Software des Androiden
	 */
	public Software software() {
		
		return software;
	}
	
	/**
	 * Getter-Methode
	 * @return Aktuelle Skin des Androiden
	 */
	public Skin skin() {
		
		return skin;
	}
	
	/**
	 * Getter-Methode
	 * @return Aktuelles Kit des Androiden
	 */
	public Kit kit() {
		
		return kit;
	}
	
	/**
	 * Installiert neue Skin (ersetzt alte, falls vorhanden). Diese Aenderung wird protokolliert.
	 * @param skin	!= null
	 */
	public void installSkin(Skin skin) {
		
		this.skin = skin;
		stage("Skin installiert: " + skin + "\n");
	}
	
	/**
	 * Installiert neue Software (ueberschreibt alte, falls vorhanden) Diese Aenderung wird protokolliert.
	 * @param software	!= null
	 */
	public void installSoftware(Software software) {
		
		this.software = software;
		stage("Software installiert: " + software + "\n");
	}
	
	/**
	 * Installiert neues Kit (ersetzt altes, falls vorhanden) Diese Aenderung wird protokolliert.
	 * @param kit	!= null
	 */
	public void installKit(Kit kit) {
		
		this.kit = kit;
		stage("Kit installiert: " + kit + "\n");
	}
		
	private void stage(String s) {

		protokoll += "\t" + s;
	}

	/**
	 * Vorbedingung: liste != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String insertWennGueltig(TreeMap<Integer,Androide> liste);
	
	public String toString() {
		
		return "Seriennummer: " + seriennummer + ", " + "Aufzeichnungen:\n" + protokoll;
	}	
}