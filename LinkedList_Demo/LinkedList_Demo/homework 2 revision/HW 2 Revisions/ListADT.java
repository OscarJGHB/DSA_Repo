/**
 * @author Michael Levet
 * @date June 25, 2023
 * 
 */
public interface ListADT<T>{

	/**
	 * @param elem: The element to add to the end of the list
	 */ 
	public void add(T elem);
	
	
	/**
	 * Inserts @elem at position @index in the list. Any element at position @index
	 * or later in the list prior to this method being invoked should be moved
	 * one index down (so the element at position @index prior to this method being invoked
	 * should end up at position @index+1 after this method terminates).
	 *
	 * @param index: The index at which to insert the new element
	 * @param elem: The element to insert inot the list at position @index.
	 */
	public void add(int index, T elem);
	
	
	/**
	 * @param index: The index of the element to return
	 * @return T: The element located at @index to return
	 */
	public T get(int index);
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return boolean: true if elem is in the list, and false otherwise
	 */ 
	public boolean contains(T elem);
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrence(T elem);
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the first occurrence of elem starting from fromIndex (inclusive), 
	 *				or -1 if elem is not in the list.
	 */ 
	public int findFirstOccurrenceSince(int fromIndex, T elem);
	
	
	/**
	 * @param elem: The element we want to check for membership in the list.
	 * @return int: The index of the last occurrence of elem, or -1 if elem is not in the list.
	 */ 
	public int findLastOccurrence(T elem);
	
	
	/**
	 * Removes the first occurrence of @elem, if it exists in the list.
	 *
	 * @param elem: The element we wish to remove
	 * @return int: The index of the first occurrence of elem prior to its removal.
	 */
	public int remove(T elem);
	
	
	/**
	 * Removes the element at @index.
	 *
	 * @param index: The position of the element to remove
	 * @return T: The element removed from the list
	 */
	public T remove(int index);
	
	
	/**
	 * Removes all instances of @elem from the list.
	 *
	 * @param elem: The element to remove from the list.
	 */
	public void removeAll(T elem);
	
	/**
	 * @return int: The number of elements in the list.
	 */ 
	public int size();
}