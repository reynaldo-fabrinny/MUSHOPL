package org.gradle;

import org.junit.Test;

import dao.UserDAOImp;
import model.User;
import service.LoginService;

import static org.junit.Assert.*;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Tests 
{
	private EntityManagerFactory emf;
    private EntityManager em;
	
	@Before
	public void setUp()
	{
	 
        emf = Persistence.createEntityManagerFactory("jpaData");
        em = emf.createEntityManager();
        em.getTransaction().begin();
	}
	//@AfterClass 
	
	
	
	@Test
    public void canConstructAPersonWithAName() 
	{
      //  Person person = new Person("Larry");
       // assertEquals("Larry", person.getName());
		
		
		UserDAOImp s= new UserDAOImp();
		s.createUser(new User("reynaldo","reynaldo@gmail.com","1234"));
    }
	
	@Test
    public void createItemWithoutName() 
	{
    }
	
	@Test
    public void createItemNegativeQuantity() 
	{
    }
	
	@Test
    public void createUserWithExistentEmail() 
	{
    }
}
