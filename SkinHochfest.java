import java.util.HashMap;



public class SkinHochfest extends Skin {

	public SkinHochfest(Androide a) {
		super(a);
	}

	/**
	 * Vorbedingung: liste und b (Bauarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonBauarbeiterInstalliert(Bauarbeiter b,HashMap<Integer,Androide> liste){
		b.installSkin(this);
		liste.put(b.seriennummer(), b);
		
	}
	/**
	 * Vorbedingung: liste und g (Gesellschafter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonGesellschafterInstalliert(Gesellschafter g,HashMap<Integer,Androide> liste){}
	
	/**
	 * Vorbedingung: liste und h (Hilfskraft) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonHilfskraftInstalliert(Hilfskraft h,HashMap<Integer,Androide> liste){}
	
	/**
	 * Vorbedingung: liste und k (Kaempfer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param k : der Kaempfer zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonKaempferInstalliert(Kaempfer k,HashMap<Integer,Androide> liste){}
	
	/**
	 * Vorbedingung: liste und l (Leibwaechter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param l : der Leibwaechter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonLeibwaechterInstalliert(Leibwaechter l,HashMap<Integer,Androide> liste){}
	
	/**
	 * Vorbedingung: liste und o (Objektbewacher) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param o : der Objektbewacher zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonObjektbewacherInstalliert(Objektbewacher o,HashMap<Integer,Androide> liste){}
	
	/**
	 * Vorbedingung: liste und s (Servicetechniker) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : der Servicetechniker zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonServicetechnikerInstalliert(Servicetechniker s,HashMap<Integer,Androide> liste){
		s.installSkin(this);
		liste.put(s.seriennummer(), s);
	}
	
	/**
	 * Vorbedingung: liste und t (Transportarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param t : der Transportarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonTransportarbeiterInstalliert(Transportarbeiter t,HashMap<Integer,Androide> liste){
		t.installSkin(this);
		liste.put(t.seriennummer(), t);
	}

}
