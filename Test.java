import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println("Hello Test");
		
		Box b = null;
		FreeBox f = null;
		
		try {
			
			b = new Box(3.0,3.0,'.','#');
			System.out.println(b);
			
			f = new FreeBox("apfel\nkuche\nnschm\nechtf\nantas\ntisch");
			System.out.println(f);
			f.scale(.5);
			System.out.println(f);
			f.scale(4);
			System.out.println(f);
			Box b1= new Box(6.0,6.0, '.','Ü');
			Box b2= new Box(6.0,6.0, '.','Ö');
			Box b3= new Box(4.0,4.0, '.','Ä');
			ArrayList<Box> box=new ArrayList<Box>();
			box.add(b1);
			box.add(b2);
			box.add(b3);
			box.add(b1);
			box.add(b2);
			box.add(b3);
			
		
			Repeated<Box> rp= new Repeated<Box>(box,3,2);
			System.out.println(rp.toString());
			
			
		} catch	(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}