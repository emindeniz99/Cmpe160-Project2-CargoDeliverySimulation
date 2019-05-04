
package CargoTrain;
import java.util.Stack;
import Util.Cargo;



public class Carriage{
	
	
	private int capacity;
	private int emptySlot;
	private Stack<Cargo> cargos;
	
	public Stack<Cargo> getCargos() {
		return cargos;
	}

	private Carriage next;
	public Carriage getNext() {
		return next;
	}

	private  Carriage prev;
	
	
	public Carriage getPrev() {
		return prev;
	}


	public Carriage(int capacity){
		this.emptySlot = this.capacity = capacity;
		
	
		cargos=new Stack<>();
		
		
		
	}
	
	
	// add New Carriage at the end of the train
	public Carriage addNew() {
		
		this.next=new Carriage(this.capacity);
		this.next.prev=this;
	return	this.next;
		
		
	}
	
	

	
	
	public boolean isFull() {
		return emptySlot==0;
	}
	
	
	 void push(Cargo cargo) {
		cargos.push(cargo);
		this.emptySlot-=cargo.getSize();
		
	}
	
	 Cargo pop() {

		Cargo temp=cargos.pop();
		this.emptySlot+=temp.getSize();
		return temp;
		
	}
	
	 boolean fill(Cargo cargo) {
		if(cargo.getSize()<=this.emptySlot) {
			this.push(cargo);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
}