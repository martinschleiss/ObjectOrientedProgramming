import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Rafael
 * @version 1.1
 */
 abstract class Request {

	protected Administration admin;
	private HashMap<Member,Boolean> currentConfirmations;
	private HashMap<Member, String> messages;
	private ArrayList<Member> members;
	private String information;
	
	/**
	 * Vorbedingungen:
	 * @param admin				Administration, die dieses Objekt erstellt hat
	 * @param information		wird von der Unterklasse praezisiert
	 * Nachbedingungen:			Alles notwendige initialisiert.
	 */
	public Request(Administration admin, String information) {

		this.admin = admin;
		this.information = information;
		currentConfirmations = new HashMap<Member, Boolean>();
		members = new ArrayList<Member>();
		messages = new HashMap<Member, String>();
	}

	/**
	 * Vorbedingungen: 		ArrayList members im Objekt admin enthaelt alle Members, die man informieren moechte.
	 * @param furtherInfo	beinhaltet nur zusaetzliche Information, keine Basisinformation wie z.B. das neue Datum des verschobenen Termins
	 *
	 * Nachbedingungen: 	Derzeitige Mitglieder von admin wurden informiert und ihnen wurde die Zusatzinformation uebergeben.
	 */
	public void broadcast(String furtherInfo) {

		members = admin.getCurrentMembers();

		for (Member m : members) {

			m.inform(this, furtherInfo);
		}
	}

	/**
	 * Vorbedingungen: 
	 * @param m		Mitglied das geantwortet hat
	 * @param b		Zusage: true, Absage: false
	 * @param answer	Textnachricht
	 * 
	 * Nachbedingungen: Zu- oder Absage des Mitglieds und seine Antwort sind gespeichert
	 */
	public void respond(Member m,  boolean b, String answer) {
		
		currentConfirmations.put(m, b);
		messages.put(m,answer);
		
	}
	
	/**
	 * zu implementieren: Ausfuehren der Methode bewirkt z.B. Anlegen, Loeschen oder Verschieben von Events.
	 * Vorbedingungen:	Die Methode broadcast(String furtherinfo) wurde bereits aufgerufen.
	 * 					Zwischen informieren der Mitglieder mit der Methode broadcast(String furtherinfo) und Aufruf von execute()
	 * 					ist genug Zeit vergangen, in der die Mitglieder abstimmen konnten.
	 * 
	 * @return	true wenn alle Mitglieder positiv abgestimmt haben und daher der Request ausgefuehrt wurde und false wenn nicht.
	 */
	public abstract boolean execute();

	/**
	 * Vorbedingungen: 	Die Methode broadcast(String furtherinfo) wurde bereits aufgerufen.
	 * 					Zwischen informieren der Mitglieder mit der Methode broadcast(String furtherinfo) und Aufruf von execute()
	 * 					ist genug Zeit vergangen, in der die Mitglieder abstimmen konnten.
	 * @return	true wenn alle Mitglieder einstimmig positiv abgestimmt haben 
	 * 			und false sobald mindestens 1 Mitglied nicht oder dagegen abgestimmt hat.
	 */
	protected boolean checkConfirmations() {		

		boolean output = true;
		
		if ( currentConfirmations.size() == members.size() ) {

			for (Member m : currentConfirmations.keySet()) {

				output = output && currentConfirmations.get(m);
			}

			return output;

		} else {

			return false;
		}	
	}
	
	public String toString() {
		
		String output = information + "\n";
		
		for (Member m : messages.keySet()) {

			output += m + ";\t Zusage: " + currentConfirmations.get(m) + "\t Nachricht: " + messages.get(m) + "\n";
		} 
		
		return output;
	}
}
