package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDao 
{
//	@PersistenceContext
//    private EntityManager em;
     
	private SessionFactory sessionFactory;
	
//	@Autowired
//	private HibernateTemplate  hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
    public void addUser(User u) 
    {
        //em.persist(user);
        User user2 = new User("name", "email");
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user2);
        
      //  hibernateTemplate.save(user2);
      //  return user.getId();
    }
     
//    public List<User>getAll() {
//        return em.createQuery("SELECT p FROM User p", User.class).getResultList();
//    }
}
