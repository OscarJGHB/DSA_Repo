import java.util.Arrays;
public class testingMinHeaps{
	public static void main(String[] args){
		MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(14);
        heap.add(10);
        heap.add(12);
        heap.add(18);
        heap.add(19);
        heap.add(16);
        heap.add(15);
        heap.add(13);
        heap.add(9);
        heap.removeMin();
        heap.print();

	}
}

