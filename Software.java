import java.util.TreeMap;

/**
 * Eine Instanz dieser Software ist Bestandteil genau eines Androiden.
 */
public abstract class Software {

	/**
	 * = Seriennummer des Androiden, der mit dieser Software ausgestattet ist.
	 */
	private final int codierung;
	private Sicherheitsstufe s;
	
	public Software(Androide a, Sicherheitsstufe s) {
		
		this.s = s;
		codierung = a.seriennummer();
	}
	
	public Sicherheitsstufe sicherheitsstufe() {
		
		return s;
	}
	
	/**
	 * Vorbedingung: liste und b (Bauarbeiter) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und g (Gesellschafter) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und h (Hilfskraft) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und k (Kaemfper) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und l (Leibwaechter) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und o (Objektbewacher) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und s (Servicetechniker) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und t (Transportarbeiter) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer,Androide> liste);
}
