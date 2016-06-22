package action03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class ProductShop {
	static Map<Product,String> contructors = new HashMap<Product,String>();
	public ProductShop(){
		contructors.put(new Product("Bread White",TypeProduct.Bread, 10),"Firma 3");
		contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 10),"Firma 3");
		
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 12),"Firma 3");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 12),"Firma 3");
		
		contructors.put(new Product("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 16),"Firma 1");
		contructors.put(new Product("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 18),"Firma 1");

		contructors.put(new Product("Bread White",TypeProduct.Bread, 20),"Firma 2");
		contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 20),"Firma 2");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 20),"Firma 2");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 20),"Firma 2");
		
	}
	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();
		shop.printReverseContructor();
		shop.printNameProductByType(TypeProduct.Yogurt);
		
//		
//		Set<Entry<Product, String>> set = contructors.entrySet();
//		for(Entry<Product, String> entry:set){
//			System.out.print(entry.getKey()+" ");
//			System.out.println(entry.getValue());			
//		}
//		
//		Collection<String> values = map.values();
//		Set<Integer> keys = map.keySet();
//		//
//		Set<String> set1 = new TreeSet<>(
//				(a,b)->{return b.compareTo(a);});
//		set1.add("pic");
//		set1.add("rtf");
//		set1.add("aaa");
//		set1.add("doc");
//		System.out.println(set1);
		
		/*Задача 1. Написать программу:
			Enum TypeProduct{Bread, Yogurt, Milk}
			class Product{name, TypeProduct type, int numberParty}
			ProductShop{Map<Product, String> shop(Product, NameOfContructor)}
			Добавить в Карту по паре продуктов каждого типа.
			Сделать:
			1) Вывести список фирм в алфавитном порядке
			2) Вывести список фирм в обратном порядке
			3) Вывести уникальные наименования товаров с фильтром по типу продукта*/

	}
	public void printContructor(){

	}
	public void printReverseContructor(){

	}
	public void printNameProductByType(TypeProduct type){

	}
}
class Product{
	private String name;
	private TypeProduct type;
	private int party;
	
	public Product(String name, TypeProduct type, int party) {
		super();
		this.name = name;
		this.type = type;
		this.party = party;
	}
	@Override
	public String toString() {
		return name + " " + party;
	}
	@Override
	public int hashCode() {
		return party+name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (party != other.party)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	public TypeProduct getType() {
		return type;
	}
	public String getName() {
		return name;
	}	
}


