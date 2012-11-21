public class ElapsedTime implements Shorter<ElapsedTime> {
	private Double time; //>0
	protected Double variable;	//wird fuer Untertypen benoetigt um Vergleiche durchfuehren zu koennen
	

	public ElapsedTime(Double time){
		
		this.time = time;
	}
	
	/**
	 * 
	 * @param other
	 * @return  gibt true zurueck wenn time < other ist
	 */
	public boolean shorter(ElapsedTime other){
		
		return this.time < other.time;
	}
	
	/**
	 * gibt die laenge  zurueck, ist fuer ElapsedTime immer eins
	 */
	public int count(){
		return 1;
	}

}
