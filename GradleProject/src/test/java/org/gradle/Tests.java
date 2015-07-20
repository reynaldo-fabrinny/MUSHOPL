package org.gradle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import dao.UserDAOImp;
import model.User;

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
	
	@Test
    public void canConstructAPersonWithAName() 
	{
       // assertEquals("Larry", person.getName());
		
		
		UserDAOImp s = new UserDAOImp();
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
