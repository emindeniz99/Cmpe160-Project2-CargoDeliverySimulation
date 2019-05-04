package CargoTrain;

import java.io.File;
import java.io.PrintStream;
import java.util.Queue;

import Util.Cargo;


public class Train{
	
	private int carCapacity;
	private int length;
	 
	
	public void setLength(int length) {
		this.length = length;
	}

	private  Carriage head;
public void setHead(Carriage head) {
		this.head = head;
	}

public Carriage getHead() {
		return head;
	}

private 	 Carriage tail;

public void setTail(Carriage tail) {
	this.tail = tail;
}

public Carriage getTail() {
	return tail;
}
	
	public Train(int length,int carCapacity){
		this.carCapacity = carCapacity;
		this.length=length;
		
		Carriage temp=head;
		
		if(length>0) 
			{head=temp=new Carriage(carCapacity);}
		tail=head;
		for(int i=1;i<length;i++) {
			temp.addNew();
			
			temp=temp.getNext();
	
			
			tail=temp;
		}
		
		
		
	}
	public void load(Queue<Cargo> cargos) {
		this.length=0;
		this.head=new Carriage(carCapacity);
		
		while(!cargos.isEmpty()) {
			
			
			
			
			Carriage tempHead=head;
			
			Cargo transCargo = cargos.remove();
			while(true) {
		
					if(tempHead.fill(transCargo)) {
					
						break;
					}
					else {
						if(tempHead.getNext()!=null) {

							tempHead=tempHead.getNext();
						}
						else {
							tempHead.addNew();
							tempHead=tempHead.getNext();  
							length++;
						}
					}

			}
			
		}
		
	
	}
	
	
	// Maybe, cargos have some package at the station for loading !!
	public void unload(Queue<Cargo> cargos) {  // from train to station, cargos-parameter represent cargos-queue in station
		Carriage temp=this.head;
		while(temp!=null) {
			while(!temp.getCargos().isEmpty()) {
				cargos.add(temp.getCargos().pop());
			}
			temp=temp.getNext();
			
		}
	
	}
	
	public int getLength() {
		
		return length;
	}
	
	
	
	
	
	
	
}