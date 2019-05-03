


package Util;

import java.util.LinkedList;
import java.util.Queue;

import CargoTrain.Train;

public class Station{
	int id;
	Queue<Cargo> cargoQueue;
	
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
		
		
		
		//
		System.out.println();
		
	}
	
}