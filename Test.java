/**
 * @version 1.1;
 */

import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Test {

	public static void main(String[] args) {

		System.out.println("Erstelle Datenstrukturen und Administrations-Objekt...");

		ArrayList<Event> events;
		ArrayList<Member> members;
		ArrayList<Song> songs;
		ArrayList<RehearsalLocation> rehearsalLocations;
		ArrayList<GigLocation> gigLocations;
		Administration a = new Administration();

		System.out.println("Erstelle Mitglieder...");

		Member fred = new Member("Duke Silver", "001983", "Guitar", StringToDate("13.11.2011 um 19:00"));
		Member earl = new Member("Ron Burgundy", "0011323", "Drums", StringToDate("13.11.2011 um 19:00"));
		Member gretchen = new Member("Gretchen S.", "023983", "Bass",StringToDate("13.11.2011 um 19:00"));

		a.addMember(fred,StringToDate("13.11.2011 um 19:00"));
		a.addMember(earl,StringToDate("13.11.2011 um 19:00"));
		a.addMember(gretchen,StringToDate("13.11.2011 um 19:00"));

		System.out.println("Es wurden 3 Mitglieder hinzugefuegt.");
		System.out.println("\n#######################################\n");
		System.out.println("Test 1: Auflistung aller Mitglieder: (Richtige Anzahl: 3)\n");

		members = a.getCurrentMembers();

		for (Member m : members) {

			System.out.println(m);
		}
		System.out.println("\n#######################################\n");		
		System.out.println("Fuege Proben und Auftritte hinzu...");

		Rehearsal r1 = new Rehearsal("Proberaum", StringToDate("10.10.2012 um 19:00"), 180, new Expense(20) );
		Rehearsal r2 = new Rehearsal("Proberaum", StringToDate("12.10.2012 um 19:00"), 180, new Expense(20) );
		Rehearsal r3 = new Rehearsal("Proberaum", StringToDate("15.10.2012 um 19:00"), 180, new Expense(20) );
		Rehearsal r4 = new Rehearsal("Proberaum", StringToDate("01.11.2012 um 19:00"), 180, new Expense(20) );

		Gig g1 = new Gig("Reigen", StringToDate("13.10.2012 um 19:00"), 180, new Income(120) );
		Gig g2 = new Gig("Porgy", StringToDate("14.10.2012 um 19:00"), 60, new Income(200) );
		Gig g3 = new Gig("Reigen", StringToDate("14.11.2012 um 18:00"), 180, new Income(120) );
		Gig g4 = new Gig("Soulveranda", StringToDate("14.11.2012 um 20:00"), 60, new Income(0) );
		Gig g5 = new Gig("Soulveranda", StringToDate("17.11.2012 um 20:00"), 60, new Income(120) );

		a.addEvent(r1);
		a.addEvent(r2);
		a.addEvent(r3);
		a.addEvent(g1);
		a.addEvent(g2);
		a.addEvent(g3);

		System.out.println("Es wurden 3 Proben und 3 Gigs hinzugefuegt.");
		System.out.println("\n#######################################\n");
		System.out.println("Test 2: Auflistung aller Proben: (Richtige Anzahl: 3)\n");

		events = a.getRehearsals(StringToDate("09.10.2012 um 18:00"),  StringToDate("15.11.2012 um 20:00"));

		for (Event e : events) {

			System.out.println(e);
		}

		System.out.println("\n#######################################\n");
		System.out.println("Test 3: Auflistung aller Events im Zeitraum von 15.10.2012 um 18:30 bis 14.11.2012 um 19:30: (Richtige Anzahl: 2) \n");

		events = a.getEvents(StringToDate("15.10.2012 um 18:30"),  StringToDate("14.11.2012 um 19:30"));

		for (Event e : events) {

			System.out.println(e);
		}
		System.out.println("\n#######################################\n");
		System.out.println("Neuer Auftritt soll hinzugefuegt werden. Erzeuge Request...");
		System.out.println("\n#######################################\n");
		System.out.println("Test 4: Abstimmen der Mitglieder ueber neuen Auftritt: (Testannahme: 2 Mitglieder sagen zu, 1 Mitglied sagt ab)");
		System.out.println("Ausgang: Request wird abgelehnt werden.");
		Request a1 = new GigRequest(a, g4);		
		a.addRequest(a1,"Gig am 14. November um 19:00 in der Soulveranda ok?");


		fred.respond(a1,true,"Passt, bis dahin hab ich meine Gitarre eh wieder.");
		gretchen.respond(a1,true,"Kein Problem, ich habe Zeit");
		earl.respond(a1,false,"Nope, hab schon was vor.");

		System.out.println("\n" + a1);

		System.out.println("Gig wurde erstellt: " + a.executeRequest(a1));
		System.out.println("\n#######################################\n");
		System.out.println("Termin soll verschoben werden. Erzeuge Postpone-Request...");
		System.out.println("\n#######################################\n");
		System.out.println("Test 5: Abstimmen der Mitglieder ueber Terminverschiebung einer Probe: (Testannahme: Alle Mitglieder sagen zu");
		System.out.println("Ausgang: Request wird zugestimmt werden, Probetermin wird verschoben.");

		Request a2 = new PostponeEventRequest(a, r3, StringToDate("16.10.2012 um 19:00"));		
		a.addRequest(a2,"Geht 17. statt 14. November um 19:00 in der Soulveranda?");


		fred.respond(a2,true,"Passt, dann muss ich nicht mit meiner Frau ins Theater.");
		gretchen.respond(a2,true,"Hab Zeit");
		earl.respond(a2,true,"Da gehts.");

		System.out.println("\n" + a2);

		System.out.println("Termin wurde verschoben: " + a.executeRequest(a2));

		System.out.println("\n#######################################\n");
		System.out.println("Test 6: Aendern der Probelocation und anschliessendes Loeschen der Probe: \n");
		events = a.getRehearsals(StringToDate("16.10.2012 um 08:00"),  StringToDate("16.10.2012 um 23:00"));
		System.out.println("Ausgabe: (Probe mit alter Location)");
		for (Event e : events) {

			System.out.println(e);
		}
		System.out.println("\nAendere Probelocation der Probe von \"Proberaum\" auf \"test\"...\n");
		a.updateEvent(r3, "test");
		events = a.getRehearsals(StringToDate("16.10.2012 um 08:00"),  StringToDate("16.10.2012 um 23:00"));
		System.out.println("Ausgabe: (Probe mit neuer Location)");
		for (Event e : events) {

			System.out.println(e);
		}
		System.out.println("\nLoesche Probe...\n");
		a.deleteEvent(r3);
		events = a.getRehearsals(StringToDate("16.10.2012 um 08:00"),  StringToDate("16.10.2012 um 23:00"));
		System.out.println("Ausgabe: (nichts, Probe wurde geloescht)");
		for (Event e : events) {

			System.out.println(e);
		}
		System.out.println("\n#######################################\n");
		System.out.println("Test 7: Rueckgaengigmachen von Test 6 - Wiederherstellen der Probe und Zuruecksetzen der Location");
		System.out.println("\nWiederherstellen der Probe...");
		System.out.println("Probe wieder hergestellt: " + a.restoreEvent(r3));
		events = a.getRehearsals(StringToDate("16.10.2012 um 08:00"),  StringToDate("16.10.2012 um 23:00"));
		System.out.println("Ausgabe: (Probe mit neuer Location)");
		for (Event e : events) {

			System.out.println(e);
		}
		System.out.println("\nLocation auf alten Wert gesetzt: " + r3.resetPlace());
		events = a.getRehearsals(StringToDate("16.10.2012 um 08:00"),  StringToDate("16.10.2012 um 23:00"));
		System.out.println("Ausgabe: (Probe mit alter Location)");
		for (Event e : events) {

			System.out.println(e);
		}
		System.out.println("\n#######################################\n");
		System.out.println("Fuege Einnahmen und Ausgaben hinzu:");
		a.addTransaction(new Expense(34.89));
		a.addTransaction(new Income(23.90));
		System.out.println("\n#######################################\n");
		System.out.printf("Test 8: Monatsbilanz zwischen 15.10.2012 und 15.11.2012: %d Euro\n", a.financials(StringToDate("15.10.2012 um 18:00"), StringToDate("15.11.2012 um 20:00")));
		System.out.printf("---------------------------------------------------\nGesamter Kontoauszug:\n");

		for(Transaction t :a.getTransactions()) {
			System.out.println(t);
		}

		System.out.print("= " + new DecimalFormat("#.##").format(a.getBalance()) + " Euro\n---------------------------------------------------\n");
		System.out.println("\n#######################################\n");
		System.out.println("GigLocation erzeugen...\n");
		//GigLocation erzeugen
		GigLocation gl1=new GigLocation(1,170,20,540);
		GigLocation gl2=new GigLocation(2,175,35,550);
		GigLocation gl3=new GigLocation(3,195,45,580);
		GigLocation gl4=new GigLocation(4,189,40,590);
		GigLocation gl5=new GigLocation(5,137,30,520);
		GigLocation gl6=new GigLocation(6,175,30,700);

		a.addGigLocation(gl1);
		a.addGigLocation(gl2);
		a.addGigLocation(gl3);
		a.addGigLocation(gl4);
		a.addGigLocation(gl5);
		a.addGigLocation(gl6);
		System.out.println("\n#######################################\n");
		System.out.println("Alle GigLocation ausgeben\n");
		gigLocations= a.getGigLocation();

		for (GigLocation l : gigLocations) {

			System.out.println(l);
		}
		System.out.println("\n#######################################\n");
		System.out.println("\nGigLocation mit Parametern ausgeben\n");


		gigLocations= a.getGigLocation(5,137,30,520);

		for (GigLocation l : gigLocations) {

			System.out.println(l);
		}
		System.out.println("\n#######################################\n");
		System.out.println("RehearsalLocation erzeugen....");

		//RehearsalLocation erzeugen
		RehearsalLocation rl1=new RehearsalLocation(16,40,20,20, "Black");
		RehearsalLocation rl2=new RehearsalLocation(10,40,20,20, "White");
		RehearsalLocation rl3=new RehearsalLocation(11,30,20,20, "Pink");
		RehearsalLocation rl4=new RehearsalLocation(22,55,20,20, "Black");
		RehearsalLocation rl5=new RehearsalLocation(23,39,20,20, "Black");
		RehearsalLocation rl6=new RehearsalLocation(19,60,20,20, "White");

		a.addRehearsalLocation(rl1);
		a.addRehearsalLocation(rl2);
		a.addRehearsalLocation(rl3);
		a.addRehearsalLocation(rl4);
		a.addRehearsalLocation(rl5);
		a.addRehearsalLocation(rl6);
		System.out.println("\n#######################################\n");
		System.out.println("Alle RehearsalLocation ausgeben\n");
		rehearsalLocations= a.getRehearsalLocation();

		for (RehearsalLocation l : rehearsalLocations) {

			System.out.println(l);
		}
		System.out.println("\n#######################################\n");
		System.out.println("\nRehearsalLocation mit Parametern ausgeben\n");
		rehearsalLocations= a.getRehearsalLocation(16,40,20,20,"Black");

		for (RehearsalLocation l : rehearsalLocations) {

			System.out.println(l);
		}
		System.out.println("\n############# Ende Test2 --> positives Ergebniss!! #############\n");
		
		System.out.println("\n############# Test9: 6 Songs esrtellen und ausgeben aktueller Songs, und Songs zu einem bestimmten Zeipunkt #############\n");
	
		Song s1=new Song("Song1", 240, StringToDate("03.11.2012 um 19:00"));
		Song s2=new Song("Song2", 160, StringToDate("14.10.2012 um 19:00"));
		Song s3=new Song("Song3", 150,StringToDate("13.09.2012 um 19:00"));
		Song s4=new Song("Song4", 300, StringToDate("03.08.2012 um 19:00"));
		Song s5=new Song("Song5", 260,StringToDate("15.08.2012 um 19:00"));
		Song s6=new Song("Song6", 210, StringToDate("23.07.2012 um 19:00"));
		
		a.addSong(s1);
		a.addSong(s2);
		a.addSong(s3);
		a.addSong(s4);
		a.addSong(s5);
		a.addSong(s6);
		
		ArrayList<Song> sl1=new ArrayList<Song>();
		sl1=a.getCurrentSongs();
		System.out.println("Ausgabe CurrentSongs");
		for (Song s : sl1) {
			System.out.println(s);
		}
		
		
		ArrayList<Song> sl=new ArrayList<Song>();
		sl=a.getSongs(StringToDate("16.08.2012 um 19:00"));
		System.out.println("\nAusgabe Songs am 16.08.2012 um 19:00 -> erwartet: s4,s5,s6\n");
		for (Song s : sl) {
			System.out.println(s);
		}
	
	
	}
	
	
	
	
	
	
	
	

	/**
	 * Vorbedingung: 
	 * @param	input entspricht dem Format "dd.MM.yyyy 'um' HH:mm"
	 * 
	 * Nachbedingung:
	 * @return gueltig erstelltes Date
	 */
	public static Date StringToDate(String input) {

		Date output = null;
		SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm");

		try {

			output = date.parse(input);

		} catch (ParseException e) {
			e.printStackTrace();
		}    
		return output;
	}
}
