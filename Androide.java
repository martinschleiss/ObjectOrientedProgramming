import java.util.ArrayList;


public abstract class Androide {
	
	private static int serie = 0;
	private final int seriennummer;
	private int version;
	private ArrayList<Komponente> kit;
	private Skin skin;
	protected Software software;
	private String protokoll;
	
	public Androide() {
		
		seriennummer = serie++;
		version = 1;
		protokoll = "";
	}
	
	public final int seriennummer() {
		return seriennummer;
	}
	
	public void installSkin(Skin skin) {
		
		this.skin = skin;
	}
	
	public void installSoftware(Software software) {
		
		this.software = software;
		stage("Software installiert" + software);
	}
	
	public void installKomponenten(ArrayList<Komponente> k) {
		
		kit.addAll(k);
		String out = "Komponente installiert: ";
		
		for(Komponente i : k) {
			
			out += i + ", ";
		}
		
		stage(out);
	}
	
	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */
	
	public final void fuegeAndroideZuListeHinzu(ArrayList<Androide> liste) {
		liste.add(this);
	}
	
	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */
	
	public abstract void phaseEinsFuegeAndroidZuListeHinzu(ArrayList<Androide> liste);
	
	public void erstetzeKomponente(Komponente a, Komponente b) {
	
		kit.remove(a);
		kit.add(b);
	}
	private void stage(String s) {
		
		protokoll += "\n\t" + s;
	}
	
	public String toString() {
		return version + " " + protokoll + " " + skin;
	}
	
}
