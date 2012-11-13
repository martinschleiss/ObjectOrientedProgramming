import java.util.ArrayList;
import java.util.Scanner;

public class FreeBox extends Repeated<Character> {
	
	public FreeBox(String s) {
		
		super(getBlackBoxesOfString(s), (int)getHeightOfContent(s), (int)getWidthOfContent(s));
		
	}
	
	private static double getHeightOfContent(String s) {
		Scanner scan = new Scanner(s);
		String current = scan.nextLine();
		double h = 0;
		ArrayList<DarkBox> darkBoxes = new ArrayList<DarkBox>(); 
		while (scan.hasNextLine()) {
			for (int i = 0; i < current.length(); i++){
			    char c = current.charAt(i);        
			    DarkBox b = new DarkBox(1, 1, c);
			    darkBoxes.add(b);
			}
			current += scan.nextLine();
			h++;
		}
		
		return h;
	}
	
	private static double getWidthOfContent(String s) {
		Scanner scan = new Scanner(s);
		String current = scan.nextLine();

		return current.length();
	}
	
	
	private static ArrayList<Character> getBlackBoxesOfString(String s) {
		Scanner scan = new Scanner(s);
		String current = scan.nextLine();
		ArrayList<Character> characters = new ArrayList<Character>(); 
		while (scan.hasNextLine()) {
			for (int i = 0; i < current.length(); i++){
			    char c = current.charAt(i);        
			    characters.add(new Character(c));
			}
			current = scan.nextLine();
		}
		
		return characters;
	}
}