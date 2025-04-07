import java.util.NoSuchElementException;

public class TestingHashtables {
	public static HashTable hT = new HashTable();
	public static void main(String[] args){
		hT.add(12);
		arrayStats("Adding 12 as first element to the array");
		hT.add(12);//testing linear probing
		arrayStats("Adding 12 again to test linear probing");
		hT.add(4);
		arrayStats("Adding 4");
		hT.add(9);
		hT.add(14);//tests linear probing and looping
		arrayStats("Adding 9 and 14 to test looping- these two have identical hash function returns");
		hT.remove(4);//tests remove 
		arrayStats("Testing removal of 4");
		hT.remove(14);//tests remove
		arrayStats("Testing removal of 14, should be looped after 4 then 9");
		hT.remove(9);
		arrayStats("Finally, the removal of 9");
		hT.add(4);
		hT.add(9);
		hT.add(14);
		arrayStats("Adding all back");
		System.out.println("Checking if 12, 9, and 4 are in the Hash Table: \n\t12: "+  hT.contains(12)+ "\n\t9: "+ hT.contains(9)+ "\n\t4: "+ hT.contains(4)+"\n");
		hT.add(18);
		hT.add(13);
		arrayStats("Added 18 and 13 to force a resize");
		System.out.println("Checking if 12, 9, and 4 are in the Hash Table again: \n\t12: "+  hT.contains(12)+ "\n\t9: "+ hT.contains(9)+ "\n\t4: "+ hT.contains(4)+"\n");
		System.out.println("Checking if 8, 18 and 13 are in the Hash Table: \n\t8: "+  hT.contains(8)+ "\n\t18: "+ hT.contains(18)+ "\n\t13: "+ hT.contains(13)+"\n");
		hT.remove(4);
		hT.remove(9);
		arrayStats("Removing 4 and 9");
		
		try {
			hT.remove(17);
		}
		catch(Exception e){
			arrayStats("Tried to remove 17, does not exist and should end in error.");
		}
		try{
			hT.add(0);
		}
		catch(Exception e){
			arrayStats("Tried to add 0, should result in error due to positive numbers only.");
		}
		try {
			hT.remove(-17);
		}
		catch(Exception e){
			arrayStats("Tried to remove -17, <=0 and doesn't exist-- should end in error.");
		}
		try {
			hT.contains(-4);
		}
		catch(Exception e){
			arrayStats("Tried to look for -4, it is <=0 and does not exist ");
		}
	}
	public static void arrayStats(String e ){
		System.out.println(e);
		System.out.println("Size: "+hT.size());
		System.out.println("State of Array:" + hT.toString() + "\n");
	}
}
