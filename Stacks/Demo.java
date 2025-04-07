/**
 * @author Michael Levet
 * @date September 6, 2023
 */
public class Demo{
	public static void main(String[] args) {
		System.out.print(checkString("11111"));
	}
	
	
	// Header for Problem 2(c)
	public static boolean checkString(String str){
		// You should declare exactly one Stack before the loop
		// You may not declare any additional Stacks or use
		// any additional data structures
	
		// You may not loop through str again or use
		// any String methods beyond charAt()
		if(str.equals(""))
			return true;
		if(str.length() % 2 == 1)
			return false;
		String frontBit;
		String backBit;
		Stack<String> theBits = new Stack<String>();
		for(int i = 0; i < str.length()/2; i++) {
			frontBit = str.charAt(i) + "";
			backBit = str.charAt(str.length()-i-1) + "";
			if(!(frontBit.equals("0")) || !(backBit.equals("1"))) {
				return false;
			}
			theBits.push(frontBit);
			theBits.push(backBit);
		}
		while(theBits.peek() != null) {
			if(theBits.pop().equals(theBits.pop()))
				return false;
			}
		return true;
		
		// you may-- and probably should-- return 
		// something here 
		
	}
}