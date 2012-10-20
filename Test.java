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
		Administration a = new Administration();
		
		System.out.println("Erstelle Mitglieder...");
		Member fred = new Member("Fred", "001983", "Guitar", new Date());
		Member earl = new Member("Earl", "0011323", "Drums", new Date());
		Member gretchen = new Member("Gretchen", "023983", "Bass", new Date());
		
		a.addMember(fred);
		a.addMember(earl);
		a.addMember(gretchen);
		
		System.out.println("\nDerzeitige Mitglieder:\n");
		
		members = a.getCurrentMembers();
		
		for (Member m : members) {
			
			System.out.println(m);
		}
				
		System.out.println("\nFüge Proben und Auftritte hinzu...");
		
		a.addRehearsal( new Rehearsal("a", StringToDate("10.10.2012 um 19:00"), 180, new Expense(20)) );
		a.addRehearsal(new Rehearsal("b", StringToDate("12.10.2012 um 19:00"), 180, new Expense(20)) );
		a.addRehearsal(new Rehearsal("c", StringToDate("15.10.2012 um 19:00"), 180, new Expense(20)) );
		a.addRehearsal(new Rehearsal("d", StringToDate("1.11.2012 um 19:00"), 180, new Expense(20)) );
		
		a.addGig(new Gig("e", StringToDate("13.10.2012 um 19:00"), 180, new Income(120)) );
		a.addGig(new Gig("f", StringToDate("14.10.2012 um 19:00"), 60, new Income(200)) );
		a.addGig(new Gig("g", StringToDate("14.11.2012 um 18:00"), 180, new Income(120)) );
		a.addGig(new Gig("h", StringToDate("14.11.2012 um 20:00"), 60, new Income(0)) );
		a.addGig(new Gig("i", StringToDate("17.11.2012 um 19:00"), 60, new Income(120)) );
		
		a.updateEvent("b", StringToDate("12.10.2012 um 19:00"), "B wie Butter");
		a.resetEventPlace("B wie Butter", StringToDate("12.10.2012 um 19:00"));
		
		System.out.println("\nProben im Zeitfenster zwischen 11.10.2012 und 15.10.2012:\n");
		
		events = a.getEvents(StringToDate("11.10.2012 um 18:00"),  StringToDate("15.10.2012 um 20:00"), "Rehearsal");

		for (Event e : events) {
			
			System.out.println(e);
		}
		
		System.out.println("\nAuftritte im Zeitfenster zwischen 14.10.2012 und 14.11.2012 bis 19:00:\n");
		
		a.addTransaction(new Expense(34.89));
		a.addTransaction(new Income(23.90));
		
		events = a.getEvents(StringToDate("14.10.2012 um 18:00"),  StringToDate("14.11.2012 um 19:00"), "Gig");

		for (Event e : events) {
			
			System.out.println(e);
		}
		
		System.out.printf("\nMonatsbilanz zwischen 15.10.2012 und 15.11.2012: %d Û\n", a.financials(StringToDate("15.10.2012 um 18:00"), StringToDate("15.11.2012 um 20:00")));
		
		System.out.printf("---------------------------------------------------\nGesamter Kontoauszug:\n");
		
		for(Transaction t :a.getTransactions()) {
			System.out.println(t);
		}
		
		System.out.printf("= %sÛ\n---------------------------------------------------\n", new DecimalFormat("#.##").format(a.getBalance()));
		
		System.out.println("\nEntferne Mitglied Gretchen...");
		
		a.removeMember(gretchen);
		
		System.out.println("\nDerzeitige Mitglieder:\n");
		
		members = a.getMembers(StringToDate("21.10.2012 um 10:00"));
		
		for (Member m : members) {
			
			System.out.println(m);
		}
		
		System.out.println("\nFüge Songs hinzu...\n");
		
		Song s1=new Song("Titel1", 240, StringToDate("15.10.2012 um 10:00"));
		Song s2=new Song("Titel2", 230, StringToDate("16.10.2011 um 10:00"));
		Song s3=new Song("Titel3", 220, StringToDate("17.10.2010 um 10:00"));
		Song s4=new Song("Titel4", 210, StringToDate("17.11.2010 um 11:00"));
		Song s5=new Song("Titel5", 260, StringToDate("18.10.2009 um 10:00"));
		Song s6=new Song("Titel6", 270, StringToDate("20.10.2008 um 10:00"));
		Song s7=new Song("Titel7", 190, StringToDate("30.10.2002 um 10:00"));
		
		a.addSong(s1);
		a.addSong(s2);
		a.addSong(s3);
		a.addSong(s4);
		a.addSong(s5);
		a.addSong(s6);
		a.addSong(s7);
		
		System.out.println("Songs, die am 17.10.2012 im Reportoire waren:\n");
		
		songs = a.getSongs(StringToDate("17.10.2012 um 10:30"));

		for (Song s : songs) {
			
			System.out.println(s);
		}	
		
		System.out.println("\nEntferne Songs 2 und 3...");
		System.out.println("Aktuelle Titel:\n");
		a.removeSong(s2);
		a.removeSong(s3);
		
		songs = a.getCurrentSongs();

		for (Song s : songs) {
			
			System.out.println(s);
		}
	}
	
	/**
	 * Methode zum Erstellen eines gültigen Datums aus einem String
	 * @param input
	 * 			String input muss mit dem SimpleDateFormat kompatibel sein
	 * @return
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
