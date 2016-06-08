package hwWeek2;

import java.lang.reflect.Array;

/*
Задача 2. Написать собственную реализацию MyHashMap<K, V>
Реализовать методы MyHashMap:
1. boolean put(K, V)
2. User get( K )
3. int size()
4. boolean remove(K key)
5. MyEntry<K, V> entrySet()

Наименование класса может звучать так: MyHashMap, при этом нельзя использовать HashMap.
Примечание: напоминаю, что карта состоит из массива, элементами которого являются односвязанные списки.

Для хранения пары значений рекомендую создать класс MyEntry c двумя полями соответсвенно для ключа key и значения value.
 */

public class MyHashMap<K, V> {

	private int size;
	private int capacity;
	private float loadFactor;
	private MyEntry<K, V>[] arr;
	private int modCount;

	class MyEntry<K, V> {

		K key;
		V val;
		MyEntry<K, V> next;

		public MyEntry(K key, V val) {
			this.key = key;
			this.val = val;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return val;
		}

	}

	public MyHashMap() {
		this(16, 0.75f);
	}

	public MyHashMap(int capacity) {
		this(capacity, 0.75f);
	}

	public MyHashMap(float loadFactor) {
		this(16, loadFactor);
	}

	public MyHashMap(int capacity, float loadFactor) {
		this.loadFactor = (loadFactor > 0) ? loadFactor : 0.75f;

		if (capacity > 1 && Math.sqrt(capacity) % 1 == 0) {
			this.capacity = capacity;
		} else {
			this.capacity = 16;
		}

		arr = (MyEntry<K, V>[]) Array.newInstance(MyEntry.class, capacity);

	}

	public boolean put(K key, V val) {

		keyIsNull(key);
		ensureCapacity();

		int index = calcIndex(key);
		
		if (arr[index] != null) {
			MyEntry<K, V> entry = arr[index];
			while (entry != null) {
				if (entry.next == null) {
					entry.next = new MyEntry<K, V>(key, val);
					entry = null;
				}
				entry = entry.next;
			}
		}
		else {
			arr[index] = new MyEntry<K, V>(key, val);
		}
		
		size++;
		modCount++;
		return true;
	}

	private int calcIndex(K key) {
		return key.hashCode() % capacity;
	}

	private void ensureCapacity() {

		if (size == capacity * loadFactor) {
			capacity = capacity * 2;
			MyEntry<K, V>[] newArr = (MyEntry<K, V>[]) Array.newInstance(MyEntry.class, capacity);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null) {
					MyEntry<K, V> entry = arr[i];
					while (entry != null) {
						int index = calcIndex(entry.key);
						if (newArr[index] == null) {
							newArr[index] = entry;
						} else {
							MyEntry<K, V> temp = newArr[index];
							while (temp != null) {
								if (temp.next == null) {
									temp.next = entry;
									temp = null;
								}
								temp = temp.next;
							}
						}
						entry = entry.next;
					}
				}
			}
			arr = newArr;
		}
	}

	private void keyIsNull(K key) {
		if (key == null)
			throw new NullPointerException();
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				MyEntry<K, V> entry = arr[i];
				while (entry != null) {
					sb.append(entry.getKey()).append("=").append(entry.getValue());
					count++;
				}
				if (count < size) {
					sb.append(", ");
				}
			}
		}
		return sb.append("]").toString();
	}
	
	public static void main(String[] args) {
		
		MyHashMap<Integer, String> map = new MyHashMap<>();
		for (int i = 0; i < 20; i++) {
			map.put(i, Integer.toString(i));
		}
		System.out.println(map.size);
		System.out.println(map.capacity);
		System.out.println(map);
	
	}
	
}
