import java.util.Iterator;

public class Test {

	public static void main(String[] args) {

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

		System.out.println("\nRufe 2mal next() und anschliessend remove() auf, um aktuelles Element des Iterators zu loeschen...");
		if (it.hasNext()) {
			it.next();
			if (it.hasNext()) {
				it.next();
				it.remove();
			}
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
		System.out.println("\n#################### Test 2 ####################");
		System.out.println("\nErzeuge OrderedMap<MeanElapsedTime,CompositeTime>...");
		OrderedMap<MeanElapsedTime,CompositeTime> map = new OrderedMap<MeanElapsedTime,CompositeTime>();
		System.out.println("\nErzeuge Werte und fuege diese ein...");
		MeanElapsedTime m1 = new MeanElapsedTime(8.3);
		MeanElapsedTime m2 = new MeanElapsedTime(8.5);
		MeanElapsedTime m3 = new MeanElapsedTime(9.5);

		m1.addData(2.4);
		m1.addData(4.4);
		m1.addData(5.4);
		m1.addData(8.4);
		m1.addData(1.4);

		m2.addData(2.4);
		m2.addData(4.4);
		m2.addData(5.4);
		m2.addData(19.4);

		m3.addData(5.6);
		m3.addData(4.6);
		m3.addData(7.6);

		Double[] d1 = {1.24,6.230,1.173};
		Double[] d2 = {11.4,8.19,4.1173};
		Double[] d3 = {7.10001,0.1220,8.017};
		Double[] d4 = {6.10,0.1220,8.017};
		Double[] d5 = {1.4,8.1,4.1173};

		CompositeTime c1 = new CompositeTime(d1);
		CompositeTime c2 = new CompositeTime(d2);
		CompositeTime c3 = new CompositeTime(d3);
		CompositeTime c4 = new CompositeTime(d4);
		CompositeTime c5 = new CompositeTime(d5);

		map.insert(m1);
		map.insert(m2);
		map.insert(m3);
		map.add(m2,c1);
		map.add(m2,c2);
		map.add(m2,c3);
		map.add(m2,c4);
		map.add(m3,c5);

		System.out.println("\nIterieren ueber Elemente und verwiesene Objekte, bestimmung des Minimums der Objekte und des Maximums der Elemente");
		OrderedMapIterator<MeanElapsedTime,CompositeTime> mapIt = map.iterator();
		Iterator<CompositeTime> itIt;
		MeanElapsedTime longest = null;
		CompositeTime shortest = null;
		MeanElapsedTime tmp1;
		CompositeTime tmp2;

		longest = mapIt.next();

		while (mapIt.hasNext()) {

			tmp1 = mapIt.next();

			if (tmp1.major() > longest.major()) {

				longest = tmp1;
			}

			itIt = mapIt.iterator();

			if (itIt.hasNext()) {

				shortest = itIt.next();

				while (itIt.hasNext()) {

					tmp2 = itIt.next();
					if (tmp2.shortest() < shortest.shortest()) {

						shortest = tmp2;
					}
				}
			}
		}
		System.out.println("Groesster Wert der Map-Elemente (erwartet 19.4): " + longest.major());
		System.out.println("Kleinster Wert auf Map-Objekte (erwartet 0.122): " + shortest.shortest());


		System.out.println("\n#################### Test 3 ####################");
		System.out.println("\nDeklarieren der OrderedMap von Test 2 als OrderedSet<MeanElapsedTime>...");
		System.out.println("\nFuege neue Werte hinzu, (auch einen neuen Maximalwert)...");
		OrderedSet<MeanElapsedTime> oSet = map;

		MeanElapsedTime m4 = new MeanElapsedTime(4.3);
		MeanElapsedTime m5 = new MeanElapsedTime(3.5);
		MeanElapsedTime m6 = new MeanElapsedTime(6.5);

		m4.addData(2.4);
		m4.addData(4.6);
		m4.addData(5.4);
		m4.addData(8.2);
		m4.addData(1.4);

		m5.addData(2.4);
		m5.addData(3.4);
		m5.addData(5.4);
		m5.addData(19.1);

		m6.addData(5.6);
		m6.addData(21.6);
		m6.addData(7.4);

		oSet.insert(m4);
		oSet.insert(m5);
		oSet.insert(m6);

		Iterator<MeanElapsedTime> setIt = oSet.iterator();

		longest = setIt.next();

		while (setIt.hasNext()) {

			tmp1 = setIt.next();

			if (tmp1.major() > longest.major()) {

				longest = tmp1;
			}
		}
		System.out.println("neuer groesster Wert der Set-Elemente (erwartet 21.6): " + longest.major());

		System.out.println("\n#################### Test 4 ####################");

		OrderedSet<ElapsedTime> set1 = new OrderedSet<ElapsedTime>();
		int count = 0;
		mapIt = map.iterator();

		while (mapIt.hasNext()) {

			set1.insert(mapIt.next());
			count++;

			itIt = mapIt.iterator();

			while (itIt.hasNext()) {

				set1.insert(itIt.next());
				count++;
			}
		}

		setIt = oSet.iterator();

		while (setIt.hasNext()) {

			set1.insert(setIt.next());
			count++;
		}


	}
}
