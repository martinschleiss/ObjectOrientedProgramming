import java.util.ArrayList;
public class Shop {
	
	//TODO: HashMap zum Speichern der Androiden: Key -> Seriennummer, Value -> Android; => nur ein einziges if(null) erlaubt
	
	private ArrayList<Androide> liste = new ArrayList<Androide>();

	
	public String insert(Androide a) { //retourniert Fehlercode bzw Erfolgsmeldung
		a.insertWennVerordnungErfuellt(liste);
		//a.fuegeAndroideZuListeHinzu(liste);
	}
}
