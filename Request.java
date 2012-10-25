import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstrakte Basisklasse bildet einen Grundrequest: Bietet Methode zum Versenden der Requestinformationen (z.B. Terminverschiebung)
 * an alle Mitglieder. Diese Mitglieder koennen dem Request mit einer Zu- oder Absage gemeinsam mit einer Textnachricht antworten. 
 * Die Zu- und Absagen werden ueberprueft. Haben alle Mitglieder zugestimmt, wird der Request ausgefuehrt. Fehlen Zusagen von Mitgliedern
 * oder haben diese negativ geantwortet, wird der Request nicht ausgefuehrt.
 * 
 * @author Rafael
 * @version 1.1
 */
 abstract class Request {

	protected Administration admin;
	private HashMap<Member,Boolean> currentConfirmations;
	private HashMap<Member, String> messages;
	private ArrayList<Member> members;
	private String information;
	
	public Request(Administration admin, String information) {

		this.admin = admin;
		this.information = information;
		currentConfirmations = new HashMap<Member, Boolean>();
		members = new ArrayList<Member>();
		messages = new HashMap<Member, String>();
	}

	/**
	 * zum Versenden von textueller Information an Bandmitglieder.
	 * @param furtherInfo	Textnachricht
	 */
	public void broadcast(String furtherInfo) {

		members = admin.getCurrentMembers();

		for (Member m : members) {

			m.inform(this, furtherInfo);
		}
	}

	/**
	 * Mitglieder antworten nach Erhalt einer Request-Nachricht durch die Methode broadcast() asynchron mit dem Aufruf dieser Methode
	 * @param m		zeigt, welches Mitglied geantwortet hat
	 * @param b		Zusage: true, Absage: false
	 * @param answer	Textnachricht
	 */
	public void respond(Member m,  boolean b, String answer) {
		
		currentConfirmations.put(m, b);
		messages.put(m,answer);
		
	}
	
	/**
	 * zu implementieren: Ausfuehren der Methode bewirkt z.B. Anlegen, Loeschen oder Verschieben von Events.
	 * @return	true wenn Request ausgefuehrt wurde und false wenn nicht.
	 */
	public abstract boolean execute();

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
