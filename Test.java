import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
			
		Set<Description> set1 = new OrderedSet<Description>();
		
		set1.insert(new Description(1));
		set1.insert(new Description(2));
		set1.insert(new Description(4));
		set1.insert(new Description(5));
		set1.insert(new Description(3));
		
		Iterator<Description> it = set1.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}	
		
		
		
	}
}
