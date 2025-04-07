/**
 * @author Michael Levet
 * @date August 27, 2023
 */

//until a point, i did not know we had size() so there are many lines of code that could've
//used a definite loop ;/
public class LinkedListADT<T> implements ListADT<T> {

	@SuppressWarnings("hiding")
	class Node<T>{
		Node<T> previous, next;
		T elem;
		
	}

	private Node<T> head, tail;
	public int size = 0;
	
	
	public LinkedListADT(){
		this.head = this.tail = null;
	}
	
	
	
	public String toString(){
		if(this.head == null){
			return "[]";
		}
		
		else if(this.head.next == null){
			return "[" + this.head.elem + "]";
		}
		
		Node<T> temp = this.head;
		String str = "[";
		while(temp.next != null){
			str += temp.elem.toString() + ", ";
			temp = temp.next;
		}
		
		str += temp.elem.toString() + "]";
		return str;
	}
	
	
	/**
	 * @param elem: The element to add to the end of the list
	 */ 
	public void add(T elem){
		if(this.head == null){
			this.head = new Node<T>();
			this.head.elem = elem;
			this.tail = this.head;
		}
		
		else{
			this.tail.next = new Node<T>();
			this.tail.next.previous = this.tail;
			this.tail = this.tail.next;
			this.tail.elem = elem;
		}
		this.size++;
		
	}
	
	
	/**
	 * @param index: The index at which to insert the new element
	 * @param elem: The element to insert inot the list at position @index.
	 * 
	 * Inserts @elem at position @index in the list. Any element at position @index
	 * or later in the list prior to this method being invoked should be moved
	 * one index down (so the element at position @index prior to this method being invoked
	 * should end up at position @index+1 after this method terminates).
	 */
	public void add(int index, T elem){
		if(index > this.size)
			throw new IndexOutOfBoundsException("The index: " + index + " is out of bounds."); 
		else if(this.head == null || index == this.size) {
				this.add(elem);
		}
		else if(index == 0){
				this.head.previous = new Node<T>();
				this.head.previous.next = this.head;
				this.head = this.head.previous;
				this.head.elem = elem;
		}	
		else {
			Node<T> goNext = this.head;
			int i = 0;
			while(i < index && goNext != null){
				goNext = goNext.next;
				i++;
			}
			goNext.previous.next  = new Node<T>();
			goNext.previous.next.elem = elem;
			goNext.previous.next.previous = goNext.previous;
			goNext.previous = goNext.previous.next;
			goNext.previous.next = goNext;	
		}
		this.size++;
	}
	
	
	/**
	 * @param index: The index of the element to return
	 * @return T: The element located at @index to return
	 */
	public T get(int index){
		if(index >= this.size) {
			throw new IndexOutOfBoundsException("The index: " + index + " is out of bounds or there "
					+ "is nothing here."); 
		}
		Node<T> goNext = this.head;
		int i = 0;
		while(i < index){
			goNext = goNext.next;
			i++;
		}
		return goNext.elem;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return boolean: true if elem is in the list, and false otherwise
	 */ 
	public boolean contains(T elem){
		// TODO	
		Node<T> goNext = this.head;
		while(goNext != null){
			if(goNext.elem.equals(elem))
				return true;
			goNext = goNext.next;
		}
		return false;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrence(T elem){
		// TODO
		Node<T> goNext = this.head;
		int index = 0;
		while(goNext != null){
			if(goNext.elem.equals(elem))
				return index;
			goNext = goNext.next;
			index++;
		}
		return -1;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem starting from fromIndex (inclusive), 
	 *				or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrenceSince(int fromIndex, T elem){
		// TODO
		Node<T> goNext = this.head;
		int index = 0;
		while(goNext != null && index < fromIndex){
			goNext = goNext.next;
			index++;
		}
		while(goNext != null) {
			if(goNext.elem.equals(elem)) {
				return index;
			}
			goNext = goNext.next;
			index++;
		}
		
		return -1; //dont know if there should be out of bounds exceptions
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the last occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findLastOccurrence(T elem){
		// TODO
		Node<T> goNext = this.tail;
		int index = this.size-1;
		while(goNext != null){
			if(goNext.elem.equals(elem)){
				return index;
			}
			goNext = goNext.previous;
			index--;
		}
		return -1;
	}
	
	
	/**
	 * Removes the first occurrence of @elem, if it exists in the list.
	 *
	 * @param elem: The element we wish to remove
	 * @return int: The index of the first occurrence of elem prior to its removal, or -1 if
					@elem is not in the list.
	 */
	public int remove(T elem){
		// TODO
		int index = 0;
		boolean found = false;
		if(this.head.elem.equals(elem)){
			this.head.next.previous = null;
			this.head = this.head.next;	
			found = true;
		}
		else{
			index++;
			Node<T> goNext = this.head.next;
			while(!(goNext.equals(this.tail)) && !found){
				if(goNext.elem.equals(elem)){
					goNext.previous.next = goNext.next;
					goNext.next.previous = goNext.previous;
					found = true;
				}
				else {
					goNext = goNext.next;
					index++;
				}
			}
			if(elem.equals(this.tail.elem)){
				this.tail.previous.next = null;
				this.tail = this.tail.previous;
				found = true;
			}
		}
		if(found) {
			size--;
			return index;
		}
		return -1;	
	}
	
	
	/**
	 * Removes the element at @index.
	 *
	 * @param index: The position of the element to remove
	 * @return T: The element removed from the list
	 */
	public T remove(int index){
		// TODO
		if(index >= this.size) {
			throw new IndexOutOfBoundsException("The index you used("+
					index + ") far exceeds the size of this list");
		}
		
		T elemReturn;
		if(index == 0) {
			elemReturn = this.head.elem;
			this.head.next.previous = null;
			this.head = this.head.next;
		}	
		else if(index == this.size-1) {
			elemReturn = this.tail.elem;
			this.tail.previous.next = null;
			this.tail = this.tail.previous;
		}
		else {
			Node<T> goNext = this.head.next;
			int i = 1;
			while(i < index) {
				i++;
				goNext = goNext.next;
			}
			elemReturn = goNext.elem;
			goNext.previous.next = goNext.next;
			goNext.next.previous = goNext.previous;
		}
		
		size--;
		return elemReturn;
	}
	
	
	/**
	 * Removes all instances of @elem from the list.
	 *
	 * @param elem: The element to remove from the list.
	 */
	public void removeAll(T elem){
		// TODO
		if(this.head.elem.equals(elem)) {
			remove(elem);
		}
		Node<T> goNext = this.head.next;
		while(!(goNext.equals(this.tail))){
			if(goNext.elem.equals(elem)) {
				goNext.previous.next = goNext.next;
				goNext.next.previous = goNext.previous;
				size--;
			}
			goNext = goNext.next;
		}
		if(this.tail.elem.equals(elem)) {
			this.tail.previous.next = null;
			this.tail = this.tail.previous;
			size--;
		}
	}
	
	/**
	 * @return int: The number of elements in the list.
	 */ 
	public int size(){
		return this.size;
	}
	
}