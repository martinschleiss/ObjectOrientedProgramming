/**
 * @author Martin
 */

import java.text.DecimalFormat;
import java.util.Date;
public class Income extends Transaction {

	public Income(double value) {
		super(value);
	}
	
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
