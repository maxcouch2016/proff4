package hwWeek2;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import hwWeek2.MyHashMap.MyEntry;

public class MyHashMapTest {

	private HashMap<Integer, String> hashMap;
	private MyHashMap<Integer, String> myHashMap;
	
	private MyEntry<Integer, String>[] arrayMyEntry; 
	private Entry<Integer, String>[] arrayEntry; 
	
	private HashMap<User, Product> hashMapObject;
	private MyHashMap<User, Product> myHashMapObject;
	
	private MyEntry<User, Product>[] arrayMyEntryObject; 
	private Entry<User, Product>[] arrayEntryObject;
	
	class User {
		private String name;
		private int age;
		
		public User(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		private MyHashMapTest getOuterType() {
			return MyHashMapTest.this;
		}
		
	}
	
	class Product {
		private String name;
		private String brand;
		private float price;
		
		public Product(String name, String brand, float price) {
			super();
			this.name = name;
			this.brand = brand;
			this.price = price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((brand == null) ? 0 : brand.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + Float.floatToIntBits(price);
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (brand == null) {
				if (other.brand != null)
					return false;
			} else if (!brand.equals(other.brand))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
				return false;
			return true;
		}
		private MyHashMapTest getOuterType() {
			return MyHashMapTest.this;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		hashMap = new HashMap<>();
		myHashMap = new MyHashMap<>();
		
		hashMapObject = new HashMap<>();
		myHashMapObject = new MyHashMap<>();
		
		for (int i = 0; i < 11; i++) {
			int key = (int) (Math.random() * 1000);
			String val = "Value" + Integer.toString((int) (Math.random() * 1000));
			hashMap.put(key, val);
			myHashMap.put(key, val);
		}
		
		arrayMyEntry = (MyEntry<Integer, String>[]) Array.newInstance(MyEntry.class, myHashMap.size());
		arrayEntry = (Entry<Integer, String>[]) Array.newInstance(Entry.class, hashMap.size());
		
		int j = 0;
		for (Entry<Integer, String> entry : hashMap.entrySet()) {
			arrayEntry[j] = entry;
			j++;
		}
		
		j = 0;
		
		for (MyEntry<Integer, String> entry : myHashMap.entrySet()) {
			arrayMyEntry[j] = entry;
			j++;
		}
		
		for (int i = 0; i < 11; i++) {
			User key = new User("name" + Integer.toString((int) (Math.random() * 1000)), (int) (Math.random() * 1000));
			Product val = new Product("product" + Integer.toString((int) (Math.random() * 1000)), "brand" + Integer.toString((int) (Math.random() * 1000)), (float)(Math.random() * 1000));
			hashMapObject.put(key, val);
			myHashMapObject.put(key, val);
		}
		
		arrayMyEntryObject = (MyEntry<User, Product>[]) Array.newInstance(MyEntry.class, myHashMapObject.size());
		arrayEntryObject = (Entry<User, Product>[]) Array.newInstance(Entry.class, hashMapObject.size());
		
		j = 0;
		
		for (Entry<User, Product> entry : hashMapObject.entrySet()) {
			arrayEntryObject[j] = entry;
			j++;
		}
		
		j = 0;
		
		for (MyEntry<User, Product> entry : myHashMapObject.entrySet()) {
			arrayMyEntryObject[j] = entry;
			j++;
		}
		
	}
	
	@Test
	public void testIntegerString() {
		for (int i = 0; i < arrayEntry.length; i++) {
			if (!arrayEntry[i].getKey().equals(arrayMyEntry[i].getKey())) {
				fail("Expected " + arrayEntry[i].getKey() + " != " + arrayMyEntry[i].getKey());
			}
		}
	}
	
	@Test
	public void testUserProduct() {
		for (int i = 0; i < arrayEntryObject.length; i++) {
			if (!arrayEntryObject[i].getKey().equals(arrayMyEntryObject[i].getKey())) {
				fail("Expected " + arrayEntryObject[i].getKey() + " != " + arrayMyEntryObject[i].getKey());
			}
		}
	}
	
}
