import java.util.Date;


/**
 * Request dient als Anfrage zum Verschieben eines Events.
 * 
 * @author Rafael
 * @version 1.0
 */
public class PostponeEventRequest extends Request{

	private Event event;
	private Date newDate;

	public PostponeEventRequest(Administration admin, Event event, Date newDate) {
		
		super(admin, "Terminverschiebung am: " + event);
		this.event = event;
		this.newDate = newDate;
	}

	public boolean execute() {

		if (super.checkConfirmations()) {

			event.update(newDate);
			return true;
			
		} else {
			
			return false;
		}
	}
}
