

public class testCorrect {
	public static void main(String[] args) {
		LinkedListADT<Integer> list = new LinkedListADT<Integer>();
		for(int i = 0; i<10; i++)
			list.add((i+1)%4);
		System.out.println(list);
		System.out.println(
		list.size());
		list.removeAll(new Integer(1));
		System.out.println(list);
		System.out.println(list.size());
		list.size();
		list.removeAll(new Integer(3));
		System.out.println(list);
		System.out.println(list.size());
		
	}
}
