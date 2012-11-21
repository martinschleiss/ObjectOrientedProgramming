import java.util.Iterator;

public class Test2 {
	
	public static void main(String[] args) {
		
		
		OrderedMap<Description, Integer> o = new OrderedMap<Description, Integer>();
		
		Description d = new Description("Hallo3");
		o.insert(new Description("Hallo1"));
		o.insert(new Description("Hallo2"));
		o.insert(d, 3);
		o.insert(new Description("Hallo4"), 4);
		
		o.add(d, 4);
		o.add(d,5);
		o.add(d, 6);
		
		OrderedMapIterator<Description,Integer> it = o.iterator();
		Iterator<Integer> it2;
		it.next();
		it.next();
		d = it.next();
		it2 = it.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}
		while (it2.hasNext()) {
			
			System.out.println(it2.next());
		}
	}
}
