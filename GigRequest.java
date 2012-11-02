/**
 * Request dient als Anfrage zum Erstellen eines Gigs.
 * 
 * @author Rafael
 * @version 1.1
 */
public class GigRequest extends Request {

	private Gig gig;

	public GigRequest(Administration admin, Gig gig) {
		
		super(admin, "Auftrittsanfrage am: " + gig.getDate());
		this.gig = gig;
	}

	/**
	 * Vorbedingungen: 	@see Request#execute()
	 * Nachbedingungen:	@see Request#execute(), zusaetzlich speichert im Fall true 
	 * die Administration admin den angefragten Gig, bei false passierte nichts zusaetzlich.
	 */
	public boolean execute() {

		if (super.checkConfirmations()) {

			super.getAdministration().addEvent(gig);
			return true;
			
		} else {
			
			return false;
		}
	}
}