import java.util.Iterator;

public class Test2 {
	
	public static void main(String[] args) {
		
		
		Set<Description> o = new Set<Description>();
		
		Description d = new Description("Hallo3");
		o.insert(new Description("Hallo1"));
		o.insert(new Description("Hallo2"));
		o.insert(d);
		o.insert(new Description("Hallo4"));

		Iterator<Description> it = o.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}
	}
}
