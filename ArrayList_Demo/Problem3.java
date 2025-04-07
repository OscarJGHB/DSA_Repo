import java.util.Random;
import java.util.Arrays;

public class Problem3 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] intSet = new int[rand.nextInt(0,10)];
		for(int i = 0; i<intSet.length ; i++){
			intSet[i] = rand.nextInt(0,10);
		}
		
		System.out.println(Arrays.toString(intSet) + " with "
				+ "an inversion count of: " + countInv(intSet));
		bubbleSort(intSet);
		System.out.print("Sorted: " + Arrays.toString(intSet));
	}
	
	/**ANSWER TO PROBLEM , B. The max number of inversions that can occur is 
							  ((n-1)(n))/2 where n is the number of elements in a set.
	                          For the number of elements(n), the number of possible
							  inversions increase as when element i does, where 1<i<=n, has 
							  to compare itself to the following elements i-1 times. 
							  Therefore, each increment in i adds upon i-1 inversions.
							  If n happened to be 1, then there would be no further 
							  elements to possibly compare itself to. Thus,the number of 
							  elements able to make comparisons would be n-1 and shifts
							  the usual summation formula down 1: n(n+1) to (n-1)(n)instead.
							  
	*/
	
	/**
	 * Counts the number of inversions
	 * 
	 * @param list
	 * @return invCount
	 */
	public static int countInv(int[] list) {
		int invCount = 0;
		for(int i = 0; i < list.length-1;i++){
			for(int j=i+1; j < list.length; j++){
				if(list[j] < list[i])
					invCount++;
			}
		}
		return invCount;
	}
	
	/**
	 * **ANSWER TO PROBLEM 3, D. If set A were to have k inversions, and a bubblesort swaps
	 * 							 two elements(inner loop), then it is safe to assume
	 * 							that the number of inversions would decrease by one
	 * 							every iteration 0. This is due to swapping a bigger(xi)
	 * 							number with a smaller(xj) one. The smaller number, now placed
	 * 							behind the bigger one, loses its place in the inversion count
	 * 							of the element in front of it whilst also keeping its inversion
	 * 							count. Therefore, only 1 inversion count is lost per swap.
	 * 							There are many examples of this. One example, a set in reverse.
	 * 							The set of [10,9,8,7] has 4 elements, and 6 inversions. As
	 * 							the inner loop progresses, it would leave [9,10,8,7] with 5
	 * 							inversions-- as 10 cannot compare to smaller number before it(9)
	 * 							-- then [9,8,10,7] with 4 and finally, [9,8,7,10] with 3. As of
	 * 							the next iteration of i, the inner loop(j) will run 
	 * 							n-1-i(4-1-1 = 2)times set into [8,7,9,10], resulting in
	 * 							1 inversion overall. This makes k inversions decreasing
	 * 							by 1 every iteration until 0 true.
	 * 							
	 */
	
	/** **ANSWER TO PROBLEM 3, E. At the end of every iteration, the largest number should be
	 * 							  at the end of the allotted range of the iteration. 	
	 * 
	 * 
	 */
	
	/**
	 * Sorts the list of integers using bubble sort method
	 * 
	 * @param list
	 */
	public static void bubbleSort(int[] list){
		int tempVal = 0;
		for(int i = 0; i<list.length-1; i++){
			for(int j = 0; j<list.length - i - 1 ; j++){
				if(list[j]>list[j+1]) {
					tempVal = list[j];
					list[j] = list[j+1];
					list[j+1] = tempVal;
				}
			}
		}
	}
}
