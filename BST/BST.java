import java.util.NoSuchElementException;
import java.util.Stack;
/**
 * @author Michael Levet
 * @date 10/9/2023
 */
 
 // The syntax <T extends Comparable<? super T>> ensures
 // that any two elements will be mutually comparable
public class BST<T extends Comparable<? super T>>{

	class Node<T>{
		Node<T> left, right;
		T elem;
		
		Node(){
			this.left = null;
			this.right = null;
		}
		
		
		/**
		 * Instructor Note: DO NOT MODIFY
		 */
		public String toString(){
			String leftString = "[Left: ";
			String rightString = "[Right: ";
			String str = "";
			
			if(left != null){
				leftString = leftString + left.toString();
			}
			
			if(right != null){
				rightString = rightString + right.toString();
			}
			
			leftString += "]";
			rightString += "]";
			
			return leftString + ", " + elem + ", " + rightString;
			
		}
	}
	
	private Node<T> root;
	private int length;
	
	
	
	/**
	 * @param elem: The element to insert into the tree
	 *
	 * Implement a method to insert elem into the BST.
	 * Make sure to implement your method **iteratively**
	 * rather than using recursion.
	 */ 
	public void add(T elem){
		if(this.root == null){
			this.root = new Node<T>();
			this.root.elem = elem;
		}
		else {
			Node<T> traverse = this.root;
			while(true) {
				if(elem.compareTo(traverse.elem) > 0) {
					if(traverse.right == null) {
						traverse.right = new Node<T>();
						traverse.right.elem = elem;
						break;
					}
					else {
						traverse = traverse.right;
					}
				}
				else {
					if(traverse.left == null) {
						traverse.left = new Node<T>();
						traverse.left.elem = elem;
						break;
					}
					else {
						traverse = traverse.left;
					}
				}
			}
		}
		this.length++;
	}
	
	
	
	/**
	 * @param elem: The element to remove from the tree.
	 * 
	 * Removes the first instance of elem found in the tree, as follows
	 *		- If elem is at the root, then remove the root
	 *		- Else if elem is in the left subtree, then remove elem from the left subtree (applying this rule to the left subtree)
	 *		- Else if elem is in the right subtree, then remove elem from the right subtree (applying this rule to the right subtree)
	 *
	 * Implement your method **iteratively** rather than using recursion
	 */
	public void remove(T elem){
		if(this.root.elem == null){
			throw new NullPointerException("The tree is empty");
		}
		//find the node and its previous 
		Node<T> tempRoot = new Node<T>();
		tempRoot.elem = this.root.elem;
		tempRoot.left = this.root;
		Node<T> traverse;
		Node<T> tempNode = null;
		boolean left = false;
		boolean right = false;
		
		if(elem.equals(this.root.elem)){
			left = true;
			traverse = tempRoot;
			tempNode = traverse.left;
		}
		else{
			traverse = this.root;
		}
		
		while(traverse != null && !(left || right)) {
			if(elem.compareTo(traverse.elem) > 0) {
				if(traverse.right != null && traverse.right.elem.equals(elem)) {
					right = true;
					tempNode = traverse.right;
				}
				else
					traverse = traverse.right;
			}
			else {
				if(traverse.left != null && traverse.left.elem.equals(elem)) {
					left = true;
					tempNode = traverse.left;
				}
				else
					traverse = traverse.left;
			}
		}
		//null check
		if(traverse == null){
			throw new NoSuchElementException("No element \"" + elem + "\" was found.");
		}
		//check tempNode is only child
		if(tempNode.left == null && tempNode.right == null){
			tempNode = null;
		}
		else if(tempNode.left != null && tempNode.right == null){
			tempNode = tempNode.left; 
		}
		else if(tempNode.left == null && tempNode.right != null){
			tempNode = tempNode.right;
		}
		else{
			Node<T> remNode = tempNode;
			Node<T> prevNode = tempNode;
			tempNode = tempNode.left;
			while(tempNode.right != null){
				prevNode = tempNode;
				tempNode = tempNode.right;
			}
			if(tempNode.equals(remNode.left))
				tempNode.left = null;
			else {
				prevNode.right = tempNode.left;
				tempNode.left = remNode.left;
			}
			tempNode.right = remNode.right;
		}
		
		//remove process
		if(left){
			traverse.left = tempNode;
		}
		else{
			traverse.right = tempNode;
		}
		
		//just in case root is changed
		this.root = tempRoot.left;
	}
	
	
	/**
	 * @param elem: The element to search for in the tree
	 * @return boolean: true if elem exists, and false otherwise
	 *
	 * Implement your method **iteratively** rather than using recursion
	 */
	public boolean contains(T elem){
		if(this.root.elem == null){
			throw new NullPointerException("The tree is empty");
		}
		Node<T> traverse = this.root;
		while(traverse != null)
			if(elem.equals(traverse.elem))
				return true;
			else if(elem.compareTo(traverse.elem) > 0)
				traverse = traverse.right;
			else
				traverse = traverse.left;
		return false;
	}
	
	
	/**
	 * @return int, the number of elements in the tree
	 *
	 * This method should take O(1) steps; think about how to use a 
	 * size instance variable.
	 */
	public int size(){
		return this.length;
	}
	
	
	/**
	 * @return String: A comma-separated sequence corresponding 
	 *				   to the inorder traversal of the tree
	 *
	 * You may **not** use recursion to implement this method.
	 * You are, however, welcome to use the java.util.Stack class.
	 * You can als create private helper methods, but those methods
	 * cannot use recursion.
	 */ 
	public String inorder(){
		if(this.root == null) {
			throw new NullPointerException("The tree is empty");
		}
		
		Stack<Node<T>> order = new Stack<Node<T>>();
		order.push(this.root);
		Node<T> tempNode;
		String ordered = "[ ";
		
		while(!order.isEmpty()){
			
			while(order.peek().left != null){
				order.push(order.peek().left);
			}
			while(!order.isEmpty()){
				if(order.peek().right != null){
					tempNode = order.pop();
					ordered += tempNode.elem + ", ";
					order.push(tempNode.right);
					break;
				}
				ordered += order.pop().elem + ", ";
			}	
		}
		return ordered.substring(0, ordered.length()-2) + " ]\n";
	}
	
	/**
	 * Instructor Note: **DO NOT MODIFY**
	 */
	public String toString(){ 
		if(root == null){
			return "[]";
		}
		
		return root.toString(); 
	}
	
}