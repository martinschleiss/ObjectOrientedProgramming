import java.util.Arrays;

public class DarkBox extends Box { //Vererbung kann sich noch aendern, siehe Problem
	
	private char color;
	
	public DarkBox(double width, double height, char color) {
		
		super(width, height, color, color);
		this.color = color;
	}

	public void setColor(char c) {
		
		this.color = c;
	}
	
public String toString() {
		
		String output = "";
		int printWidth = (int) Math.round(getWidth() + 0.49);
		int printHeight = (int) Math.round(getHeight() + 0.49);
		char[] contentLine = new char [printWidth];

		contentLine[0] = contentLine[printWidth-1] = color;
		Arrays.fill(contentLine, 1, (printWidth-1), color);
		
		for (int h = 0; h < printHeight; h++) {
			
			output += new String(contentLine);
			
			output += "\n";
		}		
		return output;
	}
	
}