
public class ProblemTwo	{
	public static void main(String[] args){
		
		ArrayListADT<Integer> list = new ArrayListADT<Integer>(new Integer[]{1,3,4,5,8,10,13});
		ArrayListADT<Integer> list2 = new ArrayListADT<Integer>(new Integer[]{2,3,4,-1,49,0});
		reverse(list);
		selectionSort(list2);
		System.out.print(list);
		System.out.print(list2);
	
	}
	
	
	public static <T> ArrayListADT<T> reverse(ArrayListADT<T> list) {
		for(int i = 0; i<list.size()/2; i++){
			T tempValBeg = list.get(i) ;
			T tempValEnd = list.get(list.size()-i-1);
			list.remove(i);
			list.remove(list.size()-i-1);
			list.add(i,tempValEnd);
			list.add(list.size()-i,tempValBeg);	
		}
		return list;
	}
	
	public static <T> ArrayListADT<T> selectionSort(ArrayListADT<T> list){
		for(int i = 0; i<list.size()-1; i++){
			int smallest = i;
			for(int j = i+1; j<list.size(); j++){ 
				if((int)(list.get(j)) < (int)(list.get(smallest)))
					smallest = j;	
			}
			if(!(list.get(smallest)).equals(list.get(i))){
				list.add(i,list.get(smallest));
				list.remove(smallest+1);
				list.add(i+1, list.get(i));
				list.remove(i+1);}
		}
		return list;
	}
}
