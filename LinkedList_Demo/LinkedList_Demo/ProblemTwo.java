
public class ProblemTwo {
	public static void main(String[] args){
		LinkedListADT<Integer> intLinked = new LinkedListADT<Integer>();
		for(int i = 0; i < 10; i++){
			intLinked.add(i);
		}
	}
}

/* Answer to 2b)	Selection sort for arrays and linked lists are different.
 * 					For arrays, you would have to find the smallest element past
 * 					the number you're comparing to, which usually starts at i, via 
 * 					an inner loop, starting at j, then swapping them after each 
 * 					outer iteration. Within the array sorting, there would be a 
 * 					temp variable, which takes up extra memory. In contrast, for 
 * 					linked lists, you have two loops too; there would be one
 * 					outer and one inner, one for holding the stop point
 * 					and one for iterating through the list. However, you would just
 * 					point the two nodes encasing the selected(smallest) node
 * 					towards each other. Then, you would point the selected node's
 * 					next node to the node selected by the outer loop, and its 
 * 					previous node to the outer loop node's previous node-- only 
 * 					adding four constant steps. Both arrays and linked lists 
 * 					have outerloops consisting of n - 1, which is the number 
 * 					of elements to be compared to, with each making n-i, for 
 * 					each i, comparisons. However, within
 * 					arrays, you would have to shift all elements from the index of
 * 					which was swapped down(when removed), then back up when a new
 * 					element is added(sorted). Depending on how many swaps, it would
 * 					lead to a far larger complexity level than linked lists would due
 * 					to the loops it would have to go through each time it is swapped
 * 					or removed. Therefore, yes, selection sort is a reasonable 
 * 					sorting algorithm for linked lists.
 * 					
 * 
 * 
 * 
 */

