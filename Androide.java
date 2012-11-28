import java.util.TreeMap;

/**
 * Ein Androide wird leer initialisiert. Software, Skin und Kit werden in der AndroidFactory mit dem Androiden zusammengefuehrt.
 */
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
	 * Installiert neue Skin. Diese Aenderung wird protokolliert.
	 * Methode soll nur zur Initialisierung des Androiden verwendet werden - fuer Aenderungen update-Methoden verwenden
	 * @param skin	!= null
	 */
	public void installSkin(Skin skin) {
		
		this.skin = skin;
		stage("Skin installiert: " + skin + "\n");
	}
	
	/**
	 * Updated Skin (ueberschreibt alte Skin) Diese Aenderung wird protokolliert.
	 * @param software	!= null
	 */
	public void updateSkin(Skin skin) {
		
		this.skin = skin;
		stage("Neue Skin installiert: " + skin + "\n");
	}
	
	/**
	 * Installiert neue Software. Diese Aenderung wird protokolliert.
	 * Methode soll nur zur Initialisierung des Androiden verwendet werden - fuer Aenderungen update-Methoden verwenden
	 * @param software	!= null
	 */
	public void installSoftware(Software software) {
		
		this.software = software;
		stage("Software installiert: " + software + "\n");
	}
	/**
	 * Updated Software (ueberschreibt alte Software) Diese Aenderung wird protokolliert.
	 * @param software	!= null
	 */
	public void updateSoftware(Software software) {
		
		this.software = software;
		stage("Neue Software installiert: " + software + "\n");
	}
	
	/**
	 * Installiert neues Kit. Diese Aenderung wird protokolliert.
	 * Methode soll nur zur Initialisierung des Androiden verwendet werden - fuer Aenderungen update-Methoden verwenden
	 * @param kit	!= null
	 */
	public void installKit(Kit kit) {
		
		this.kit = kit;
		stage("Kit installiert: " + kit + "\n");
	}
	
	/**
	 * Updated Kit (ueberschreibt altes Kit) Diese Aenderung wird protokolliert.
	 * @param kit	!= null
	 */
	public void updateKit(Kit kit) {
		
		this.kit = kit;
		stage("Neues Kit installiert: " + kit + "\n");
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
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Seriennummer: " + seriennummer + "\nAufzeichnungen:\n" + protokoll;
	}	
}