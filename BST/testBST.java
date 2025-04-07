
public class testBST {
	public static void main(String args[]){
		BST<Integer> bst = new BST<Integer>();
//		bst.add(10);
//		bst.add(9);
//		bst.add(8);
//		bst.add(7);
//		bst.add(6);
//		bst.add(13);
//		bst.add(19);
//		bst.add(15);
//		bst.add(12);
//		bst.add(11);
//		System.out.print(bst.inorder());
//		bst.remove(10);
//		System.out.print(bst.inorder());
		bst.add(11);
		bst.add(15);
		bst.add(12);
		bst.add(13);
		bst.add(16);
		bst.add(7);
		bst.add(9);
		bst.add(5);
		bst.add(8);
		bst.add(14);
		bst.add(10);
		bst.remove(5);
		System.out.print(bst.inorder());
		
		
	}
}
