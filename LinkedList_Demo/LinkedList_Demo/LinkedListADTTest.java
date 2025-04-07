/**
 * @author Michael Levet
 * @date August 27, 2023
 */
public class LinkedListADTTest{

	public static void main(String[] args){
		testRemove();
	}
	
	public static LinkedListADT<String> initialize(){
		LinkedListADT<String> list = new LinkedListADT<String>();
		System.out.println(list);
		for(int i = 0; i < 10; i++){
			list.add(""+ i);
			System.out.println(list);
		}
		
		return list;
	}
	
	public static void testAddIndex(){
		LinkedListADT<String> list = initialize();
		list.add(3,"7");
		System.out.println(list);
		
		list.add(4, "11");
		System.out.println(list);
		
		list.add(12, "13");
		System.out.println(list);
		
		list.add(13, "17");
		System.out.println(list);
		
		System.out.print(list.findLastOccurrence("13"));
		
		// Note that index 17 is out of bounds.
		// What should happen at this line?
		list.add(17, "23");
		System.out.println(list);
	}
	
	public static void testGet(){
		LinkedListADT<String> list = initialize();
		System.out.println("Get the element at index 3, which is \"3\": " + (list.get(3).equals("3")));
		System.out.println("Get the element at index 4, which is \"4\": " + (list.get(4).equals("4")));
		System.out.println("Get the element at index 7, which is \"7\": " + (list.get(7).equals("7")));
		System.out.println("Get the element at index 11, which is out of bounds. There should be an error: " + list.get(11));
		
	}
	
	public static void testRemove(){
		LinkedListADT<String> list = initialize();
		System.out.println("Remove 3, which is at index 3: " + (list.remove("3") == 3));
		System.out.println(list + "\n");
		System.out.println("Remove 4, which is at index 3: " + (list.remove("4") == 3));
		System.out.println(list + "\n");
		System.out.println("Remove 7, which is at index 5: " + (list.remove("7") == 5));
		System.out.println(list + "\n");
		System.out.println("Remove 3, which is no longer in the list, so remove should return -1: " + (list.remove("3") == -1));
		System.out.println(list + "\n");
		list.removeAll("8");
		System.out.println(list);
		
	}
}