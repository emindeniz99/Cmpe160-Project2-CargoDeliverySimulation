package Util;




public class Cargo{
	
	
	int id;
	Station loadingStation;
	int size;
	Station targetStation;
	
	
	
	public Cargo(int id,Station loadingStation,int size,Station targetStation){
		
		this.id=id;
		
	}
	
	//test ama�l�
	public Cargo(int size) {
		this.size=size;
		
	}
	
	//getter
	public int getSize() {
		return size;
	}
	
	
	@Override
public	String toString(){
		return "";
// prints fields
		
	
	}
	
	
	
}