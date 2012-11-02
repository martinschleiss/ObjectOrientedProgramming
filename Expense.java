import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author Martin
 */
public class Expense extends Transaction {
	
	/**
	 * Vorbedingung: value muss ein positiver Wert sein.
	 * Nachbedingung: Klasse muss erfolgreich mit dem Wert value initialisiert sein
	 * @param value
	 */
	public Expense (double value) {
		super(value);
	}
	
	/**
	 * Vorbedingung: value muss ein positiver Wert sein.
	 * 				 date ist das Datum an dem die Transaktion stattgefunden hat
	 * Nachbedingung: Klasse muss erfolgreich mit dem Wert value und date initialisiert sein
	 * @param value
	 * @param date
	 */
	public Expense(double value, Date date) {
		super(value, date);
	}
	
	public double getValue() {
		return -super.getValue();
	}
	
	public String toString() {
		return new DecimalFormat("#.##").format(this.getValue());
	}

}
