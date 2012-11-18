import java.util.Scanner;


public class Description implements Shorter {

	private String textual; // !=null
	private Scanner scan;

	public Description(String textual) {

		this.textual = textual;
	}

	/**
	 * muss noch geeandert werden, weil casting nicht erlaubt ist laut Angabe
	 */
	public boolean shorter(Shorter other) {

		Boolean check=false;

		if (this.getClass() == other.getClass()){
			Description dp=(Description) other;
			check= this.textual.length()<dp.textual.length();

		}
		return check;
	}

	/**
	 * 
	 * @return anzahl der Zeilen
	 */
	public int countLines(){
		
		scan = new Scanner (textual);
		int count = 0;
		while(scan.hasNext()) {
			scan.nextLine();
			count++;
		}
		return count;

	}

	public String toString() {

		return textual;
	}
}