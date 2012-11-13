import java.util.Arrays;

public class DarkBox extends Box {

	private char color;

	public DarkBox(int width, int height, char color) {

		super(width, height, color, color);

		this.color = color;
	}

	/**
	 * Die Farbe (das Zeichen) ist veraenderbar
	 * @param c		kein Leerzeichen
	 */
	public void setColor(char c) throws IllegalArgumentException{

		if (c == ' ') {

			throw new IllegalArgumentException("Kein Leerzeichen als Inhalt erlaubt");
		}

		this.color = c;
	}
	/**
	 * returns the picture as String 
	 */
	public String toString() {

		String output = "";
		int printWidth = (int) Math.round(getWidth() + 0.49);
		int printHeight = (int) Math.round(getHeight() + 0.49);
		char[] printLine = new char [printWidth];

		printLine[0] = printLine[printWidth-1] = color;
		Arrays.fill(printLine, 1, (printWidth-1), color);

		for (int h = 0; h < printHeight; h++) {

			output += new String(printLine) + "\n";

		}		
		return output;
	}

}