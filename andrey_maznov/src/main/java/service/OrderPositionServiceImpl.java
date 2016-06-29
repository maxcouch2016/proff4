package service;

import java.util.List;

import dao.OrderPositionsDao;
import domain.OrderPositions;
 
public class OrderPositionServiceImpl implements OrderPositionService {
	private OrderPositionsDao orderPositionsDao = null;

	public OrderPositionServiceImpl(OrderPositionsDao orderPositionsDao) {
		this.orderPositionsDao = orderPositionsDao;
	}

	@Override
	public void addNewOrderPosition(OrderPositions order) {
		orderPositionsDao.create(order);
	}

	@Override
	public List<OrderPositions> getAllOrderPositions() {
		return orderPositionsDao.findAll();
	}

	@Override
	public void updateOrderPosition(OrderPositions order) {
		orderPositionsDao.update(order);
	}

	@Override
	public void deleteOrderPosition(OrderPositions order) {
		orderPositionsDao.delete(order);		
	}

	@Override
	public void addNewOrderPositions(OrderPositions[] orders) {
		for(OrderPositions order:orders){
			orderPositionsDao.create(order);
		}
		
	}

	@Override
	public List<OrderPositions> getAllOrderPositionsByBeginString(String begin) {
		return orderPositionsDao.findOrderPositionssByBeginString(begin);
	}


}

