package service;

import java.util.List;

import domain.OrderPositions;;

public interface OrderPositionService {
	void addNewOrderPosition(OrderPositions orderPosition);
	void addNewOrderPositions(OrderPositions[] orderPosition);
	void updateOrderPosition(OrderPositions orderPosition);
	void deleteOrderPosition(OrderPositions orderPosition);
	List<OrderPositions> getAllOrderPositions();
	List<OrderPositions> getAllOrderPositionsByBeginString(String begin); 
}
