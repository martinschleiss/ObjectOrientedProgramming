import java.util.ArrayList;


public abstract class Androide {
	
	private static int serie = 0;
	private final int seriennummer;
	private ArrayList<Komponente> kit;
	private Skin skin;
	private Software software;
	
	public Androide() {
		seriennummer = serie++;
	}
	
	public final int getSeriennummer() {
		return seriennummer;
	}

}
