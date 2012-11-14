import java.util.ArrayList;
import java.util.Scanner;

public class FreeBox extends Repeated<Character> {
	
	public FreeBox(String s) {
		
		super(getCharacterArray(s), getHeightOfContent(s), getWidthOfContent(s));
		System.out.println(getHeightOfContent(s) + " + " + getWidthOfContent(s));
	}
	
	private static int getHeightOfContent(String s) {
		Scanner scan = new Scanner(s);
		int h = 0;
		while (scan.hasNextLine()) {
			
			scan.nextLine();
			h++;
		}
		
		return h;
	}
	
	private static int getWidthOfContent(String s) {
		Scanner scan = new Scanner(s);
		String current = scan.nextLine();

		return current.length();
	}
	
	
	private static ArrayList<Character> getCharacterArray(String s) {
		Scanner scan = new Scanner(s);
		String current = "";
		ArrayList<Character> characters = new ArrayList<Character>(); 
		while (scan.hasNextLine()) {
			current = scan.nextLine();
			for (int i = 0; i < current.length(); i++){
			    char c = current.charAt(i);
			    characters.add(new Character(c));
			}
		}
		
		return characters;
	}
}