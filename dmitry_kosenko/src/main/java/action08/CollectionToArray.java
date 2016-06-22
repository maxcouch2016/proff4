package action08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionToArray {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4};
		
		
		List<Integer> list = 
				new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4}));
		Integer[] massive = list.toArray(new Integer[]{});
		
	}
}
