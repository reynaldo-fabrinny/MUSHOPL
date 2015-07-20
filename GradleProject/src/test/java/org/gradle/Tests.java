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
    public void createItemWithoutName() 
	{
		
    }
	
	@Test
    public void quantityOfItems() 
	{
		User user = userDAO.findUser("reynaldo@gmail.com");
		user.getShopList().addItem(
				new Item("pasta", 2),
				new Item("rice", 1),
				new Item("beans", 3),
				new Item("fish", 2));
		userDAO.saveOrUpdateUser(user);
		assertEquals(4, user.getShopList().getItems().size());
		
		User user2 = new User("pedro","pedro@gmail.com","1234");
		userDAO.saveOrUpdateUser(user2);
		
		user2.getShopList().addItem(new Item("feijoada em lata",3));
		assertEquals(1, user2.getShopList().getItems().size());
		assertEquals(4, user.getShopList().getItems().size());	
    }
	
}
