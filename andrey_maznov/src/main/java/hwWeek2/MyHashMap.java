package hwWeek2;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

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

	static class MyEntry<K, V> {

		K key;
		V val;
		MyEntry<K, V> next;

		public MyEntry(K key, V val) {
			this.key = key;
			this.val = val;
		}
		
		public MyEntry(MyEntry<K, V> entry) {
			this.key = entry.key;
			this.val = entry.val;
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
	
	@SuppressWarnings("unchecked")
	public MyHashMap(int capacity, float loadFactor) {
		this.loadFactor = (loadFactor > 0) ? loadFactor : 0.75f;

		if (capacity > 1 && Math.sqrt(capacity) % 1 == 0) {
			this.capacity = capacity;
		} else {
			this.capacity = 16;
		}

		arr = (MyEntry<K, V>[]) Array.newInstance(MyEntry.class, capacity);

	}

	class EntrySet extends AbstractSet<MyEntry<K,V>> {

		@Override
		public Iterator<MyEntry<K, V>> iterator() {
			return new Iterator<MyEntry<K,V>>() {

				int cursor;
				int index;
				MyEntry<K, V> lastRet;
		        int currentModCount = modCount;
		        
		        public boolean hasNext() {
		            return cursor != size; 
		        }

		        public MyEntry<K, V> next() {
		            int i = cursor;
		            if (i >= size)
		                throw new NoSuchElementException();
		            if (modCount != currentModCount)
		            	throw new ConcurrentModificationException();
		            cursor = i + 1;
		            
		            if (lastRet == null || lastRet.next == null) {
		            	for (int j = index; j < arr.length; j++) {
		            		if (arr[j] != null) {
		            			lastRet = arr[j];
		            			index = j + 1;
		            			break;
		            		}
		            	}
		            }
		            else {
		            	lastRet = lastRet.next;
		            }
		            
		            return (MyEntry<K, V>) lastRet;
		        }
			};
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	
	public Set<MyEntry<K, V>> entrySet() {
		return new EntrySet();
	}
	
	public boolean put(K key, V val) {

		keyIsNull(key);
		ensureCapacity();

		int index = calcIndex(key);

		if (index > arr.length || index < 0) {
			System.out.println();
		}
		
		if (arr[index] != null) {
			MyEntry<K, V> entry = arr[index];
			while (entry != null) {
				if (entry.key.equals(key)) {
					entry.val = val;
					entry = null;
				}
				else if (entry.next == null) {
					entry.next = new MyEntry<K, V>(key, val);
					entry = null;
					size++;
				} else {
					entry = entry.next;
				}
			}
		} else {
			arr[index] = new MyEntry<K, V>(key, val);
			size++;
		}

		modCount++;
		return true;
	}

	private int calcIndex(K key) {
		int index = key.hashCode() % capacity;
		return index < 0 ? -index : index ;
	}

	private void ensureCapacity() {

		if (size == capacity * loadFactor) {
			capacity = capacity * 2;
			@SuppressWarnings("unchecked")
			MyEntry<K, V>[] newArr = (MyEntry<K, V>[]) Array.newInstance(MyEntry.class, capacity);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null) {
					MyEntry<K, V> entry = arr[i];
					
					while (entry != null) {
						
						int index = calcIndex(entry.key);
						
						if (newArr[index] == null) {
							newArr[index] = new MyEntry<K, V>(entry);
						} 
						else {
							MyEntry<K, V> temp = newArr[index];
							while (temp != null) {
								if (temp.next == null) {
									temp.next = new MyEntry<K, V>(entry);
									temp = null;
								} else {
									temp = temp.next;
								}
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
					entry = entry.next;
					if (count < size) {
						sb.append(", ");
					}
				}
			}
		}
		return sb.append("}").toString();
	}

	public V get(K key) {
		keyIsNull(key);
		int index = calcIndex(key);
		
		if (arr[index] != null) {
			MyEntry<K, V> entry = arr[index];
			while (entry != null) {
				if (entry.key.equals(key)) {
					return entry.val;
				}
				entry = entry.next;
			}
		}
		
		return null;
	}
	
	public boolean remove(K key) {
		
		keyIsNull(key);
		int index = calcIndex(key);
		
		if (arr[index] != null) {
			MyEntry<K, V> entry = arr[index];
			MyEntry<K, V> parent = null;
			while (entry != null) {
				if (entry.key.equals(key)) {
					
					if (parent != null) {
						parent.next = entry.next;
					}
					else {
						arr[index] = entry.next;
					}
					size--;
					modCount++;
					return true;
				}
				parent = entry;
				entry = entry.next;
			}
		}
				
		return false;
	}

}
