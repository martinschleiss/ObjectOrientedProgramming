import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;;

public class Scaled<T extends Pict> implements Pict {

	private int height;
	private int width;
	private ArrayList<? extends Pict> list;
	private int boxWidth;
	private int boxHeight;

	public Scaled(ArrayList<? extends Pict> list, int height, int width) throws InputMismatchException {

		if (height * width != list.size()) {

			throw new InputMismatchException("Groesse stimmt nicht mit Anzahl der Elemente ueberein");
		}

		this.height = height;
		this.width = width;
		this.list = list;
		this.boxHeight = getMaximumBoxHeight(list);
		this.boxWidth = getMaximumBoxWidth(list);
		
	}

	private int getMaximumBoxHeight(ArrayList<? extends Pict> l) {
		int maximum = 0;

		for(Pict elem : l) {
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

	private int getMaximumBoxWidth(ArrayList<? extends Pict> l) {
		int maximum = 0;

		for(Pict elem : l) {
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

	/**
	 * 0.1 <= factor <= 10.0; resize the picture	
	 */
	public void scale(double factor) {

		for(Pict elem : list) {
			elem.scale(factor);
		}
		
		this.boxHeight = getMaximumBoxHeight(list);
		this.boxWidth = getMaximumBoxWidth(list);

	}

	private String getStringForPictAtLine(Pict p, int line) {
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

	/**
	 * returns the picture as String
	 */
	public String toString() {
		String s = "";

		for(int h = 0; h < height; h++) {		

			for(int bh = 0; bh < boxHeight; bh++ ) {

				for(int box = 0; box < width; box++) {
					s += getStringForPictAtLine(list.get(h * width + box), bh);
					if(box == width - 1) {
						s += "\n";
					}
				}
			}						
		}

		return s;
	}
}