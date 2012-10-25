/**
 * Request dient als Anfrage zum Loeschen eines Events
 * 
 * @author Rafael
 * @version 1.1
 */

public class CancelEventRequest extends Request{

	Event event;

	public CancelEventRequest(Administration admin, Event event) {
		
		super(admin, "Absage von: " + event + " wegen Terminkollision");
		this.event = event;
	}

	public boolean execute() {

		if (super.checkConfirmations()) {

			admin.deleteEvent(event);
			return true;
			
		} else {
			
			return false;
		}
	}
}
