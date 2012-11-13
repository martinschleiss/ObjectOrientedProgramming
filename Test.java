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
		
		FreeBox f1 = new FreeBox("apfel\nkuche\nnschm\nechtf\nantas\ntisch");
		Repeated<Character> f2 = new FreeBox("abcd\nefgh\nijkm\nlnop\nqrst\nuvwx");		//FreeBox ist Untertyp von Repeated<Character>
		
		Repeated<Box> r = new Repeated<Box>(boxbox, 3, 2);
		
	
			
			/**
			Box b12= new Box(6,6, '.','�');
			Box b22= new Box(6,6, '.','�');
			Box b32= new Box(4,4, '.','�');
			ArrayList<Box> box=new ArrayList<Box>();
			box.add(b12);
			box.add(b22);
			box.add(b32);
			box.add(b12);
			box.add(b22);
			box.add(b32);
			
		
			Repeated<Box> rp= new Repeated<Box>(box,3,2);
			System.out.println(rp.toString());
			**/
			
		} catch	(IllegalArgumentException e) {
		
			System.err.println(e.getMessage());
		
		} catch	(InputMismatchException e) {
			
			System.err.println(e.getMessage());
		}
	}
}