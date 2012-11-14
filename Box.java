import java.util.Arrays;

public class Box implements Pict {

	private double width;		//Invariante: > 0
	private double height;		//Invariante: > 0
	private final char content;
	private final char frame;

	public Box(int width, int height, char content, char frame) throws IllegalArgumentException{

		if (frame == ' ') {
			throw new IllegalArgumentException("Kein Leerzeichen als Rahmen erlaubt");
		}

		this.width = width;
		this.height = height;
		this.content = content;
		this.frame = frame;
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
	//TODO: wenn du magst, das \n am schluss wieder hingeben, habs wegen der tests mal kurz weg
	public String toString() {

		String output = "";
		int printWidth = (int) Math.round(this.width + 0.5);
		int printHeight = (int) Math.round(this.height + 0.5);
		char[] frameLine = new char[printWidth];
		char[] contentLine = new char [printWidth];

		Arrays.fill(frameLine, frame);
		contentLine[0] = contentLine[printWidth-1] = frame;
		Arrays.fill(contentLine, 1, (printWidth-1), content);

		for (int h = 0; h < printHeight; h++) {

			if ( h == 0 || h == (printHeight-1) ) {

				output += new String(frameLine) + "\n";
				
				//if ( h == 0) output += "\n";

			} else {

				output += new String(contentLine) + "\n";
			}
		}		
		return output;
	}
}
