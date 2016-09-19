package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

	private UserDao dao;

	@Autowired
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
		
   	@Override
	public void addNew(User user) {
		dao.create(user);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public void delete(User user) {
		dao.delete(user);
	}

	@Override
//	@Transactional(readOnly = true)
	@Transactional
	public List<User> getAll() {
		return dao.findAll();
	}

}
