import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Repeated<P> implements Pict{

	private	ArrayList<?> list;
	private int width;
	private int height;
	private double scaleFactor = 1;
	private int boxHeight;
	private int boxWidth;

	/**
	 * (height*width) == list.size();
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
	
	public String toString() {
		String s = "";
		
		for(int h = 0; h < height * scaleFactor; h++) {		
			
			for(int w = 0; w < width * scaleFactor; w++) {	
				
				for(int bh = 0; bh < boxHeight; bh++ ) {
					
					for(int box = 0; box < width * scaleFactor; box++) {
						s += getStringForPictAtLine(list.get(box % width + h % height), bh);
					}		
					if(!(h == height - 1 && w == width - 1 && bh == boxHeight -1 )) {
						s += "\n";
					}
				}				
			}			
		}
		
		return s;
	}
}
