package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.User;

@Service
public class UserService 
{
	private UserDao userDao;
	
	 public void setUserDao(UserDao userDao) 
	 {
	        this.userDao = userDao;
	 }
	 
	 @Transactional
	 public void addUser(User u) 
	 {
		 this.userDao.addUser(u);
	 }
	
}
