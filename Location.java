/**
 * 
 * @author Anil
 *
 */
public abstract class Location  implements Comparable<Location>{
	
	private int district;
	private int size;
	private int stageSize;
	
	public Location(int district, int size, int stageSize){
		this.setDistrict(district);
		this.setSize(size);
		this.setStageSize(stageSize);
	}
	public abstract int undefined();

	public int getDistrict() {
		return district;
	}
	// 0<district<24
	public void setDistrict(int district) {
		this.district = district;
	}

	public int getSize() {
		return size;
	}
	//Size>0 
	public void setSize(int size) {
		this.size = size;
	}
	//stageSize>0 
	public int getStageSize() {
		return stageSize;
	}

	public void setStageSize(int stageSize) {
		this.stageSize = stageSize;
	}
	
	public String toString() {
		
		return "District: " + district + ", Size: " + size + ", Stage Size: " + stageSize;
	}
	

	
}
