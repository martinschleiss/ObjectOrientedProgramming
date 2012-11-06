import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Rafael
 * @version 1.1
 */
public abstract class Request {

	private Administration admin;
	private HashMap<Member, Data> members;
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
		members = new HashMap<Member,Data>();
	}

	private class Data {
		
		private Boolean confirmation;
		private String message;
		
		public void setConfirmation(Boolean b) {
			
			this.confirmation = b;
		}
		
		public void setMessage(String s) {
			
			this.message = s;
		}
		public Boolean getConfirmation() {
			
			return confirmation;
		}
		public String getMessage() {
			
			return message;
		}
	}

	/**
	 * Vorbedingungen: 		ArrayList members im Objekt admin enthaelt alle Members, die man informieren moechte.
	 * @param furtherInfo	beinhaltet nur zusaetzliche Information, keine Basisinformation wie z.B. das neue Datum des verschobenen Termins
	 *
	 * Nachbedingungen: 	Derzeitige Mitglieder von admin wurden informiert und ihnen wurde die Zusatzinformation uebergeben.
	 */
	public void broadcast(String furtherInfo) {

		ArrayList<Member> tmp = admin.getCurrentMembers();

		for (Member m : tmp) {

			m.inform(this, furtherInfo);
			members.put(m, new Data());
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
	public void respond(Member m,  boolean confirmation, String message) {

		members.get(m).setConfirmation(confirmation);
		members.get(m).setMessage(message);
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
	protected Administration getAdmin() {

		return admin;
	}

	public String toString() {

		String output = information + "\n";

		for (Member m : members.keySet()) {

			output += m + ";\t Zusage: " + members.get(m).getConfirmation() + "\t Nachricht: " + members.get(m).getMessage() + "\n";
		} 

		return output;
	}
}
