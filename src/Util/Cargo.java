package Util;




public class Cargo{
	
	
public 	int id;
	public Station loadingStation;
public 	int size;
	public  Station targetStation;
	
	
	
	public Cargo(int id,Station loadingStation,int size,Station targetStation){
		
		this.id=id;
		this.loadingStation=loadingStation;
		this.size=size;	
		this.targetStation=targetStation;
	
	}
	
	//test amaçlý
	public Cargo(int size) {
		this.size=size;
		
	}
	
	//getter
	public int getSize() {
		return size;
	}
	
	
	@Override
public	String toString(){
		return ""+ this.id+" "+this.loadingStation+" "+this.targetStation+" "+this.size;
// prints fields
		
	
	}
	
	
	
}