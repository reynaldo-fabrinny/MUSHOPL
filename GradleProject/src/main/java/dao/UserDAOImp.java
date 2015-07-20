package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import model.Item;
import model.User;

@Repository
public class UserDAOImp implements UserDAO
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
        this.sessionFactory = sf;
    }
	
	public User existsUser(User user)
	{
		
		/*
		 * Query query = session.createSQLQuery(
			"select * from user where email= :email").addEntity(User.class).setParameter("email", user.getEmail());
			List result = query.list();
		 */
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", user.getEmail()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		User dbUser = (User) criteria.uniqueResult();
		
		return dbUser;
	}
	
	/**
	 * Version 2.0
	 */
    public void createUser(User u) 
    {
       //User user2 = new User("name", "email");
        
        
        Session session = this.sessionFactory.getCurrentSession();
        //session.persist(user2);
        long a = 0;
     //   System.out.println("sessao " + session);
        System.out.println(session.get(Item.class, a));
      //  session.save(user2);
       // Query createQuery = session.createQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES");
      // createQuery.executeUpdate();
       //System.out.println(object.getEmail());
        
      //  hibernateTemplate.save(user2);
      //  return user.getId();
    }

    /**
     * Receive a user as parameter and update it in the database
     */
	public void updateUser(final User user) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
}
