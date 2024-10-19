

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	
	// instance variables
	private HurricaneRowData value;
	private DoublyLinkedSortedList next = null;
	private DoublyLinkedSortedList previous = null;
	
	
	// overloaded constructor
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
		
		// haha i had that exact problem and spent hours trying to figure out what
		// id done
		// im so impressive
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
		// recursively looks for the first
		if (previous == null) {
			return this;
		}
		else {
			return previous.getFirst();
		}
	}
	
	//Return a reference to the last DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getLast() {
		// recursively looks for the last
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
			// if this is the one to remove, remove this and return
			next.setPrevious(previous);
			previous.setNext(next);
			return this;
		}
		else {
			// if this is not it, keep looking
			return next.remove(toRemove);
		}
	}
	
	//Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	public void insert(HurricaneRowData newValue) {
		
		// this happens for the first value put in the list... I just have it replace the null one
		if (this.value == null && previous == null && next == null) {
			this.value = newValue;
			return;
		}
		
		
		// make a new link and create a few variables
		DoublyLinkedSortedList newLink = new DoublyLinkedSortedList(newValue);
		int thisAce = this.value.getACE();
		int newAce = newValue.getACE();
		
		// if this is the start of the list and newLink should be the new start
		if (previous == null && thisAce < newAce) {
			this.previous = newLink;
			newLink.setNext(this);
		}
		
		// if this is the end of the list and newLink should be the new end
		else if (next == null && thisAce > newAce) {
			this.next = newLink;
			newLink.setPrevious(this);
		}
		
		// if newLink should go right after this
		else if (thisAce > newAce && next.value.getACE() < newAce) {
			newLink.setNext(next);
			newLink.setPrevious(this);
			
			next.setPrevious(newLink);
			this.setNext(newLink);
		}
		
		// if we should keep looking down the list (equal ace values are put after)
		else if (thisAce >= newAce) {
			next.insert(newValue);
		}
		
		// if we should keep looking up the list
		else if (thisAce < newAce) {
			previous.insert(newValue);
		}
		
	}
	
	//Return the entire list as a multi-line String
	public String toString() {
		// recursively get each line
		String toReturn = value.toString() + "\n";
		
		if (next != null) {
			toReturn += next.toString();
		}
		
		return toReturn;
	}
	
	// returns the size of the cuurent link. Needed for debugging
	public int size() {
		int toAdd = 0;
		if (this.hasNext()) {
			toAdd = next.size();
		}
		return 1 + toAdd;
	}
}