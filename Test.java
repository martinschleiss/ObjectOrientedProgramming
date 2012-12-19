public class Test {

	public static void main(String[] args) {
		
		/**
		 * Initialisierung
		 */
		Baeckerei backstube = new Baeckerei();
		
		WunschTeig t1 = new WunschTeigMuerb();
		WunschTeig t2 = new WunschTeigSchokolade();
		WunschTeig t3 = new WunschTeigZimtstern();
		
		WunschForm f1 = new WunschFormRund();
		WunschForm f2 = new WunschFormWeihnachtsmann();
		WunschForm f3 = new WunschFormMond();

		WunschFuellung fl1=new WunschFuellungMarmelade();
		WunschFuellung fl2=new WunschFuellungSchokolade();

		/**
		 * Tests
		 */
		
		/**
		 * ++++++++++++++++++++ TEST 1 ++++++++++++++++++++
		 */
		System.out.println("Test 1: Bestelle leere Bestellung (Erwartet: leere Keksdose)");
		
		Bestellung b = new Bestellung();
		
		b.drucke();
		
		backstube.addBestellung(b);
		System.out.println("Verarbeite Bestellung...");
		Keksdose k = backstube.nextBestellung();
		
		k.inhalt();
		
		
		/**
		 * ++++++++++++++++++++ TEST 2 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 2: Erstelle Bestellung mit ungueltiger Anzahl der Positionen <= 0 (Erwartet: leere Bestellung, leere Keksdose)");
		
		b = new Bestellung();
		b.addPositionKeks(0, t1, f1);				// 0 < 0 == false
		b.addPositionKeks(-10, t2, f2, fl2);	// -10 < 0 == false
		b.drucke();
		
		backstube.addBestellung(b);
		System.out.println("Verarbeite Bestellung...");
		k = backstube.nextBestellung();
		
		k.inhalt();
		
		
		/**
		 * ++++++++++++++++++++ TEST 3 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 3: Bestelle 3 Muerbteig- und 2 Zimtsternkekse in runder Form (Erwartet: Bestellung mit 2 Positionen, Keksdose mit 5 Keksen)");
		
		b = new Bestellung();
		b.addPositionKeks(3, t1, f1);
		b.addPositionKeks(2, t3, f1);
		b.drucke();
		
		backstube.addBestellung(b);
		System.out.println("Verarbeite Bestellung...");
		k = backstube.nextBestellung();
		
		k.inhalt();

		
		/**
		 * ++++++++++++++++++++ TEST 4 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 4: Bestelle 2 runde und 3 mondfoermige Schokoladenkekse (Erwartet: Bestellung mit 2 Positionen, Keksdose mit 5 Keksen)");
		
		b = new Bestellung();
		b.addPositionKeks(2, t2, f1);
		b.addPositionKeks(3, t2, f3);
		b.drucke();
		
		backstube.addBestellung(b);
		System.out.println("Verarbeite Bestellung...");
		k = backstube.nextBestellung();
		
		k.inhalt();
		
		
		/**
		 * ++++++++++++++++++++ TEST 5 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 5: Bestelle 2 runde Muerbteigkekse und 2 runde Muerbteig-Doppelkekse mit Marmeladefuellung" +
				"\n(Erwartet: Bestellung mit 2 Positionen, Keksdose mit 4 Keksen");
		
		b = new Bestellung();
		b.addPositionKeks(2, t1, f1);
		b.addPositionKeks(2, t1, f1, fl1);
		b.drucke();
		
		backstube.addBestellung(b);
		System.out.println("Verarbeite Bestellung...");
		k = backstube.nextBestellung();
		
		k.inhalt();

		
		/**
		 * ++++++++++++++++++++ TEST 6 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 6: Bestelle 3 weihnachtsmannfoermige Muerbbteig-Doppelkekse mit Schokoladenfuellung" +
				"\nund 4 mondfoermige Zimtsternkekse. (Erwartet: Bestellung mit 2 Positionen, Keksdose mit 7 Keksen)");
		
		b = new Bestellung();
		b.addPositionKeks(3, t1, f2, fl2);
		b.addPositionKeks(4, t3, f3);
		b.drucke();
		
		backstube.addBestellung(b);
		System.out.println("Verarbeite Bestellung...");
		k = backstube.nextBestellung();
		
		k.inhalt();
		
		
		/**
		 * ++++++++++++++++++++ TEST 7 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 7: Hole naechste Bestellung der Baeckerei, obwohl keine Bestellung offen (Erwartet: leere Keksdose)");
		
		System.out.println("Verarbeite Bestellung...");
		k = backstube.nextBestellung();
		
		k.inhalt();
		

		/**
		 * ++++++++++++++++++++ TEST 8 ++++++++++++++++++++
		 */
		System.out.println("\n\n\n\nTest 8: Erstelle 3 umfangreiche Bestellungen und arbeite hintereinander ab (Erwartet: 3 Bestellungen, 3 Keksdosen)");
		
		Bestellung b1 = new Bestellung();
		Bestellung b2 = new Bestellung();
		Bestellung b3 = new Bestellung();
		
		b1.addPositionKeks(8, t1, f1);
		b1.addPositionKeks(5, t2, f2);
		b1.addPositionKeks(8, t1, f1, fl1);
		b1.addPositionKeks(1, t2, f2, fl2);
		b1.addPositionKeks(2, t3, f3, fl1);
		b1.addPositionKeks(4, t3, f3);
		b1.addPositionKeks(2, t1, f2);
		b1.addPositionKeks(9, t2, f3);
		b1.addPositionKeks(3, t3, f1);
		
		b1.drucke();
		
		b2.addPositionKeks(12, t2, f1);
		b2.addPositionKeks(6, t1, f2, fl1);
		b2.addPositionKeks(7, t2, f3, fl2);
		b2.addPositionKeks(7, t3, f2);
		b2.addPositionKeks(10, t1, f3);
		b2.addPositionKeks(9, t3, f1, fl2);
		
		b2.drucke();

		b3.addPositionKeks(3, t2, f2, fl2);
		b3.addPositionKeks(6, t3, f3, fl1);
		b3.addPositionKeks(12, t1, f1, fl1);
		b3.addPositionKeks(5, t1, f2);
		b3.addPositionKeks(9, t3, f3);
		b3.addPositionKeks(11, t2, f1);

		b3.drucke();
		
		System.out.println("Verarbeite Bestellung...");
		
		backstube.addBestellung(b1);
		backstube.addBestellung(b2);
		backstube.addBestellung(b3);
		
		k = backstube.nextBestellung();
		k.inhalt();
		
		k = backstube.nextBestellung();
		k.inhalt();
		
		k = backstube.nextBestellung();
		k.inhalt();
	}
}