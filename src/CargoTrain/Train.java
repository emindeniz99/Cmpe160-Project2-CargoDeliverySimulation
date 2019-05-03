package CargoTrain;

import java.util.Queue;

import Util.Cargo;


public class Train{
	
	 int carCapacity;
	 int length;
	 
	 
//	int emptySlot;
//	Stack<Cargo> cargos;
	
	Carriage head;
	Carriage tail;
	
	
	public Train(int length,int carCapacity){
		this.carCapacity = carCapacity;
		this.length=length;
		
		Carriage temp=head;
		
		if(length>0) 
			{head=temp=new Carriage(carCapacity);}
		
		for(int i=1;i<length;i++) {
			temp.addNew();
			
			temp=temp.next;
			// veya üsttekiler þöyle yazýlabilir temp=temp.addNew();
			
			tail=temp;
		}
		
		
		
	}
	public void load(Queue<Cargo> cargos) {
//		Carriage tempHead=head;
		Carriage tempTail=tail; // kalaný kesip atmak için , ÇAlýþmýyor :(
		
		while(!cargos.isEmpty()) {
			Carriage tempHead=head;
			
			Cargo transCargo = cargos.remove();
			while(true) {
//				if(tempHead!=null) {
					if(tempHead.fill(transCargo)) {
						break;
					}
					else {
						if(tempHead.next!=null) {

							tempHead=tempHead.next;
						}
						else {
							tempHead.addNew();
							
						}
					}
//				}
//				else {
//					
//				}
			}
			
		}
		
		
		
	}
	
	
	// Maybe, cargos have some package at the station for loading !!
	public void unload(Queue<Cargo> cargos) {  // from train to station, cargos-parameter represent cargos-queue in station
		Carriage temp=this.head;
		while(temp!=null) {
			while(!temp.cargos.isEmpty()) {
				cargos.add(temp.cargos.pop());
			}
			temp=temp.next;
			
			
		}
		
		
		
		
		
	}
}