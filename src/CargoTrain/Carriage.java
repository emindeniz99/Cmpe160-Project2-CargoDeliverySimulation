
package CargoTrain;

import java.util.Stack;

import Util.Cargo;



public class Carriage{
	
	
	int capacity;
	int emptySlot;
	public Stack<Cargo> cargos;
	
	Carriage next;
	Carriage prev;
	
	
	public Carriage(int capacity){
		this.emptySlot = this.capacity = capacity;
		
	
		cargos=new Stack<>();
		
		
		
	}
	
	
	// hepsi dolduysa sondakine gelince �a��r bunu
	public Carriage addNew() {
		
		this.next=new Carriage(this.capacity);
		this.next.prev=this;
	return	this.next;
		
		
	}
	
	
	// ortadaysa �al���yor ama ba� ve sonra �al��maz muhtemelen
	
	// aaa asl�nda asla ortadan kesmeyiz ki, load unload yap�nca ba�tan
	//doldurmaya ba�l�yor, bu sebeple hep sondan keseriz, e�er bombo�sa hepsini null yapar�z
	
//	public void deleteCurrent() {
//		if(this.prev==null) {
//			
//			//??
//		}
//		else if(this.next==null) {
//			this.prev.next=null;
//			
//		}
//		else {
//			
//			this.prev.next=this.next;
//			this.next.prev=this.prev;
//			
//		}
//		
//	}
	
	
	public boolean isFull() {
		return emptySlot==0;
	}
	
	
	public void push(Cargo cargo) {
		cargos.push(cargo);
		this.emptySlot-=cargo.getSize();
		
	}
	
	public Cargo pop() {

		Cargo temp=cargos.pop();
		this.emptySlot+=temp.getSize();
		return temp;
		
	}
	
	public boolean fill(Cargo cargo) {
		if(cargo.getSize()<=this.emptySlot) {
			this.push(cargo);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
}