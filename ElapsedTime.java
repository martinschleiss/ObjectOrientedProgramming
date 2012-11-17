
public class ElapsedTime implements Shorter{
	private Double time; //>0
	

	public ElapsedTime(Double time){
		this.time=time;
		
	}
	
	/**
	 * gibt true zurueck wenn time < other ist
	 */
	public boolean shorter(Shorter other){
		
		return this.time<other.getLength();
	}
	
	/**
	 * gibt time zurueck, genaue Bedeutung von Untertypen abhängig (da stimmt noch was nicht!!!)
	 */
	
	public Double getLength(){
		
		return time;
	}
	
	/**
	 * gibt die laenge  zurueck, genaue Bedeutung von Untertypen abhängig (da stimmt noch was nicht!!!)
	 */
	public int count(){
		return 1;
	}

}
