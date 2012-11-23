import java.util.ArrayList;


public abstract class Androide {
	
	private static int serie = 0;
	private final int seriennummer;
	private int version;
	private ArrayList<Komponente> kit;
	private Skin skin;
	private Software software;
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
	
	public void erstetzeKomponente(Komponente a, Komponente b) {
	
		kit.remove(a);
		kit.add(b);
	}
	private void stage(String s) {
		
		protokoll += "\n\t" + s;
	}
}
