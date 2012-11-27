/**
 * Dient der Zusammenstellung eines Androiden
 */

public class AndroidFactory {

	public AndroidFactory() {
	
	}

	/**
	 * Ruft die fuer den Zusammenbau der Bauteile notwendigen Methoden in der Klasse Androide auf
	 * @param a		Vorbedingung: not null
	 */
	public void create(Androide a, Kit kit, Skin skin, Software software) {
		
		a.installKit(kit);
		a.installSkin(skin);
		a.installSoftware(software);
	}
}
