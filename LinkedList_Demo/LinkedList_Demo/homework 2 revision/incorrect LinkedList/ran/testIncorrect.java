package ran;

public class testIncorrect {
	public static void main(String[] args) {
		LinkedListADT<Integer> list = new LinkedListADT<Integer>();
		for(int i = 0; i<5; i++)
			list.add(i+1);
		System.out.print(list);
		System.out.print(list.contains(8));
		System.out.print(list.findFirstOccurrence(8));
	}
}
