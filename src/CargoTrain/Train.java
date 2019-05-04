package CargoTrain;

import java.io.File;
import java.io.PrintStream;
import java.util.Queue;

import Util.Cargo;


public class Train{
	
	 int carCapacity;
	 int length;
	 
	 
//	int emptySlot;
//	Stack<Cargo> cargos;
	
	Carriage head;
	Carriage tail;
	
//	//Moved from main
//		File output = new File("output.txt");
//		
//		PrintStream  writer=new PrintStream(output);
//	
	
	public Train(int length,int carCapacity){
		this.carCapacity = carCapacity;
		this.length=length;
		
		Carriage temp=head;
		
		if(length>0) 
			{head=temp=new Carriage(carCapacity);}
		tail=head;
		for(int i=1;i<length;i++) {
			temp.addNew();
			
			temp=temp.next;
			// veya üsttekiler þöyle yazýlabilir temp=temp.addNew();
			
			tail=temp;
		}
		
		
		
	}
	public void load(Queue<Cargo> cargos) {
//		Carriage tempHead=head;
//		Carriage tempTail=tail; // kalaný kesip atmak için , ÇAlýþmýyor :(
		
		while(!cargos.isEmpty()) {
			Carriage tempHead=head; // head boþsa ????   ------ !!!!
			
			Cargo transCargo = cargos.remove();
			while(true) {
//				if(tempHead!=null) {
					if(tempHead.fill(transCargo)) {
//						tempTail=tempHead;  // experi
						break;
					}
					else {
						if(tempHead.next!=null) {

							tempHead=tempHead.next;
						}
						else {
							tempHead.addNew();
							tempHead=tempHead.next;  // eklemeeeeeeeee yaptým
							length++; //experiment
						}
					}
//				}
//				else {
//					
//				}
			}
			
		}
//		this.tail=tempTail;
//		this.tail.next=null;
		
		int len=0;
		Carriage tempHead=head;
		Carriage tempTail=head;
		
		while(tempHead!=null) {
			if(!tempHead.cargos.isEmpty()) {
				len++;
				tempTail=tempHead;
			
				tempHead=tempHead.next;
//				System.out.println("dd");
			}
				else {
				
				
				
				break;
			}
			
			
		}
		if ( head!=null) { 
			if(head.cargos.isEmpty()) {
			tempTail=null;
//			this.head=null;
			
			
		}
		}
		
		this.length=len;
		this.tail=tempTail;
		if(this.tail!=null ) this.tail.next=null;  // bunu ekledim 16:56
		
	}
	
	
	// Maybe, cargos have some package at the station for loading !!
	public void unload(Queue<Cargo> cargos) {  // from train to station, cargos-parameter represent cargos-queue in station
		Carriage temp=this.head;
		while(temp!=null) {
			while(!temp.cargos.isEmpty()) {
				cargos.add(temp.cargos.pop());
			}
//			System.out.println("yükleniyor");
			temp=temp.next;
			
		}
	
	}
	
	public int getLength() {
		
		return length;
	}
	
	
	
	
	
	
	
}