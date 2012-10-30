/**
 * @author Martin
 */

import java.text.DecimalFormat;
import java.util.Date;
public class Income extends Transaction {
	
	/**
	 * Vorbedingung: value muss ein positiver Wert sein.
	 * Nachbedingung: Klasse muss erfolgreich mit dem Wert value initialisiert sein
	 * @param value
	 */
	public Income(double value) {
		super(value);
	}
	
	/**
	 * Vorbedingung: value muss ein positiver Wert sein.
	 * 				 date ist das Datum an dem die Transaktion stattgefunden hat
	 * Nachbedingung: Klasse muss erfolgreich mit dem Wert value und date initialisiert sein
	 * @param value
	 * @param date
	 */
	public Income(double value, Date date) {
		super(value, date);
	}
	
	public double getValue() {
		return this.value;
	}
	
	public String toString() {
		return "+" + new DecimalFormat("#.##").format(value);
	}
}
