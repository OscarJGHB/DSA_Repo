/**
 * @author Michael Levet
 * @date 10/25/2023
 */
 
 // The syntax <T extends Comparable<? super T>> ensures
 // that any two elements will be mutually comparable

import java.util.Arrays;

public class MinHeap<T extends Comparable<? super T>>{

	private T[] internal;
	private int size; // recall that internal.length might be > the number of elements in the MinHeap
	
	public MinHeap(){
		internal = (T[]) new Comparable[10];
		this.size = 0;
	}

	/** 
	 * @param arr 
	 *
	 * Iteratively add the elements of arr to this MinHeap.
	 * Note that the elements of arr may not be in an order
	 * that respects the Heap property.
	 */
	@SuppressWarnings("unchecked")
	public MinHeap(T[] arr){
		internal = (T[]) new Comparable[arr.length+1];
		
		for(int i = 0; i < arr.length; i++){
			add(arr[i]);
		}
	}
	
	/**
	 * @param elem: The element to insert into the MinHeap, resizing
	 *				this.internal if necessary.
	 */ 
	public void add(T elem){ //percolate
		if(this.internal.length == this.size){
			resize();
		}
		if(this.internal[1]!= null) {
			int rootSpot = size + 1;
			this.internal[rootSpot] = elem;
			T temp;
			for(int i = (int)(Math.log(rootSpot)/Math.log(2));i != 0; i--){
				if(elem.compareTo(this.internal[rootSpot/2]) < 0){
					temp = this.internal[rootSpot/2];
					this.internal[rootSpot/2] = this.internal[rootSpot];
					this.internal[rootSpot] = temp;
					rootSpot/=2;
				}
				else
					break;
			}
		}
		else { //prevent null exception
			this.internal[1] = elem;
		}
		this.size++;
	}
	
	
	/**
	 * @return T The element at the top of the MinHeap, which 
	 *			 is also the minimum element present.
	 * 
	 */ 
	public T removeMin(){ //percolate
		T removed = internal[1];
		this.internal[1] = this.internal[size];
		this.internal[size] = null;
		int root = 1;
		int compareInd = root;
		int add;
		T temp;
		size--;
		while(2*root <= size){
			add = 0;
			
			if(internal[2*root + 1]!= null && (internal[2*root+1].compareTo(internal[2* root]) < 0))
				add = 1;
			
			compareInd *= 2 + add;
			
			if(internal[root].compareTo(internal[compareInd]) > 0) {
				temp = internal[compareInd];
				internal[compareInd] = internal[root];
				internal[root] = temp;
				root = compareInd;
			}
			else
				break;
			
		}
		return removed;
	}
	
	
	
	/**
	 * @return int The number of elements in the MinHeap
	 */ 
	public int size(){
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public void resize(){
		T[] newInternal = (T[]) new Comparable[2*internal.length];
		for(int i = 0; i < this.internal.length; i++){
			newInternal[i] = this.internal[i];
		}
		this.internal = newInternal;
	}
	
	
	/**
	 * @return T[] A sorted array from the elements of this MinHeap
	 *			   
	 * Inside the method, create a new MinHeap which is a deep copy of 
	 * this MinHeap (please review shallow copy vs. deep copy from 221).
	 * Then using your new MinHeap, iteratively use removeMin() to 
	 * place the elements in a sorted array. This is the Heapsort algorithm.
	 */	 
	 public T[] heapsort(){
		 T[] sortedList = (T[]) new Comparable[size];
		 MinHeap miniHeap = new MinHeap<T>();
		 for(int i = 1; i <= this.size(); i++){
			 miniHeap.add(internal[i]);
		 }
		 for(int i = 0; i< size; i++){
			 sortedList[i] = (T) miniHeap.removeMin();
		 }
		 return sortedList;
		 
	 }
	 

	
}