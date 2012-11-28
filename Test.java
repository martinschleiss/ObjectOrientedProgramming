public class Test {
	
	public static void main(String args[]) {

		AndroidFactory f = new AndroidFactory();
		Shop sh=new Shop();

		System.out.println("############################## Test 1.a ##############################\n");
		System.out.println("Erstelle Bauarbeiter mit Bauarbeiter-Software, Sicherheitstufe 3, einem 3kW-Kit und hochfestem Skin...\n");
		
		Androide a1 = new Bauarbeiter();
		Sicherheitsstufe s1 = new SicherheitsstufeDrei();
		Software software1 = new SoftwareBauarbeiter(a1,s1);
		Skin skin1 = new SkinHochfest(a1);
		Kit kit1 =new Kit3kW("Bauarbeiterkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Ergebnis:\n\n" + a1 +  "\n");
		
		System.out.println("\n############################## Test 1.b ##############################\n");
		System.out.println("Fuege Bauarbeiter in Shop ein... (Erwartet: Einfuegen funktioniert)\n");
		System.out.println("Ergebnis:\n\n" + sh.insert(a1) +  "\n");
		
		System.out.println("\n############################## Test 1.c ##############################\n");
		System.out.println("Aendere Software von Bauarbeiter auf Kaempfer-Software der Sicherheitsstufe 3...");
	
		software1 = new SoftwareKaempfer(a1,s1);
		a1.updateSoftware(software1);
		System.out.println("Ergebnis:\n\n" + a1 +  "\n");
		
		System.out.println("\n############################## Test 1.d ##############################\n");
		System.out.println("Fuege Bauarbeiter in Shop ein... (Erwartet: Einfuegen schlaegt fehl)\n");
		System.out.println("Ergebnis:\n\n" + sh.insert(a1) +  "\n");
	
		System.out.println("############################## Test 2.a ##############################\n");
		System.out.println("Erstelle gueltige Instanz von jedem Untertypen von Androide und fuege in Shop ein...\n");
		
		a1 = new Bauarbeiter();
		s1 = new SicherheitsstufeDrei();
		software1 = new SoftwareBauarbeiter(a1,s1);
		skin1 = new SkinSensitiv(a1);
		kit1 =new Kit1kW("Bauarbeiterkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neuer Bauarbeiter:\t\t" + sh.insert(a1) +  "\n");
		
		a1 = new Gesellschafter();
		s1 = new SicherheitsstufeEins();
		software1 = new SoftwareGesellschafter(a1,s1);
		skin1 = new SkinSensitiv(a1);
		kit1 =new Kit1kW("Gesellschafterkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neuer Gesellschafter:\t\t" + sh.insert(a1) +  "\n");
		
		a1 = new Hilfskraft();
		s1 = new SicherheitsstufeZwei();
		software1 = new SoftwareHilfskraft(a1,s1);
		skin1 = new SkinSensitiv(a1);
		kit1 =new Kit1kW("Hilfskraftkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neue Hilfskraft:\t\t" + sh.insert(a1) +  "\n");
		
		a1 = new Kaempfer();
		s1 = new SicherheitsstufeFuenf();
		software1 = new SoftwareKaempfer(a1,s1);
		skin1 = new SkinGepanzert(a1);
		kit1 =new Kit21kW("Kaempferkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neuer Kaempfer:\t\t\t" + sh.insert(a1) +  "\n");
		
		a1 = new Leibwaechter();
		s1 = new SicherheitsstufeVier();
		software1 = new SoftwareLeibwaechter(a1,s1);
		skin1 = new SkinHochfest(a1);
		kit1 =new Kit7kW("Leibwaechterkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neuer Leibwaechter:\t\t" + sh.insert(a1) +  "\n");
		
		a1 = new Objektbewacher();
		s1 = new SicherheitsstufeVier();
		software1 = new SoftwareObjektbewacher(a1,s1);
		skin1 = new SkinGepanzert(a1);
		kit1 =new Kit7kW("Objektbewacherkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neuer Objektbewacher:\t\t" + sh.insert(a1) +  "\n");
		
		Androide a2 = new Servicetechniker();
		s1 = new SicherheitsstufeDrei();
		software1 = new SoftwareServicetechniker(a1,s1);
		skin1 = new SkinHochfest(a1);
		kit1 =new Kit1kW("Servicetechnikerkit",a1);
		f.create(a2, kit1, skin1, software1);
		System.out.println("Neuer Servicetechniker:\t\t" + sh.insert(a1) +  "\n");
		
		a1 = new Transportarbeiter();
		s1 = new SicherheitsstufeVier();
		software1 = new SoftwareTransportarbeiter(a1,s1);
		skin1 = new SkinSensitiv(a1);
		kit1 =new Kit7kW("Transportarbeiterkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Neuer Transportarbeiter:\t" + sh.insert(a1) +  "\n");
		
		System.out.println("############################## Test 2.b ##############################\n");
		System.out.println("Erstellen von Iterator und Ausgabe aller Androiden in Shop...");
		System.out.println("(Erwartet: Anzahl 8, Seriennummern 2-9)\n");
		Iterator<Androide> i=sh.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		System.out.println("############################## Test 3 ##############################\n");
		System.out.println("Suche und Ausgabe von Android mit Seriennummer 8...\n");
		System.out.println("(Erwartet: Servicearbeiter)\n");
		System.out.println(sh.find(8));
		
		System.out.println("############################## Test 4.a: Kits ##############################\n");
		System.out.println("Aendere Servicetechniker-Kit von Servicetechniker mit Sicherheitststufe 3 auf staerkeres Kit mit 7kW");
		System.out.println("(Erwartet: Insert schlaegt fehl, da kW-Grenze fuer Software-Sicherheitsstufe 3 ueberschritten wird\n");
		
		a2.updateKit(new Kit7kW("ServicetechnikerKit-Plus",a2));
		System.out.println(a2);
		System.out.println("Insert von Servicetechniker:\t" + sh.insert(a2) +  "\n");
		
		System.out.println("############################## Test 4.b: Kits ##############################\n");
		System.out.println("Aendere Servicetechniker-Software auf Stufe 4 und versuche erneut Upgrade auf staerkeres Kit mit 7kW");
		System.out.println("(Erwartet: Insert gelingt, da kW-Grenze fuer Software-Sicherheitsstufe 4 nicht mehr ueberschritten wird\n");
		
		a2.updateSoftware(new SoftwareServicetechniker(a2,new SicherheitsstufeVier()));
		System.out.println(a2);
		System.out.println("Insert von Servicetechniker:\t" + sh.insert(a2) +  "\n");
	}
	
}