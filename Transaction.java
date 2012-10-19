import java.text.DecimalFormat;
import java.util.Date;
abstract public class Transaction {
	
	protected double value;
	protected Event ev;
	protected Date date;
	
	public Transaction(double value) {
		this.value = value;
	}
	
	public Transaction(double value, Date date) {
		this(value);
		this.date = date;
	}
	
	abstract public double getValue();
	
	public Event getCorrespondingEvent() {
		return this.ev;
	}
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
