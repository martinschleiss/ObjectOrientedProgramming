/**
 * Request dient als Anfrage zum Erstellen einer Probe.
 * 
 * @author Rafael
 * @version 1.0
 */

public class RehearsalRequest extends Request {
	
	Rehearsal rehearsal;

	public RehearsalRequest(Administration admin, Rehearsal rehearsal) {
		
		super(admin, "Probeanfrage am: " + rehearsal.getDate());
		this.rehearsal = rehearsal;
	}

	/**
	 * Vorbedingungen: 	@see Request#execute()
	 * Nachbedingungen:	@see Request#execute(), zusaetzlich speichert im Fall true 
	 * die Administration admin die angefragte Probe, bei false passierte nichts zusaetzlich.
	 */
	public boolean execute() {

		if (super.checkConfirmations()) {

			super.getAdmin().addEvent(rehearsal);
			return true;
			
		} else {
			
			return false;
		}
	}
}