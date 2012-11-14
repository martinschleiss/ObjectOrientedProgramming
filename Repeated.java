import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Repeated<P> implements Pict{

	private ArrayList<P> list;
	private int width;		// > 0
	private int height;	// > 0
	private double scaleFactor = 1; // > 0
	private int boxHeight;	// > 0
	private int boxWidth;	// > 0

	/**
	 * (height*width) == list.size()
	 */
	public Repeated(ArrayList<P> list, int height, int width) throws InputMismatchException {

		if ( height*width != list.size() ) {

			throw new InputMismatchException("Groesse stimmt nicht mit Anzahl der Elemente ueberein");
		}

		this.height = height;
		this.width = width;
		this.list = list;
		this.boxHeight = getMaximumBoxHeight(this.list);
		this.boxWidth = getMaximumBoxWidth(this.list);
	}

	/**
	 * 0.1 <= factor <= 10.0; resize the picture	
	 */
	public void scale(double factor) {
		this.scaleFactor *= factor;
	}

	private int getMaximumBoxHeight(ArrayList<?> l) {
		int maximum = 0;

		for(Object elem : l) {
			int temp = 0;
			String s = elem.toString();
			Scanner scan = new Scanner(s);
			while(scan.hasNext()) {
				scan.nextLine();
				temp++;
			}

			if(temp > maximum) {
				maximum = temp;
			}
		}

		return maximum;
	}

	private int getMaximumBoxWidth(ArrayList<?> l) {
		int maximum = 0;

		for(Object elem : l) {
			String s = elem.toString();
			Scanner scan = new Scanner(s);
			String current = "";
			while(scan.hasNext()) {
				current = scan.nextLine();
				if(current.length() > maximum) {
					maximum = current.length();
				}
			}			
		}

		return maximum;
	}

	private String getStringForPictAtLine(Object p, int line) {
		String value = "";
		Scanner scan = new Scanner (p.toString());
		int count = 0;
		while(scan.hasNext()) {
			value = scan.nextLine();
			if(line == count) {
				break;
			}
			count++;
		}

		if(value.equals("")) {
			for(int i = 0; i < boxWidth; i++) {
				value += " ";
			}
		} else {
			while(value.length() < boxWidth) {
				value += " ";
			}
		}

		return value;
	}
	
    // returns the picture as String
	
	
	//TODO Methode funktioniert noch nicht fuer Freebox, liefert ewig lange wurst, zeilen werden wiederholt ausgegeben.
	//und liefert boxes doppelt untereinander
	public String toString() {
		String s = "";

		for(int h = 0; h < height * scaleFactor; h++) {		

			for(int bh = 0; bh < boxHeight ; bh++ ) {

				for(int box = 0; box < width * scaleFactor; box++) {
					
					s += getStringForPictAtLine(list.get(h % height * width + box % width), bh);
					
					if(box == width * scaleFactor - 1) {

						s += "\n";

					}
				}		

			}							
		}

		return s;
	}
}
