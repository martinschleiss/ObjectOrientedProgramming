import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		
		Set<String> set = new Set<String>();
		
		set.insert("Hallo");
		set.insert("Welt");
		set.insert("Hallo");
		
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}	
	}
}
