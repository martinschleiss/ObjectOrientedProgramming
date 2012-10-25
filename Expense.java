import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author Martin
 */
public class Expense extends Transaction {
	
	public Expense (double value) {
		super(value);
	}
	
	public Expense(double value, Date date) {
		super(value, date);
	}
	
	public double getValue() {
		return -this.value;
	}
	
	public String toString() {
		return "-" + new DecimalFormat("#.##").format(value);
	}

}
