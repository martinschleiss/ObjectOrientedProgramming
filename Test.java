import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
			
		Set<Description> set1 = new OrderedSet<Description>();
		
		set1.insert(new Description(5.0));
		set1.insert(new Description(1.0));
		set1.insert(new Description(2.0));
		set1.insert(new Description(4.0));
		set1.insert(new Description(3.0));
		
		Iterator<Description> it = set1.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
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
