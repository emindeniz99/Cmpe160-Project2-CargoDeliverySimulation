


package Util;

import java.util.LinkedList;
import java.util.Queue;

import CargoTrain.Train;

public class Station{
	public int id;
	public Queue<Cargo> cargoQueue;
	
	public Station(int id) {
		this.id=id;
		cargoQueue=new LinkedList<>();
	}
	
	

	
	//Printstream
	
//	cargoQueue= ;
//	
	
	
	//initial cargos waiting at the station
	public void addCargo(int id,Station loadingStation,int size,Station targetStation) {
		cargoQueue.add(new Cargo(id,loadingStation,size,targetStation));
		
		
		
	}
	
	public void process(Train train) { /// iþlemleri burada yap ve file a da burada yazdýr
//		cargoQueue=new LinkedList<>();
		
		train.unload(cargoQueue);
		
//		System.out.println("size"+this.cargoQueue.size());
		int size=this.cargoQueue.size();
		
		Queue<Cargo> tempqu=new LinkedList(); ;// kenarda dursun durakta bekleyecek
		
		for(int i=0;i<size;i++) {
			Cargo temp=cargoQueue.poll();
//			cargoQueue.add(temp);
//			System.out.println("1");
//			System.out.println(cargoQueue.toString());
//			System.out.println(temp.targetStation);
			if(temp.targetStation.id==this.id) {
				
				System.out.println(temp.id+" "+temp.loadingStation.id
				+" "+temp.targetStation.id+" "+temp.size);
					
				tempqu.add(temp);
				//i++;
				
			}
			else {
				cargoQueue.add(temp);
			}
//			cargoQueue.add(temp);
//			System.out.println("bitt");
		}
		
		train.load(cargoQueue);
		
		
		this.cargoQueue.addAll(tempqu);
		
		System.out.println(this.id+" "+train.getLength());  // bu gerekli
		
		// to access writer, you can use train.writer
		
		
		//
//		System.out.println();
		
	}
	
	public void getLen() {
		System.out.println(this.cargoQueue.size());
		
	}
	
	
}