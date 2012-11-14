import java.util.Arrays;

public class DarkBox implements Pict {

	private double width;		//Invariante: > 0
	private double height;		//Invariante: > 0
	private char content;

	public DarkBox(int width, int height, char content) throws IllegalArgumentException{

		if (content == ' ') {
			throw new IllegalArgumentException("Kein Leerzeichen als Inhalt erlaubt");
		}

		this.width = width;
		this.height = height;
		this.content = content;
	}

	/**
	 * 0.1 <= factor <= 10.0; resize the picture	
	 */
	public void scale (double factor) {

		width *= factor;
		height *= factor;

	}

	/**
	 * returns the picture as String
	 */
	public String toString() {

		String output = "";
		int printWidth = (int) Math.round(this.width + 0.5);
		int printHeight = (int) Math.round(this.height + 0.5);
		char[] contentLine = new char [printWidth];
		Arrays.fill(contentLine, content);

		for (int h = 0; h < printHeight; h++) {

				output += new String(contentLine);
				
				if (h < printHeight -1 ) output += "\n";
		}		
		return output;
	}
}
