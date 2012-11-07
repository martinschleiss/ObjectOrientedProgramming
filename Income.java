/**
 * @author Martin
 */

import java.text.DecimalFormat;
import java.util.Date;
public class Income extends Transaction {
	
	/**
	 * Vorbedingung:
	 * @param value		> 0
	 * 
	 * Nachbedingung: Klasse muss erfolgreich mit dem Wert value initialisiert sein
	 * @param value
	 */
	public Income(double value) {
		super(value);
	}
	
	/**
	 * Vorbedingung:
	 * @param value		> 0
	 * @param date		not null
	 * Nachbedingung: Klasse muss erfolgreich mit dem Wert value und date initialisiert sein
	 */
	public Income(double value, Date date) {
		super(value, date);
	}
	
	/**
	 * Nachbedingung:
	 * @return gespeicherten Betrag
	 */
	public double getValue() {
		return super.getValue();
	}
	
	/**
	 * Nachbedingung:
	 * @return String-Repraesentation des Objekts
	 */
	public String toString() {
		return "+" + new DecimalFormat("#.##").format(this.getValue());
	}
}
