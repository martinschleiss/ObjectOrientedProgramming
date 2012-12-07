public class Test {
	
	public static void main(String[] args) {
		
		Bauernhof b = new Bauernhof("Hof");
		
		Traktor t1 = new TraktorMitDieselMotor();
		Traktor t2 = new TraktorMitDieselMotor();
		Traktor t3 = new TraktorMitBiogasMotor();
		Traktor t4 = new TraktorMitBiogasMotor();
		
		b.addTraktor(t1);
		System.out.println(b.containsTraktor(t1));//true
		System.out.println(b.containsTraktor(t2));//false
		b.removeTraktor(t1);
		System.out.println(b.containsTraktor(t1));//false
		
	}
}