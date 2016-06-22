package dao;

import java.util.List;

import domain.Product;
 
 // CRUD
public interface ProductDao {
    Long create(Product product);
    Product read(Long id);
    void update(Product product);
    void delete(Product product);
    List<Product> findAll();
    List<Product> findProductsByBeginString(String begin);
}
