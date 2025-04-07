/**
 * @author Michael Levet
 * @date August 17, 2023
 *
 * Honor Code: While it is permitted to discuss with
 * your classmates, all code should be written by you and not copied
 * (even if you retype) from any other source. 
 */
public class ArrayListADT<T> implements ListADT<T>{


	// The internal array that we manage
	private T[] internal;
	private int length;
	
	
	/**
	 * Instantiate a new ArrayListADT.
	 * The internal array should be initialized to
	 * store 100 elements.
	 */ 
	@SuppressWarnings("unchecked") 
	public ArrayListADT(){
		internal = (T[])new Object[100];
		
		// note that even though this.internal.length = 100,
		// there are no elements in the ArrayListADT. So
		// we initialize this.length = 0
		this.length = 0; 
	}
	
	
	/**
	 * Instantiate a new ArrayListADT.
	 * The internal array should be initialized to
	 * store @size elements.
	 */ 
	@SuppressWarnings("unchecked")
	public ArrayListADT(int size){
		// TODO
		internal = (T[]) new Object[size];
		this.length = size;
	}
	
	
	/**
	 * Instantiate a new ArrayListADT.
	 * The internal array should be initialized 
	 * to store @arr.length many elements, and then
	 * the elements of @arr should be copied over
	 * to internal. Do *NOT* set internal = arr; as 
	 * this causes internal to point to arr.
	 */ 
	@SuppressWarnings("unchecked")
	public ArrayListADT(T[] arr){
		//  TODO
		this.length = arr.length;
		internal = (T[]) new Object[arr.length];
		for(int i = 0; i < arr.length; i++){
			internal[i] = arr[i];
		}
	}
	
	
	
	private void resize(){
		@SuppressWarnings("unchecked")
		T[] temp = (T[])(new Object[2 * internal.length]); 
		for(int i = 0; i < internal.length; i++){
			temp[i] = internal[i];
		}
		
		internal = temp;
	}
	
	
	
	/**
	 * @param elem: The element to add to the end of the list
	 */ 
	public void add(T elem){
		if(this.length == internal.length){
			resize();
		}
		internal[this.length] = elem;
		this.length++;	
	}
	
	
	/**
	 * @param index: The index at which to insert the new element
	 * @param elem: The element to insert not the list at position @index.
	 * 
	 * Inserts @elem at position @index in the list. Any element at position @index
	 * or later in the list prior to this method being invoked should be moved
	 * one index down (so the element at position @index prior to this method being invoked
	 * should end up at position @index+1 after this method terminates).
	 */
	public void add(int index, T elem){
		// TODO
		if(index == 0 && this.length == 0){
			internal[0] = elem;
		}
		else if(index <= this.length){
			if(this.length >= internal.length){
				resize();
			}
			for(int i = this.length-1; i >= index; i-- ){
				internal[i+1] = internal[i];
			}
			internal[index] = elem;
		}
		else
			throw new IndexOutOfBoundsException("Cannot add " + elem + " at position " + index + "\n Index out of bounds");
		this.length++;
		
		
		
		
	}
	
	
	/**
	 * @param index: The index of the element to return
	 * @return T: The element located at @index to return
	 */
	public T get(int index){
		if(index < size()){
			return (T)(internal[index]);
		}
		
		throw new IndexOutOfBoundsException("The ArrayListADT has size " + size() + ". The parameter index: " + index + " exceeds this size.");
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return boolean: true if elem is in the list, and false otherwise
	 */ 
	public boolean contains(T elem){
		// TODO
		for(int i = 0; i<this.length; i++){
			if(internal[i].equals(elem)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrence(T elem){
		// TODO
		for(int i = 0; i < this.length; i++)
			if(internal[i].equals(elem))
				return i;
		return -1;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem starting from fromIndex (inclusive), 
	 *				or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrenceSince(int fromIndex, T elem){
		// TODO
		for(int i = fromIndex; i < this.length; i++)
			if(internal[i].equals(elem))
				return i;
		return -1;
	}
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the last occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findLastOccurrence(T elem){
		// TODO
		for(int i = this.length-1; i >=0 ;i--)
			if(internal[i].equals(elem))
				return i;
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
		int target = findFirstOccurrence(elem);
		if(target == -1)
			return -1;
		for(int i = target; i<this.length-1; i++)
			internal[i] = internal[i+1];
		length--;
		return target;
	}
	
	
	/**
	 * Removes the element at @index.
	 *
	 * @param index: The position of the element to remove
	 * @return T: The element removed from the list
	 */
	
	public T remove(int index){
		// TODO
		if(index < this.length) {
			T removedItem = internal[index];
			for(int i = index; i<this.length-1; i++) {
				internal[i] = internal[i+1];
			}
			length--;
			return removedItem;
		}
		throw new IndexOutOfBoundsException("The ArrayListADT has size " + size() + 
				". There is no element at index: " + index);
	}
	
	/**
	 * Removes all instances of @elem from the list.
	 *
	 * @param elem: The element to remove from the list.
	 */
	public void removeAll(T elem){
		// TODO
		int index = findFirstOccurrenceSince(0,elem);;
		while(index != -1){
			remove(index);
			index = findFirstOccurrenceSince(index,elem);
		} 
	}
	
	/**
	 * Reverses the elements within the list 
	 * @param
	 */
	
	/**
	 * @return int: The number of elements in the list.
	 */ 
	public int size(){
		// TODO
		return this.length;
	}
	
	


	/**
	 * Instructor Note: DO NOT MODIFY
	 */
	public String toString(){
		if(this.length == 0){
			return "[]";
		}
		
		String test = "[";
		for(int i = 0; i < this.length-1; i++){
			test += internal[i].toString() + ", ";
		}
		
		test += internal[this.length-1].toString() + "]";
		return test;
	}	
}