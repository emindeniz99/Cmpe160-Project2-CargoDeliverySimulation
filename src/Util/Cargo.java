package Util;




public class Cargo{
	
	
private int id;
	private Station loadingStation;
private int size;
	private  Station targetStation;
	
	
	
	public Cargo(int id,Station loadingStation,int size,Station targetStation){
		
		this.id=id;
		this.loadingStation=loadingStation;
		this.size=size;	
		this.targetStation=targetStation;
	
	}
	
	
	//getter
public int getSize() {
		return size;
	}
	Station getLoadingStation() {
		return loadingStation;
	}
	int getId() {
		return size;
	}
	Station getTargetStation() {
		return targetStation;
	}
	
	
	@Override
public	String toString(){
		return ""+ this.id+" "+this.loadingStation.getId()+" "+this.targetStation.getId()+" "+this.size;
// prints fields
		
	
	}
	
	
	
}