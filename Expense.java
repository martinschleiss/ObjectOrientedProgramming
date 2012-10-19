import java.util.Date;
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

}
