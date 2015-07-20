package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAOImp;
import model.Item;
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
	 @Transactional
	 public User existsUser(User user)
	 {
		 return this.userDao.findUser(user);
	 }
	 
	 /**
	  * Creates a new user
	  * @param user
	  */
	 @Transactional
	 public void createUser(User user) 
	 {
		 this.userDao.createUser(user);
	 }
	 
	 @Transactional
	 public void updateUser(User user) 
	 {
		 this.userDao.saveOrUpdateUser(user);
	 }
	 
	 /**
	  * Return the ShoppingList from the User.
	  */
	 public ShopList getShoppingList(User user)
	 {
		 return null;
		 
	 }
	 
	
}
