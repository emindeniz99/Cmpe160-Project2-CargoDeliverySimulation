


package Util;

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
	
	
	

	
	//initial cargos waiting at the station
	public void addCargo(int id,Station loadingStation,int size,Station targetStation) {
		cargoQueue.add(new Cargo(id,loadingStation,size,targetStation));
		
		
		
	}
	
	public void process(Train train) { 

		
		train.unload(cargoQueue);
		
		
		train.setHead(null);
		train.setTail(null);
		
		int size=this.cargoQueue.size();
		
		for(int i=0;i<size;i++) {
				Cargo temp=this.cargoQueue.poll();
				
			if(temp.getTargetStation().id==this.id) {
							
				writer.println(temp.toString());
		
							
						}
						else {
							cargoQueue.add(temp);
						}
				
		}
		
		
		train.load(cargoQueue);
		
		
		
		writer.println(this.id+" "+this.getLenandFixTail(train));
		
	}
	





	private int getLenandFixTail(Train train) {
	
		if(train.getHead()==null) {
			return 0;
			
		}
		
		if(train.getHead().getCargos().isEmpty()) {
			return 0;
		}
		Carriage th=train.getHead();
		int len=0;
		
		Carriage backup=th;
		while(!th.getCargos().isEmpty()) {
			len++;
			backup=th;
			if(th.getNext()!=null) {
				
				th=th.getNext();
				
			}else {
				break;
			}
			
		}
		
		train.setTail(backup);
		
		
		train.setLength(len);  // fix the length 
		return len;
		
	}
	
	
	
	
}