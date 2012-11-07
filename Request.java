import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Rafael
 * @version 1.2
 */
public abstract class Request {

	private Administration admin;
	private HashMap<Member, Data> members;
	private String information;

	/**
	 * Vorbedingungen:
	 * @param admin				not null
	 * Nachbedingungen:			Alles notwendige initialisiert.
	 */
	public Request(Administration admin, String information) {

		this.admin = admin;
		this.information = information;
		members = new HashMap<Member,Data>();
	}

	/**
	 * #############################################################################################
	 * Innere Klasse zur gekapselten Speicherung von Zusage und Nachricht eines Mitglieds zu einem Request
	 */
	private class Data {

		private boolean confirmation;
		private String message;

		/**
		 * Nachbedingung: confirmation ist false
		 */
		public Data() {

			confirmation = false;
		}

		/**
		 * Vorbedingung: b ist true wenn Zusage und false wenn Absage
		 * Nachbedingung: b ist gespeichert
		 */
		public void setConfirmation(Boolean b) {

			this.confirmation = b;
		}

		/**
		 * Nachbedingung: s ist gespeichert
		 */
		public void setMessage(String s) {

			this.message = s;
		}
		
		/**
		 * Nachbedingung: Rueckgabe entspricht gespeichertem Wert in confirmation
		 */
		public Boolean getConfirmation() {

			return confirmation;
		}
		
		/**
		 * Nachbedingung: Rueckgabe entspricht gespeichertem Wert in message
		 */
		public String getMessage() {

			return message;
		}
	}
	/**
	 * #############################################################################################
	 */

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
	 * @param m		not null
	 * @param b		Zusage: true, Absage: false
	 * 
	 * Nachbedingungen: Zu- oder Absage des Mitglieds und seine Antwort sind gespeichert
	 */
	public void respond(Member m,  boolean confirmation, String message) {

		members.get(m).setConfirmation(confirmation);
		members.get(m).setMessage(message);
	}

	/**
	 * zu implementieren: Ausfuehren der Methode bewirkt z.B. Anlegen, Loeschen oder Verschieben von Events.
	 * 
	 * Vorbedingungen:	Die Methode broadcast(String furtherinfo) wurde bereits aufgerufen.
	 * 					Zwischen informieren der Mitglieder mit der Methode broadcast(String furtherinfo) und Aufruf von execute()
	 * 					ist genug Zeit vergangen, in der die Mitglieder abstimmen konnten.
	 * Nachbedingungen: retouriert true wenn alle Mitglieder positiv abgestimmt haben 
	 * 					und daher der Request ausgefuehrt wurde und false wenn nicht.
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

		for (Member m : members.keySet()) {

			output = output && members.get(m).getConfirmation();
		} 

		return output;
	}
	
	/**
	 * Nachbedingung: Retourniert gespeicherte Administration in Instanzvariable admin
	 */
	protected Administration getAdministration() {

		return admin;
	}

	/**
	 * Nachbedingung: Retourniert String-Repraesentation des Objekts
	 */
	public String toString() {

		String output = information + "\n";

		for (Member m : members.keySet()) {

			output += m + ";\t Zusage: " + members.get(m).getConfirmation() + "\t Nachricht: " + members.get(m).getMessage() + "\n";
		} 

		return output;
	}
}
