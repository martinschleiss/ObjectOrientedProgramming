import java.util.ArrayList;
public class Shop {
	
	//TODO: HashMap zum Speichern der Androiden: Key -> Seriennummer, Value -> Android; => nur ein einziges if(null) erlaubt
	
	private ArrayList<Androide> liste = new ArrayList<Androide>();

	public void insert(Androide a) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
}
