package action06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayLitsSynchronized {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 =
				Collections.synchronizedList(list);
		
		list.add(1);
		list1.add(2);		
	}
}
 