import java.util.ArrayList;
import java.util.InputMismatchException;

public class Test {
	
	public static void main(String[] args) {

	/**
	 * Typbeziehungen: Anmerkungen
	 * Repeated<ClearBox> und Repeated<DarkBox> sind Untertypen von Repeated<Box>, zumindest theoretisch ersetzbar, in Java nicht moeglich. 
	 * P in Scaled<P> oder Repeated<P> kann durch beliebig geschachteltes Scaled<Scaled<P>> oder analog bei Repeated ersetzt werden
	 * 
	 * 
	 * 
	 */
		
		try {	
		
		ArrayList<Pict> universal = new ArrayList<Pict>();
		
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
		
		universal.add(r);
		universal.add(b1);

		ArrayList<Repeated<Character>> filler = new ArrayList<Repeated<Character>>();
		Repeated<Character> f1 = new FreeBox("apfel\nkuche\nnschm\nechtf\nantas\ntisch");	//FreeBox ist Untertyp von Repeated<Character>
		Repeated<Character> f2 = new FreeBox("abcd\nefgh\nijkm\nlnop\nqrst\nuvwx");
		
		filler.add(f1);
		filler.add(f2);
		universal.add(f1);
		
		Scaled<Repeated<Character>> s = new Scaled<Repeated<Character>>(filler,2,1);
		
		universal.add(s);
		
		Scaled<Pict> all = new Scaled<Pict>(universal,2,2);
		
		System.out.println(all);
		all.scale(1.5);
		System.out.println(all);
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Teste Box:");
		
		Box box1 = new Box(6, 6, '*', 'o');
		System.out.println("Box 1 unskaliert:");
		System.out.println(box1 + "\n");
		
		box1.scale(4);
		System.out.println("Box 1 skaliert um den Faktor 4:");
		System.out.println(box1 + "\n");

		box1 = new Box(6, 6, '*', 'o');
		box1.scale(0.5);
		System.out.println("Box 1 skaliert um den Faktor 0.5:");
		System.out.println(box1 + "\n");
		
		box1 = new Box(6, 6, '*', 'o');
		box1.scale(0.5);
		box1.scale(4);
		System.out.println("Box 1 skaliert um die Faktoren 0.5 und 4:");
		System.out.println(box1 + "\n");
			
		} catch	(IllegalArgumentException e) {
		
			System.err.println(e.getMessage());
		
		} catch	(InputMismatchException e) {
			
			System.err.println(e.getMessage());
		}
	}
}