import java.util.ArrayList;


public class AndroidFactory {

	public AndroidFactory() {
	
	}

	public void create(Androide a, ArrayList<Komponente> komponenten, Skin skin, Software software) {
		
		a.installKomponenten(komponenten);
		a.installSkin(skin);
		a.installSoftware(software);
	}
}
