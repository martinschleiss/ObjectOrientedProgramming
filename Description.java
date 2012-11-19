import java.util.Scanner;


public class Description implements Shorter {

	private String textual; // !=null
	private Scanner scan;

	public Description(String textual) {

		this.textual = textual;
	}

	/**
	 * weil casting nicht erlaubt, wird diese Methode nie benoetigt 
	 * ..fraglich, denn wieso ist dann Description ein Untertyp von Shorter?
	 */
	public boolean shorter(Shorter other) {
		return false;
	}
	
	/**
	 * @param other Objekt zum vergleichen, Theoretisch vom Typ ElapsedTime, CompositeTime oder MeanElapsedTime moeglich
	 * @return gibt true zuruek, wenn die laenge des Textes in .this kleiner als der text in other ist
	 */
	public boolean shorter(Description other) {

		return this.textual.length()<other.textual.length();

	}
	/**
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