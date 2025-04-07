import java.util.NoSuchElementException;

/**
 * @author Michael Levet
 * @date 11/11/2023
 */
 
public class HashTable{

	private int[] internal;
	private int size; // the number of elements that have been inserted into the HashTable
	private int prime;
	
	public HashTable(){
		this.internal = new int[10];
		this.prime = 7;
	}
	
	
	/**
	 * @param elem: The element to add
	 * @pre elem > 0: We will only insert positive numbers
	 *
	 * Use the hash function h(x) = 2 * prime * x + 3 (mod this.internal.length) to 
	 * place elem. If h(elem) is already occupied, resolve the collision 
	 * with linear probing.
	 */
	public void add(int elem){
		if(elem <= 0){
			throw new IllegalArgumentException("Cannot pass numbers 0 or less as an argument");
		}
		if(this.size > this.internal.length/2){
			resize();
		}
		int hashPos = hashFunc(elem);
		while(internal[hashPos] != 0){
			hashPos= (hashPos +1)%internal.length ;
		}
		internal[hashPos] = elem;
		this.size++;
	}
	
	
	/**
	 * Double the size of this.internal if this.size > this.internal.length/2
	 * Then update this.prime to be the largest prime < this.internal.length.	 
	 */ 
	private void resize(){
		int[] temp = new int[internal.length*2];
		for(int i = 0; i < internal.length; i++){
			temp[i] = internal[i];
		}
		internal = temp;
		prime = (internal.length - (internal.length % 6)) + 1;
	}
	
	/**
	 * @param elem: The element to search for
	 * @pre elem > 0
	 * @return boolean: Whether elem is in the HashTable
	 *
	 * Use the same hash function from add() to search for elem.
	 * Then use the linear probing strategy if elem is not found at h(elem).
	 */ 
	public boolean contains(int elem){
		if(elem <= 0){
			throw new IllegalArgumentException("Cannot pass numbers 0 or less as an argument");
		}
		int looped = 0;
		int hashPos = hashFunc(elem);
		while(looped != internal.length){
			if(internal[hashPos] == elem){
				return true;
			}
			hashPos = (hashPos+1)%internal.length;
			looped++;
		}
		return false;
	}
	
	
	/**
	 * @param elem: The element to remove
	 * @pre elem > 0
	 *
	 * Use the same hash function from add() to search for elem.
	 * Then use the linear probing strategy if elem is not found at h(elem).
	 * If the element exists at position i, set internal[i] = 0.
	 */
	public void remove(int elem){
		if(elem <= 0){
			throw new IllegalArgumentException("Cannot pass numbers 0 or less as an argument");
		}
		int looped = 0;
		int hashPos = hashFunc(elem);
		while(looped != internal.length){
			if(internal[hashPos] == elem){
				internal[hashPos] = 0;
				break;
			}
			hashPos = (hashPos+1)%internal.length;
			looped++;
		}
		if(looped == internal.length){
			throw new NoSuchElementException(elem + " does not exist");
		}
		size--;
	}
	
	public int size(){
		return this.size;
	}
	
	
	/**
	 * DO NOT MODIFY
	 */
	 public String toString(){
		 return java.util.Arrays.toString(this.internal);
	 }
	 
	 private int hashFunc(int num){
		 return (2 * prime * num + 3) % internal.length;
	 }
}