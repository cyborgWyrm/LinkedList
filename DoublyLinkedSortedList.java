
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	
	private HurricaneRowData value;
	private DoublyLinkedSortedList next;
	private DoublyLinkedSortedList previous;
	
	
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
		
		return null; // placeholder
	}
	
	//Remove the DoublyLinkedSortedList element that has toRemove as its value
	public DoublyLinkedSortedList remove(HurricaneRowData toRemove) {
		
		return null; // placeholder
	}
	
	//Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	public void insert(HurricaneRowData newValue) {
		
	}
	
	//Return the entire list as a multi-line String
	public String toString() {
		
		return null; // placeholder
	}
	
}