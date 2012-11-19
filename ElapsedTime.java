public class ElapsedTime implements Shorter{
	private Double time; //>0
	protected Double variable;	//wird fuer Untertypen benoetigt um Vergleiche durchfuehren zu koennen
	

	public ElapsedTime(Double time){
		this.time=time;
	}
	
	/**
	 * weil casting nicht erlaubt, wird diese Methode nie benoetigt 
	 * ..fraglich, denn wiese ist dann ElapsedTime ein Untertyp von Shorter?
	 */
	public boolean shorter(Shorter other){
		Boolean check=false;
		/*
		if (this.getClass() == other.getClass()){
			ElapsedTime et=(ElapsedTime) other;
			check= this.time<et.time;
		}*/
		
		return check;
	}
	/**
	 * 
	 * @param other
	 * @return  gibt true zurueck wenn time < other ist
	 */
	
	public boolean shorter(ElapsedTime other){
		
		return this.time<other.time;
	}
	/**
	 * gibt die laenge  zurueck, ist fuer ElapsedTime immer eins
	 */
	public int count(){
		return 1;
	}

}
