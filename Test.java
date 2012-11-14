import java.util.ArrayList;
import java.util.InputMismatchException;

public class Test {
	
	public static void main(String[] args) {

	/**
	 * Typbeziehungen: Anmerkungen
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
		
		try {		
			
		ArrayList<Box> boxbox = new ArrayList<Box>();
		
		Box b1 = new Box(3, 3, '.', '#');
		Box b2 = new Box(4, 4, '-', '+');
		Box c1 = new ClearBox(5,4);			//ClearBox ist Untertyp von Box
		Box c2 = new ClearBox(4,5);
		Box d1 = new DarkBox(4,5,'1');		//DarkBox ist Untertyp von Box
		Box d2 = new DarkBox(4,5,'2');
		
		boxbox.add(b1);
		boxbox.add(b2);
		boxbox.add(c1);
		boxbox.add(c2);
		boxbox.add(d1);
		boxbox.add(d2);
		
		Repeated<Box> r = new Repeated<Box>(boxbox, 3, 2);
		Scaled<Box> s = new Scaled<Box>(boxbox, 3, 2);
		
		System.out.println(s);
		System.out.println("bam");
		Repeated<Character> f1 = new FreeBox("apfel\nkuche\nnschm\nechtf\nantas\ntisch");	//FreeBox ist Untertyp von Repeated<Character>
		Repeated<Character> f2 = new FreeBox("abcd\nefgh\nijkm\nlnop\nqrst\nuvwx");	
		/*
		Scaled<Repeated<Character>> boo = new Scaled<Repeated<Character>>(f1);
		Scaled<Scaled<Box>> woo = new Scaled<Scaled<Box>>(s);		//	
		*/
		

			
		} catch	(IllegalArgumentException e) {
		
			System.err.println(e.getMessage());
		
		} catch	(InputMismatchException e) {
			
			System.err.println(e.getMessage());
		}
	}
}