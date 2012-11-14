import java.util.Arrays;

public class DarkBox extends BaseBox {

	private char color;

	public DarkBox(int width, int height, char content) throws IllegalArgumentException{

		super(width, height, content, content);

		this.color = content;
	}

	public void setColor(char c) {
		
		this.color = c;
	}
	/**
	 * returns the picture as String
	 */
	public String toString() {

		String output = "";
		int printWidth = (int) Math.round(super.getWidth() + 0.5);
		int printHeight = (int) Math.round(super.getHeight() + 0.5);
		char[] contentLine = new char [printWidth];
		Arrays.fill(contentLine, color);

		for (int h = 0; h < printHeight; h++) {

				output += new String(contentLine);
				
				if (h < printHeight -1 ) output += "\n";
		}		
		return output;
	}
}
