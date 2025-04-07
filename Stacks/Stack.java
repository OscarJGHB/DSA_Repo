public class Stack<T> {
	
	private ArrayListADT<T> list;
	
	public Stack(){
		list = new ArrayListADT<T>();
	}
	
	public Stack(T[] arr){
		list = new ArrayListADT<T>(arr);
	}
	
	/*
	 * Adds an element on top of the stack
	 * @param elem: the element to be added on top
	 * 
	 */
	public void push(T elem) {
		this.list.add(elem);
	}
	
	/*
	 * Shows the user the element on top of the stack
	 * 
	 * return T: returns the value at the end of the arraylist
	 */
	public T peek(){
		if(list.size() == 0)
			return null;
		return this.list.get(this.list.size()-1);	
	}
	
	/*
	 * Removes the element at the top of the stack, whilst also returning the element
	 * 
	 * return T: returns the value at the end of the arraylist
	 */
	public T pop(){
		if(list.size() == 0)
			return null;
		return this.list.remove(this.list.size()-1);
	}
	
	
	

}
