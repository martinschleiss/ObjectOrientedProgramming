import java.util.ArrayList;
import java.util.TreeMap;


public abstract class Androide {
	
	private static int serie = 0;
	private final int seriennummer;
	private ArrayList<Komponente> kit;
	private Skin skin;
	private Software software;
	private String protokoll;
	
	public Androide() {
		serie++;
		seriennummer = serie;
		protokoll = "";
		kit = new ArrayList<Komponente>();
	}
	
	public final int seriennummer() {
		return seriennummer;
	}
	
	public Software software() {
		
		return software;
	}
	
	public Skin skin() {
		
		return skin;
	}
	
	public void installSkin(Skin skin) {
		
		this.skin = skin;
		stage("Skin installiert: " + skin + "\n");
	}
	
	public void installSoftware(Software software) {
		
		this.software = software;
		stage("Software installiert: " + software + "\n");
	}
	
	public void installKomponenten(ArrayList<Komponente> k) {
		
		kit.addAll(k);
		String out = "Komponente(n) installiert: ";
		
		for(Komponente i : k) {
			
			out += i + ", ";
		}
		
		stage(out + "\n");
	}
	
	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */
	public final void fuegeAndroideZuListeHinzu(TreeMap<Integer,Androide> liste) {
	
		liste.put(seriennummer,this);
	}
	
	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */
	
	public abstract String phaseEinsFuegeAndroidZuListeHinzu(TreeMap<Integer,Androide> liste);
	//public abstract void insertWennVerordnungErfuellt(TreeMap<Integer,Androide> liste);
	
	
	public void erstetzeKomponente(Komponente a, Komponente b) {
	
		kit.remove(a);
		kit.add(b);
	}
	private void stage(String s) {
		
		protokoll += "\t" + s;
	}
	
	public String toString() {
		
		return "Androide, Seriennummer: " + seriennummer + ", " + "Aufzeichnungen:\n" + protokoll;
	}	
}
