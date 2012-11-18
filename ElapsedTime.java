public class ElapsedTime implements Shorter{
	private Double time; //>0
	

	public ElapsedTime(Double time){
		this.time=time;
		
	}
	
	/**
	 * gibt true zurueck wenn time < other ist
	 * muss noch geeandert werden, weil casting nicht erlaubt ist laut Angabe
	 */
	public boolean shorter(Shorter other){
		Boolean check=false;
		
		if (this.getClass() == other.getClass()){
			ElapsedTime et=(ElapsedTime) other;
			check= this.time<et.time;
			
		}
		
		return check;
	}
	/**
	 * gibt die laenge  zurueck, genaue Bedeutung von Untertypen abhängig (da stimmt noch was nicht!!!)
	 */
	public int count(){
		return 1;
	}

}
