import java.util.ArrayList;
import java.util.InputMismatchException;

public class Test {
	
	public static void main(String[] args) {

	/**
	 * Typbeziehungen: Anmerkungen
	 * 
	 * BaseBox ist Untertyp von Pict
	 * Box und DarkBox sind Untertypen von Basebox
	 * ClearBox ist Untertyp von Box
	 * DarkBox ist kein Untertyp von Box, da Box sicherstellen muss, dass sich die Eingabezeichen nicht aendern, in DarkBox sind diese aber veraenderbar
	 * Box kann kein Untertyp von Repeated sein, da die Ausgabe von skalierten Instanzen nach unterschiedlichen Methoden erfolgt.
	 * FreeBox ist Untertyp von Repeated<Character>, die Zusicherungen wuerden es auch umgekehrt erlauben (ergibt aber wenig Sinn)
	 * Repeated<P> fuer unbekannte P: ist Obertyp von Repeated<U> wenn U Untertyp von P ist
	 * Repeated<P> wenn P Untertyp von Pict ist Untertyp von Repeated<Pict> zumindest theoretisch ersetzbar, in Java nicht moeglich. 
	 * Repeated<ClearBox> und Repeated<DarkBox> sind Untertypen von Repeated<Box>, zumindest theoretisch ersetzbar, in Java nicht moeglich. 
	 * P in Scaled<P> kann durch geschachteltes Scaled<Scaled<P>> ersetzt werden
	 * P in Repeated<P> kann geschachtelt werden, wenn P Untertyp von Pict 
	 * P in Scaled<P> wobei P Untertyp von Box ist: Scaled<P> Untertyp von Scaled<BaseBox>
	 */
		
		try {	
		/*
		ArrayList<Pict> universal = new ArrayList<Pict>();
		
		ArrayList<Box> boxbox = new ArrayList<Box>();
		System.out.println("Erstelle Boxes...");
		Box b1 = new Box(3, 3, '.', '#');
		Box b2 = new Box(4, 4, '-', '+');
		Box c1 = new ClearBox(5,4);			//ClearBox ist Untertyp von Box
		Box c2 = new ClearBox(4,5);
		DarkBox d1 = new DarkBox(4,5,'1');		//DarkBox ist kein Untertyp von Box;
		DarkBox d2 = new DarkBox(4,5,'2');
		
		boxbox.add(b1);
		boxbox.add(b2);
		boxbox.add(c1);
		boxbox.add(c2);
		boxbox.add(d1);
		boxbox.add(d2);
		
		System.out.println("Erzeuge Repeated<Box> mit erstellten Boxes...");
		
		Repeated<Box> r = new Repeated<Box>(boxbox, 2, 1);
		
		System.out.println("\n" + r);
		System.out.println("Skaliere um Faktor 1.5...");
		System.out.println("\n" + r);
		
		universal.add(r);
    	universal.add(b1);

		ArrayList<Repeated<Character>> filler = new ArrayList<Repeated<Character>>();
		Repeated<Character> f1 = new FreeBox("apfel\nkuche\nnschm\nechtf\nantas\ntisch");	//FreeBox ist Untertyp von Repeated<Character>
		Repeated<Character> f2 = new FreeBox("abcd\nefgh\nijkm\nlnop\nqrst\nuvwx");
		
		filler.add(f1);
		filler.add(f2);
		universal.add(f1);
		
		Scaled<Repeated<Character>> s = new Scaled<Repeated<Character>>(filler,2,1);
		
		universal.add(s);
		
		Scaled<Pict> all = new Scaled<Pict>(universal,1,1);
		
		System.out.println(all);
		all.scale(1.5);
		System.out.println(all);
		*/
		System.out.println("\n---------------------------------------------------");
		System.out.println("---------------------------------------------------\n");
		System.out.println("Funktionale Tests:\n\n");
		
		System.out.println("Teste Box:");
		
		Box box1 = new Box(6, 6, '*', 'o');
		System.out.println("Box 1 unskaliert:");
		System.out.println(box1 + "\n");
		
		box1.scale(4);
		System.out.println("Box 1 skaliert um den Faktor 4:");
		System.out.println(box1 + "\n");

		box1 = new Box(6, 6, '*', 'o');
		box1.scale(0.5);
		System.out.println("Box 1 skaliert um den Faktor 0.5:");
		System.out.println(box1 + "\n");
		
		box1 = new Box(6, 6, '*', 'o');
		box1.scale(0.5);
		box1.scale(4);
		System.out.println("Box 1 skaliert um die Faktoren 0.5 und 4:");

		System.out.println(box1 + "\n");
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Teste ClearBox:");
		
		ClearBox cbox1 = new ClearBox(6, 6);
		System.out.println("Box 1 unskaliert:");
		System.out.println(cbox1 + "\n");
		
		cbox1.scale(4);
		System.out.println("ClearBox 1 skaliert um den Faktor 4:");
		System.out.println(cbox1 + "\n");

		cbox1 = new ClearBox(6, 6);
		cbox1.scale(0.5);
		System.out.println("ClearBox 1 skaliert um den Faktor 0.5:");
		System.out.println(cbox1 + "\n");
		
		cbox1 = new ClearBox(6, 6);
		cbox1.scale(0.5);
		cbox1.scale(4);
		System.out.println("ClearBox 1 skaliert um die Faktoren 0.5 und 4:");
		System.out.println(cbox1 + "\n");
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Teste DarkBox:");
		
		DarkBox dbox1 = new DarkBox(6, 6, '*');
		System.out.println("DarkBox 1 unskaliert:");
		System.out.println(dbox1 + "\n");
		
		dbox1.scale(4);
		System.out.println("DarkBox 1 skaliert um den Faktor 4:");
		System.out.println(dbox1 + "\n");

		dbox1 = new DarkBox(6, 6, '*');
		dbox1.scale(0.5);
		System.out.println("DarkBox 1 skaliert um den Faktor 0.5:");
		System.out.println(dbox1 + "\n");
		
		dbox1 = new DarkBox(6, 6, '*');
		dbox1.scale(0.5);
		dbox1.scale(4);
		System.out.println("DarkBox 1 skaliert um die Faktoren 0.5 und 4:");
		System.out.println(dbox1 + "\n");
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Teste FreeBox:");
		
		String f = "oooooo\no****o\no****o\no****o\no****o\noooooo";
		FreeBox fbox1 = new FreeBox(f);
		System.out.println("FreeBox 1 unskaliert:");
		System.out.println(fbox1 + "\n");
		
		fbox1.scale(4);
		System.out.println("FreeBox 1 skaliert um den Faktor 4:");
		System.out.println(fbox1 + "\n");

		fbox1 = new FreeBox(f);
		fbox1.scale(0.5);
		System.out.println("FreeBox 1 skaliert um den Faktor 0.5:");
		System.out.println(fbox1 + "\n");
		
		fbox1 = new FreeBox(f);
		fbox1.scale(0.5);
		fbox1.scale(4);
		System.out.println("FreeBox 1 skaliert um die Faktoren 0.5 und 4:");
		System.out.println(fbox1 + "\n");
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Teste Scaled:");
		
		Box test1 = new Box(6, 6, '*', 'o');
		Box test2 = new Box(6, 6, '*', 'o');
		Box test3 = new Box(6, 6, '*', 'o');
		Box test4 = new Box(6, 6, '*', 'o');
		ArrayList<Box> list = new ArrayList<Box>();
		list.add(test1);
		list.add(test2);
		list.add(test3);
		list.add(test4);
		
		Scaled<Box> scale1 = new Scaled<Box>(list, 2, 2);
		System.out.println("Scaled 1 unskaliert:");
		System.out.println(fbox1 + "\n");
		
		scale1.scale(4);
		System.out.println("Scaled 1 skaliert um den Faktor 4:");
		System.out.println(scale1 + "\n");

		scale1 = new Scaled<Box>(list, 2, 2);
		scale1.scale(0.5);
		System.out.println("Scaled 1 skaliert um den Faktor 0.5:");
		System.out.println(scale1 + "\n");
		
		scale1 = new Scaled<Box>(list, 2, 2);
		scale1.scale(0.5);
		scale1.scale(4);
		System.out.println("Scaled 1 skaliert um die Faktoren 0.5 und 4:");
		System.out.println(scale1 + "\n");
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("Teste Repeated:");
		
		Box test5 = new Box(6, 6, '*', 'o');
		Box test6 = new Box(6, 6, '*', 'o');
		Box test7 = new Box(6, 6, '*', 'o');
		Box test8 = new Box(6, 6, '*', 'o');
		ArrayList<Box> list2 = new ArrayList<Box>();
		list2.add(test5);
		list2.add(test6);
		list2.add(test7);
		list2.add(test8);
		
		Repeated<Box> reap1 = new Repeated<Box>(list2, 2, 2);
		System.out.println("Repeated 1 unskaliert:");
		System.out.println(reap1 + "\n");
		
		reap1.scale(4);
		System.out.println("Repeated 1 skaliert um den Faktor 4:");
		System.out.println(reap1 + "\n");

		reap1 = new Repeated<Box>(list2, 2, 2);
		reap1.scale(0.5);
		System.out.println("Repeated 1 skaliert um den Faktor 0.5:");
		System.out.println(reap1 + "\n");
		
		reap1 = new Repeated<Box>(list2, 2, 2);
		reap1.scale(0.5);
		reap1.scale(4);
		System.out.println("Repeated 1 skaliert um die Faktoren 0.5 und 4:");
		System.out.println(reap1 + "\n");
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("---------------------------------------------------\n");
		System.out.println("Untebeziehungstests:\n\n");
		
		System.out.println("ClearBox anstelle von Box:");
		
		Box b1 = new ClearBox(6,3);
		System.out.println(b1);
		double r = 0;
		if(b1 instanceof ClearBox) {
			r = ((ClearBox)b1).getRatio();	
		}
		System.out.println("Seitenverhaeltnis (0 falls keine ClearBox): " + r);
		
		System.out.println("\n---------------------------------------------------\n");
		
		System.out.println("FreeBox anstelle von Repeated<Character>:");
		
		String testreap = "oooooo\no****o\no****o\no****o\no****o\noooooo";
		Repeated<Character> repeated1 = new FreeBox(testreap);
		
		System.out.println("Ausgabe via Repeated<Character>:");
		System.out.println(repeated1);
		
		if(repeated1 instanceof FreeBox) {
			System.out.println("Ausgabe via FreeBox:");
			System.out.println(((FreeBox)repeated1).toString());
		}
		
		} catch	(IllegalArgumentException e) {
		
			System.err.println(e.getMessage());
		
		} catch	(InputMismatchException e) {
			
			System.err.println(e.getMessage());
		}
	}
}