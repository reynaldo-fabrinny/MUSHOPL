package dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.ShopList;
import model.User;

@Repository
public class UserDao 
{
	private SessionFactory sessionFactory;
	
	//TODO ERASE
	User dumpDataUser;
	
	public void setSessionFactory(SessionFactory sf)
	{
        this.sessionFactory = sf;
    }
	
	public User existsUser(User user)
	{
		// Checks in the database is the user exists, if it does, returns the User
		dumpDataUser = new User("reynaldo","reynaldo@gmail.com");
		
		return dumpDataUser;
	}
	
    public void addUser(User u) 
    {
        User user2 = new User("name", "email");
        
        
      //  Session session = this.sessionFactory.getCurrentSession();
        //session.persist(user2);
      //  long a = 0;
     //   System.out.println("sessao " + session);
      //  System.out.println(session.get(Item.class, a));
      //  session.save(user2);
      // Query createQuery = session.createQuery("create table aa  (id INTEGER NOT NULL IDENTITY)");
       // Query createQuery = session.createQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES");
      // createQuery.executeUpdate();
       //System.out.println(object.getEmail());
        
      //  hibernateTemplate.save(user2);
      //  return user.getId();
    }
     
//    public List<User>getAll() {
//        return em.createQuery("SELECT p FROM User p", User.class).getResultList();
//    }
}
