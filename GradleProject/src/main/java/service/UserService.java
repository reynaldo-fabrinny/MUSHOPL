package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.User;

@Service
public class UserService 
{
	private UserDao userDaoI;
	
	 public void setUsernDAO(UserDao userDaoI) 
	 {
	        this.userDaoI = userDaoI;
	 }
	 
	 @Transactional
	 public void addUser(User u) 
	 {
		 this.userDaoI.addUser(u);
	 }
	
}
