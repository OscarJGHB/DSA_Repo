/**
 * @author Michael Levet
 * @date September 6, 2023
 */
public class Demo{
	public static void main(String[] args) {
		System.out.println(checkString("1"));
		System.out.println(checkString("0012"));
		System.out.println(checkString("0022"));
		System.out.println(checkString("000112"));
		System.out.println(checkString("0011"));
		System.out.println(checkString(""));
		System.out.println(checkString("1100"));
		System.out.println(checkString("0012"));
		
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
		boolean oEnd = false; 
		String currBit;
		Stack<String> theBits = new Stack<String>();
		for(int i = 0; i < str.length(); i++) {
			
			currBit = str.charAt(i) + "";
			if(currBit.equals("0")) {
				if(oEnd == true) {
					return false;
				}	
				theBits.push(currBit);
			}
			else{
				if(currBit.equals("1")){
					if(theBits.pop() == null) {
						return false;
					}
					oEnd = true;
				}
			}
		}
		return theBits.peek()== null;
		
		
		// you may-- and probably should-- return 
		// something here 
		
	}
		
		// you may-- and probably should-- return 
		// something here 
		
}