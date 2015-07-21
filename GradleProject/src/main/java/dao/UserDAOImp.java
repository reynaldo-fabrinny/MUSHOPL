package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDAOImp implements UserDAO
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
        this.sessionFactory = sf;
    }
	
	public User findUser(User user)
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
	public User findUser(String email)
	{
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		User dbUser = (User) criteria.uniqueResult();
		
		return dbUser;
	}
    
    /**
     * Receive a user as parameter and update it in the database
     */
	public void saveOrUpdateUser(final User user) 
	{
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
}
