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

	public boolean execute() {

		if (super.checkConfirmations()) {

			admin.addEvent(gig);
			return true;
			
		} else {
			
			return false;
		}
	}
}