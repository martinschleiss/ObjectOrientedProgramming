/**
 * Dient der Zusammenstellung eines Androiden, wird leer initialisiert
 * und kann beliebig viele Androiden mit der create-Methode konstruieren.
 */

public class AndroidFactory {

	public AndroidFactory() {
	
	}

	/**
	 * Ruft die fuer den Zusammenbau der Bauteile notwendigen Methoden in der Klasse Androide auf
	 * Vorbedingungen:
	 * @param a				!= null
	 * @param kit			!= null
	 * @param skin			!= null
	 * @param software		!= null
	 * Nachbedingung:
	 * Androide wurde vollstaendig initialisiert
	 */
	public void create(Androide a, Kit kit, Skin skin, Software software) {
		
		a.installKit(kit);
		a.installSkin(skin);
		a.installSoftware(software);
	}
}
