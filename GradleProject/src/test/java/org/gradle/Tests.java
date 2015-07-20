package org.gradle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserDAOImp;
import model.User;

@SuppressWarnings("deprecation")
public class Tests 
{
	 private static Configuration config;
     private static SessionFactory factory;
     private static Session hibernateSession;
     
     @BeforeClass
     public static  void init() {
         config = new AnnotationConfiguration();
         config.configure("/META-INF/hibernateJUnitConfig.xml");
         config.setProperty("hibernate.current_session_context_class", "thread");
	     factory = config.buildSessionFactory();
	     hibernateSession = factory.openSession();
	     
	     ThreadLocalSessionContext.bind(hibernateSession);
	 }
   
	@Test(expected = org.hibernate.exception.ConstraintViolationException.class)
    public void canHaveUsersWithSameEmail() 
	{
		UserDAOImp s = new UserDAOImp();
		s.setSessionFactory(factory);
		
		s.updateUser(new User("Pedro","reynaldo@gmail.com","1234"));
		s.updateUser(new User("reynaldo","reynaldo@gmail.com","1234"));
    }
	
	@Test
    public void createItemWithoutName() 
	{
    }
	
	@Test
    public void createItemNegativeQuantity() 
	{
		UserDAOImp s = new UserDAOImp();
		s.setSessionFactory(factory);
		
		//s.updateUser(new User("Pedro","reynaldo@gmail.com","1234"));
		
    }
	
}
