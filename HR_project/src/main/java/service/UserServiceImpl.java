package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	@Autowired(required=true)
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void addNewUser(User user) {
		userDao.create(user);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDao.update(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDao.delete(user);
		
	}

}
