package org.gradle;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserDAOImp;
import model.Item;
import model.User;

@SuppressWarnings("deprecation")
public class Tests 
{
	 private static Configuration config;
     private static SessionFactory factory;
     private static Session hibernateSession;
     private static UserDAOImp userDAO;
     
     @BeforeClass
     public static  void init() 
     {
         config = new AnnotationConfiguration();
         config.configure("/META-INF/hibernateJUnitConfig.xml");
         config.setProperty("hibernate.current_session_context_class", "thread");
	     factory = config.buildSessionFactory();
	     hibernateSession = factory.openSession();
	     
	     ThreadLocalSessionContext.bind(hibernateSession);
	     
	     userDAO = new UserDAOImp();
	     userDAO.setSessionFactory(factory);
	     userDAO.saveOrUpdateUser(new User("Pedro","reynaldo@gmail.com","1234"));
	 }
   
	@Test(expected = org.hibernate.exception.ConstraintViolationException.class)
    public void canHaveUsersWithSameEmail() 
	{
		userDAO.saveOrUpdateUser(new User("reynaldo","reynaldo@gmail.com","1234"));
    }
	
	@Test
    public void checkPasswordRestrictions() 
	{
		//TODO 
    }

	/**
	 * Test responsive to check if the items are being added to the correct shopList
	 */
	@Test
    public void checkShopListsAndUsers() 
	{
		User user = userDAO.findUser("reynaldo@gmail.com");
		user.getShopList().getItems().add(new Item("Pinuts", 1));
		user.getShopList().getItems().add(new Item("Toilet Paper", 3));
		user.getShopList().getItems().add(new Item("Beer", 50));
		user.getShopList().getItems().add(new Item("Wine", 2));
		userDAO.saveOrUpdateUser(user);
		assertEquals(4, user.getShopList().getItems().size());
		
		User user2 = new User("pedro","pedro@gmail.com","1234");
		userDAO.saveOrUpdateUser(user2);
		
		user2.getShopList().getItems().add(new Item("feijoada em lata",3));
		assertEquals(1, user2.getShopList().getItems().size());
		assertEquals(4, user.getShopList().getItems().size());	
    }
	
}
