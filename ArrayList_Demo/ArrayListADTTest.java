public class ArrayListADTTest{

	public static void main(String[] args){
		// When ArrayListADT<Integer> is instantiated
		// Java will set T = Integer
		// As a result, Java will enforce that we can only add Integers
		// to our ArrayList. 
		ArrayListADT<Integer> list = new ArrayListADT<Integer>();
		
		System.out.println(list);
		for(int i = 0; i < 10; i++){
			list.add(i);
			System.out.println(list);
			System.out.println(list.size());
		}
		
		list.add(3, 17);
		System.out.println(list);
		System.out.println(list.size());
		
		list.add(11, 19);
		System.out.println(list);
		System.out.println(list.size());
		
		
		list.add(12, 23);
		System.out.println(list);
		System.out.println(list.size());
		
		list.remove2(10);
		System.out.println(list);
		System.out.println(list.size());
	}
}