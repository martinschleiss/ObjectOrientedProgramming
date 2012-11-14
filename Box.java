import java.util.Arrays;

public class Box extends BaseBox {

	private final char content;
	private final char frame;

	public Box(int width, int height, char content, char frame) throws IllegalArgumentException{

		super(width, height, content, frame);

		this.content = content;
		this.frame = frame;
	}

	/**
	 * returns the picture as String
	 */
	public String toString() {

		String output = "";
		int printWidth = (int) Math.round(super.getWidth() + 0.5);
		int printHeight = (int) Math.round(super.getHeight() + 0.5);
		char[] frameLine = new char[printWidth];
		char[] contentLine = new char [printWidth];

		Arrays.fill(frameLine, frame);
		contentLine[0] = contentLine[printWidth-1] = frame;
		Arrays.fill(contentLine, 1, (printWidth-1), content);

		for (int h = 0; h < printHeight; h++) {

			if ( h == 0 || h == (printHeight-1) ) {

				output += new String(frameLine);
				
				if ( h == 0) output += "\n";

			} else {

				output += new String(contentLine) + "\n";
			}
		}		
		return output;
	}
}
