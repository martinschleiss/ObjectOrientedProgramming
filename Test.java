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
			
			
		} catch	(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}