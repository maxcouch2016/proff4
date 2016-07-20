package action03;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.mysql.fabric.xmlrpc.base.Array;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		map.put(10, "Product 1");
		map.put(20, "Product 2");
		map.put(30, "Product 3");
		map.put(15, "Product 1.5");
		
		Set<Entry<Integer, String>> set = map.entrySet();
		for(Entry<Integer, String> entry:set){
			System.out.print(entry.getKey()+" ");
			System.out.println(entry.getValue());			
		}
		
		Collection<String> values = map.values();
		Set<Integer> keys = map.keySet();
		//
		Set<String> set1 = new TreeSet<>(
				(a,b)->{return b.compareTo(a);});
		set1.add("pic");
		set1.add("rtf");
		set1.add("aaa");
		set1.add("doc");
		System.out.println(set1);
		
		
	}
}
