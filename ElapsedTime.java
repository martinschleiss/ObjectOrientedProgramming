public class ElapsedTime implements Shorter<ElapsedTime> {
	
	private Double time; //>0	

	public ElapsedTime(Double time){
		
		this.time = time;
	}
	
	/**
	 * 
	 * @param other
	 * @return  gibt true zurueck wenn Vergleichmass von this < Vergleichsmass von other ist.
	 */
	public boolean shorter(ElapsedTime other){
		
		return this.getMessure() < other.getMessure();
	}
	
	/**
	 * Liefert Vergleichsmass fuer shorter()
	 * @return		verstrichene Zeit
	 */
	public double getMessure() {
		
		return this.time;
	}
	
	/**
	 * gibt die Anzahl der Messungen zurueck, ist fuer ElapsedTime immer eins
	 */
	public int count(){
		return 1;
	}
	
	public String toString() {
		
		return "ElapsedTime: " + time;
	}
}
