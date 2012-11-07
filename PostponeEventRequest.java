import java.util.Date;


/**
 * Request dient als Anfrage zum Verschieben eines Events.
 * 
 * @author Rafael
 * @version 1.0
 */
public class PostponeEventRequest extends Request{

	private Event event;
	
	/**
	 * Invariante: newDate ist ein Datum in der Zukunft, der Termin kann nicht in die Vergangenheit verschoben werden.
	 */
	private Date newDate;

	/**
	 * Vorbedingungen:
	 * @param admin		not null
	 * @param event		not null
	 * @param newDate	not null, muss Datum in der Zukunft sein
	 * 
	 * Nachbedingungen:
	 * Instanz wurde korrekt initialisiert
	 */
	public PostponeEventRequest(Administration admin, Event event, Date newDate) {
		
		super(admin, "Terminverschiebung am: " + event);
		this.event = event;
		this.newDate = newDate;
	}

	/**
	 * Vorbedingungen: 	@see Request#execute()
	 * Nachbedingungen:	@see Request#execute(), zusaetzlich wurde im Fall true 
	 * das Datum des Events auf den neuen Wert gesetzt, bei false passierte nichts zusaetzlich.
	 */
	public boolean execute() {

		if (super.checkConfirmations()) {

			event.update(newDate);
			return true;
			
		} else {
			
			return false;
		}
	}
}
