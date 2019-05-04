


package Util;

import java.io.File;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

import CargoTrain.Carriage;
import CargoTrain.Train;

public class Station  {
	private int id;
	public int getId() {
		return id;
	}

	private Queue<Cargo> cargoQueue;
	
	public Queue<Cargo> getCargoQueue() {
		return cargoQueue;
	}

	PrintStream writer;
	
	
	public Station(int id,PrintStream writer) {
		this.id=id;
		this.writer=writer;
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
		
		
		train.setHead(null);
		train.setTail(null);
		
		int size=this.cargoQueue.size();
		
		for(int i=0;i<size;i++) {
				Cargo temp=this.cargoQueue.poll();
				
			if(temp.getTargetStation().id==this.id) {
							
				writer.println(temp.toString());
								
	//						tempqu.add(temp);
	//						i++;
							
						}
						else {
							cargoQueue.add(temp);
						}
				
		}
		
		
		train.load(cargoQueue);
		writer.println(this.id+" "+this.getLen(train));
		/*
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
		
	//	System.out.println(this.id+" "+train.getLength());  // bu gerekli
		System.out.println(this.id+" "+this.getLen(train));
		// to access writer, you can use train.writer
		
		
		//
//		System.out.println();
		*/
	}
	
	public int getLen(Train train) {
//		System.out.println(train.head);
		
		if(train.getHead()==null) {
			return 0;
			
		}
		
		if(train.getHead().getCargos().isEmpty()) {
			return 0;
		}
		Carriage th=train.getHead();
		int len=0;
		while(!th.getCargos().isEmpty()) {
			len++;
			if(th.getNext()!=null) {
				th=th.getNext();
			}else {
				break;
			}
			
		}
		return len;
	}
	
	public void getLen() {
		System.out.println(this.cargoQueue.size());
		
	}
	
	
}