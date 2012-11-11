import java.util.Scanner;

public class FreeBox implements Pict {

	private String content;
	private final int width;
	private final int height;
	private double printHeight;
	private double printWidth;

	public FreeBox(String s) {
		
		Scanner scan = new Scanner(s);
		content = scan.nextLine();
		printWidth = content.length();
		printHeight = 1;
		
		while (scan.hasNextLine()) {

			content += scan.nextLine();
			printHeight++;
		}
		
		height = (int) printHeight;
		width = (int) printWidth;
	}

	/**
	 * Beim skalieren aendern sich nur die printDimensionen, die urspruenglichen
	 * Dimensionen bleiben erhalten.
	 */
	public void scale (double factor) {
		printHeight *= factor;
		printWidth *= factor;
	}

	public String toString() {

		String output = "";
		int printHeight = (int) Math.round(this.printHeight + .49);
		int printWidth = (int) Math.round(this.printWidth + .49); 
		
		for (int h = 0; h < printHeight; h++) {
	
			for (int w = 0; w < printWidth; w++) {
				
				output += content.charAt((h % height)*width+(w % width));
			}
			output += "\n";
		}
		
		return output;
	}
}