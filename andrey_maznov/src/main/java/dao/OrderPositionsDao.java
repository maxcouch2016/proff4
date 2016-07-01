package dao;

import java.util.List;

import domain.OrderPositions;
 
 // CRUD
public interface OrderPositionsDao {
    Long create(OrderPositions orderPosition);
    OrderPositions read(Long id);
    void update(OrderPositions orderPosition);
    void delete(OrderPositions orderPosition);
    List<OrderPositions> findAll();
    List<OrderPositions> findOrderPositionssByBeginString(String begin);
}
