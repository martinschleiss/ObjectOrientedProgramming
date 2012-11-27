import java.util.TreeMap;


public abstract class Androide {
	
	private static int serie = 0;
	private final int seriennummer;
	private Kit kit;
	private Skin skin;
	private Software software;
	private String protokoll;
	
	public Androide() {
		
		seriennummer = serie++;
		protokoll = "";
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
	
	public Kit kit() {
		
		return kit;
	}
	
	public void installSkin(Skin skin) {
		
		this.skin = skin;
		stage("Skin installiert: " + skin + "\n");
	}
	
	public void installSoftware(Software software) {
		
		this.software = software;
		stage("Software installiert: " + software + "\n");
	}
	
	public void installKit(Kit kit) {
		
		this.kit = kit;
		stage("Kit installiert: " + kit + "\n");
	}
		
	private void stage(String s) {
		
		protokoll += "\t" + s;
	}

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */
	public abstract String insertWennPasst(TreeMap<Integer, Androide> liste);
	
	public String toString() {
		
		return "Seriennummer: " + seriennummer + ", " + "Aufzeichnungen:\n" + protokoll;
	}	
}
