package service;

import java.util.ArrayList;
import java.util.List;

import domain.Product;

public class ServiceProductImpl implements ServiceProduct{

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		list.add(new Product("car"));
		list.add(new Product("auto"));
		list.add(new Product("moto"));
		return list;
	}

}
