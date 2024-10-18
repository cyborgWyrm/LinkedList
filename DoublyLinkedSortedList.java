
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	
	private HurricaneRowData value;
	private DoublyLinkedSortedList next = null;
	private DoublyLinkedSortedList previous = null;
	
	
	// constructor
	public DoublyLinkedSortedList(HurricaneRowData value) {
		this.value = value;
	}
	public DoublyLinkedSortedList() {
		this.value = null;
	}
	
	
	
	//Get the value of the current DoublyLinkedSortedList
	public HurricaneRowData getValue() {
		return this.value;
	}
	
	//Return true if next is not null
	public boolean hasNext() {
		if (next != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Set next to be the given DoublyLinkedSortedList
	public void setNext(DoublyLinkedSortedList next) {
		this.next = next;
		// should it also make next's previous this? Same for setPrevious
		// it feels dangerous for this to be public and not set the corresponding
		// value. you could end up with mismatching next and previous...
	}
	
	//Return a reference to the next DoublyLinkedSortedList
	public DoublyLinkedSortedList getNext() {
		return next;
	}
	
	//Return true if previous is not null
	public boolean hasPrevious() {
		if (previous != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Set previous to be the given DoublyLinkedSortedList
	public void setPrevious(DoublyLinkedSortedList previous) {
		this.previous = previous;
	}
	
	//Return a reference to the previous DoublyLinkedSortedList
	public DoublyLinkedSortedList getPrevious() {
		return previous;
	}
	
	//Return a reference to the first DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getFirst() {
		if (previous == null) {
			return this;
		}
		else {
			return previous.getFirst();
		}
	}
	
	//Return a reference to the last DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getLast() {
		if (next == null) {
			return this;
		}
		else {
			return next.getLast();
		}
	}
	
	//Remove the DoublyLinkedSortedList element that has toRemove as its value
	public DoublyLinkedSortedList remove(HurricaneRowData toRemove) {
		if (value == toRemove) {
			next.setPrevious(previous);
			previous.setNext(next);
			return this;
		}
		else {
			return next.remove(toRemove);
		}
	}
	
	//Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	public void insert(HurricaneRowData newValue) {
		if (this.value == null && previous == null && next == null) {
			this.value = newValue;
			//System.out.print(0);
			return;
		}
		
		DoublyLinkedSortedList newLink = new DoublyLinkedSortedList(newValue);
		int thisAce = this.value.getACE();
		int newAce = newValue.getACE();
		
		if (previous == null && thisAce < newAce) {
			this.previous = newLink;
			//System.out.print(1);
		}
		else if (next == null && thisAce > newAce) {
			this.next = newLink;
			//System.out.print(2);
		}
		else if (thisAce > newAce && next.value.getACE() < newAce) {
			next.previous = newLink;
			this.next = newLink;
			//System.out.print(3);
		}
		else if (thisAce > newAce) {
			//System.out.print(4);
			next.insert(newValue);
		}
		else if (thisAce < newAce) {
			//System.out.print(5);
			previous.insert(newValue);
		}
		else {
			//System.out.println(6);
		}
		
		
		
		/*if (value == null && next == null && previous == null) {
			value = newValue;
		}
		else if (value.getACE() > newValue.getACE()) {
			// if this ace is greater than the new ace, the new ace goes somewhere after
			if (next != null) {
				next.insert(newValue);
			}
			else {
				next = new DoublyLinkedSortedList(newValue);
				next.setPrevious(this);
			}
		}
		else {
			// if this ace <= new ace, insert new value in front
			
			if (previous != null) {
				DoublyLinkedSortedList newLink = new DoublyLinkedSortedList(newValue);
				previous.setNext(newLink);
				previous = newLink;
			}
			else {
				previous = new DoublyLinkedSortedList(newValue);
				previous.setNext(this);
			}
		}*/
	}
	
	//Return the entire list as a multi-line String
	public String toString() {
		String toReturn = value.toString() + "\n";
		//System.out.println(value.getYear() + " " + previous + " " + next);
		
		if (next != null) {
			toReturn += next.toString();
		}
		
		return toReturn;
	}
	
}