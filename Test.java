import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		
		Set<Description> set1 = new OrderedSet<Description>();
		//nur das kein Fehler auftritt, Strings eingefuegt, keine Tests von mir
		set1.insert(new Description("hallo"));
		set1.insert(new Description("wie"));
		set1.insert(new Description("gehts"));
		set1.insert(new Description("dir"));
		
		Iterator<Description> it = set1.iterator();
		
		if(it.hasNext()) {
			it.next();
			it.remove();
		}
		it = set1.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}
		
		Set<Description> set2 = new OrderedMap<Description, Description>();
		
		set2.insert(new Description("hallo"));
		set2.insert(new Description("wie"));
		set2.insert(new Description("gehts"));
		set2.insert(new Description("dir"));
		
		Iterator<Description> it2 = set2.iterator();
		
		while (it2.hasNext()) {
			
			System.out.println(it2.next());
		}
		
		ElapsedTime et=new ElapsedTime(4.3);
		
		System.out.println(et.shorter(new ElapsedTime(5.8)));
		
		MeanElapsedTime mt=new MeanElapsedTime(8.3);
		
		mt.addData(2.4);
		mt.addData(4.4);
		mt.addData(5.4);
		mt.addData(8.4);
		mt.addData(1.4);
		
		System.out.println("Avarage 1: "+mt.average());
		
		MeanElapsedTime mt1=new MeanElapsedTime(8.3);
		
		mt1.addData(2.4);
		mt1.addData(4.4);
		mt1.addData(5.4);
		mt1.addData(1.4);
		System.out.println("Avarage 2: "+mt1.average());
		System.out.println(mt.shorter(mt1));
		
		
		
	}
}
