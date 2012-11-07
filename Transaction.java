import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author Martin
 */
public abstract class Transaction {
	
	private double value;
	private Event ev;
	private Date date;
	
	/**
	 * Vorbedingung: value muss ein positiver Wert sein
	 * Nachbedingung: die Klasse muss erfolgreich mit dem Wert value in this.value initialisiert sein
	 * @param value
	 */	
	public Transaction(double value) {
		this.value = value;
	}
	
	/**
	 * Vorbedingung: value muss ein positiver Wert sein, date ist das Datum an dem die Transaktion stattgefunden hat
	 * Nachbedingung: die Klasse muss erfolgreich mit den Werten value und date in this.value und this.date initialisiert sein
	 * @param value
	 * @param date
	 */
	public Transaction(double value, Date date) {
		this(value);
		this.date = date;
	}
	
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Nachbedingung: Liefert das Event mit dem die Transaktion assoziiert ist. Es kann sein, dass die Transaktion
	 * kein korrespondiertes Event besitzt. In diesem Fall wird NULL zurueckgegeben.
	 * @return
	 */
	public Event getCorrespondingEvent() {
		return this.ev;
	}
	
	/**
	 * Vorbedinung: ev muss vom Typ Event sein. 
	 * Nachbedingung: das Event mit dem die Transaktion assoziiert werden soll, muss in this.ev gespeichert sein
	 * @param ev
	 */
	public void setCorrespondingEvent(Event ev) {
		this.ev = ev;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return new DecimalFormat("#.##").format(value);
	}
}
