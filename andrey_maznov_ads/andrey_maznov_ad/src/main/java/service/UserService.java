package service;

import java.util.List;

import dao.UserDao;
import domain.Catalog;
import domain.User;

public class UserService {

	private UserDao userDao = null;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public void addNewUser(User user) {
		userDao.create(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);		
	}

	public void addNewUsers(User[] users) {
		for(User user:users){
			userDao.create(user);
		}
		
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User getUserByName(String name) {
		return userDao.findUserByName(name);
	}
	
	public User getUserByLoginPassword(String login, String password) {
		return userDao.findUserByLoginPassword(login, password);
	}
	
}
