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

	public boolean execute() {

		if (super.checkConfirmations()) {

			admin.addEvent(rehearsal);
			return true;
			
		} else {
			
			return false;
		}
	}
}