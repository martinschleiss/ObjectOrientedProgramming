import java.util.Iterator;


public class MeanElapsedTime extends ElapsedTime{

	private Set<Double> measuredData; //gemessene Werte
	
	public MeanElapsedTime(Double data){
		
		super(data);
		
		measuredData=new  Set<Double>();
		measuredData.insert(data);
	}
	
	/**
	 * fuegt neuen Messwert hinzu
	 * @param data
	 */
	public void addData(Double data){
		measuredData.insert(data);
	}
	
	/**
	 * gibt true zuruek, wenn der durchschnitt dieser Instanz kleiner ist als other
	 * 
	 * muss noch geeandert werden, weil casting nicht erlaubt ist laut Angabe
	 */
	
	 @Override
	public boolean shorter(Shorter other){

		Boolean check=false;
		
		if (this.getClass() == other.getClass()){
			MeanElapsedTime mt=(MeanElapsedTime) other;
			check= this.average()<mt.average();
			
		}
		
		return check;
		
	}
	
	/**
	 * gibt den größten Messwert zuruek
	 */
	public Double major(){
		
		Iterator<Double> it=measuredData.iterator();
		
		Double major=0.0;
		Double help;
		
		while (it.hasNext()) {
			
			help=it.next();
			
			if(help>major){
				major=help;
			}
		}	
		
		return major;
		
	}
	
	/**
	 * gibt den Durchschnitt der messwerte zuruek
	 */
	public Double average(){
		Iterator<Double> it=measuredData.iterator();
		Double sum=0.0;
		int counter=0;
		
		while (it.hasNext()) {
			
			sum +=it.next();
			counter++;
		}	
		
		return sum/counter;
	}
	
	/**
	 * gibt die Anzahl der Messwerte zuruek
	 */
	public int count(){
		Iterator<Double> it=measuredData.iterator();
		
		int counter=0;
		
		while (it.hasNext()) {
			
			it.next();
			counter++;
		}	
		return counter;
	}

}


