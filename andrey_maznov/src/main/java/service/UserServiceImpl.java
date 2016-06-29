package service;

import java.util.List;

import dao.UserDao;
import domain.User;
 
public class UserServiceImpl implements UserService {
	private UserDao userDao = null;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addNewUser(User user) {
		userDao.create(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);		
	}

	@Override
	public void addNewUsers(User[] users) {
		for(User user:users){
			userDao.create(user);
		}
		
	}

	@Override
	public List<User> getAllUsersByBeginString(String begin) {
		return userDao.findUsersByBeginString(begin);
	}


}

