import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		/*
		Set<Description> set1 = new Set<Description>();
		//nur das kein Fehler auftritt, Strings eingefuegt, keine Tests von mir
		set1.insert(new Description("hallo"));
		set1.insert(new Description("wie"));
		set1.insert(new Description("gehts"));
		set1.insert(new Description("dir"));
		
		Iterator<Description> it = set1.iterator();
		
		if(it.hasNext()) {
			it.next();
			it.next();
			it.next();
			it.next();
			it.next();
			it.next();
			it.remove();
		}
		it = set1.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}
		System.out.println("####################");
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
		mt1.addData(19.4);
		System.out.println("Avarage 2: "+mt1.average());
		System.out.println(mt.shorter(mt1));
		
		
		MeanElapsedTime ept=new MeanElapsedTime(9.5);
		ept.addData(5.6);
		ept.addData(4.6);
		ept.addData(7.6);
		MeanElapsedTime ept1=new MeanElapsedTime(9.5);
		ept1.addData(5.6);
		ept1.addData(4.6);
		System.out.println(ept.shorter(ept1));
		
		/**
		 * offizieller Test laut Angabe beginnt hier:
		 */
		
		System.out.println("#################### Test 1 ####################");
		System.out.println("\nErzeuge OrderedSet<Description>...");

		OrderedSet<Description> set = new OrderedSet<Description>();

		System.out.println("\nFuege unsortierte Werte ein...");
		Description d = new Description("Beschreibung 1");
		
		set.insert(d);
		set.insert(new Description("Beschreibung 12"));
		set.insert(new Description("Beschreibung 1234"));
		set.insert(new Description("Beschreibung 123"));

		
		Iterator<Description> it = set.iterator();
		int lineCount = 0;
		
		System.out.println("\nAusgabe des Sets mit Hilfe des Itertors: (Erwartete Zeilen: 4)");
		
		while (it.hasNext()) {
			System.out.println(it.next());
			lineCount++;
		}
		System.out.println("Anzahl der Zeilen: " + lineCount);
		System.out.println("\nNehme folgende Aenderungen an Set vor:");
		System.out.println("\nLoesche \"Beschreibung 1\"");
		
		set.remove(d);
		
		System.out.println("\nErzeuge neuen Iterator...");
		it = set.iterator();
		
		System.out.println("\nRufe next() und anschliessend remove() auf, um aktuelles Element des Iterators zu loeschen...");
		if (it.hasNext()) {
			it.next();
			it.remove();
		}
		
		System.out.println("\nFuege gleiche, aber nicht idente Beschreibung \"Beschreibung 12\" in Set ein...");
		set.insert(new Description("Beschreibung 12"));

		System.out.println("\nAusgabe des Sets mit Hilfe des Itertors: (Erwartete Zeilen: 3)\n");
		it = set.iterator();
		lineCount = 0;
		while (it.hasNext()) {
			System.out.println(it.next());
			lineCount++;
		}
		System.out.println("Anzahl der Zeilen: " + lineCount);
	}
}
