package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAOImp;
import model.ShopList;
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
	 public User existsUser(User user)
	 {
		 return this.userDao.existsUser(user);
	 }
	 
	 /**
	  * Creates a new user
	  * @param user
	  */
	 @Transactional
	 public void addUser(User user) 
	 {
		 this.userDao.addUser(user);
	 }
	 
	 /**
	  * Return the ShoppingList from the User.
	  */
	 public ShopList getShoppingList(User user)
	 {
		 return null;
		 
	 }
	 
	
}
