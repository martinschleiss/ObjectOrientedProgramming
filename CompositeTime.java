

public class CompositeTime extends ElapsedTime {

	private Double [] totalTime;


	public CompositeTime( Double [] totalTime) {
		super(sum(totalTime));
		this.totalTime=totalTime;


	}
	/**
	 * Nur fuer die Super() Methode relevant
	 * @param totTime
	 * @return summe aller Werte aus dem Array
	 */
	private static Double sum( Double [] totTime){
		Double sum=0.0;
		for(int i=0;i<totTime.length;i++){
			sum+=totTime[i];
		}
		return sum;
	}
	/**
	 * muss noch geeandert werden, weil casting nicht erlaubt ist laut Angabe
	 */
	@Override
	public boolean shorter(Shorter other){

		Boolean check=false;

		if (other instanceof CompositeTime){
			CompositeTime ct=(CompositeTime) other;
			check= this.sum()<ct.sum();

		}
		return check;
	}

	/**
	 * totalTime != null
	 * @return  summe aller Werte aus dem Array
	 */
	private Double sum(){
		Double sum=0.0;
		for(int i=0;i<totalTime.length;i++){
			sum+=totalTime[i];
		}
		return sum;
	}

	/**
	 *  totalTime != null
	 * @return kleinster Wert aus dem Array
	 */
	public Double shortest(){

		Double shortest=Double.MAX_VALUE;

		for(int i=0;i<totalTime.length;i++){
			if(totalTime[i]<shortest){
				shortest=totalTime[i];
			}
		}
		return shortest;
	}
}