package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAOImp;
import model.User;

@Service
public class LoginService 
{
	private UserDAOImp userDao;
	
	 public void setUserDao(UserDAOImp userDao) 
	 {
		 this.userDao = userDao;
	 }
	 
	 /**
	  * Verify if the given user exists. 
	  * returns the complete User if it does.
	  * returns null if it doesn't.
	  */
	 @Transactional
	 public User existsUser(User user)
	 {
		 return this.userDao.findUser(user);
	 }
	 
	 /**
	  * Updates the user passed as parameter
	  * @param user
	  */
	 @Transactional
	 public void updateUser(User user) 
	 {
		 this.userDao.saveOrUpdateUser(user);
	 }
}
