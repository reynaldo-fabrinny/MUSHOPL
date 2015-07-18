package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.User;

@Transactional
public class UserDaoI 
{
	@PersistenceContext
    private EntityManager em;
     
    public Long save(User user) 
    {
        em.persist(user);
        return user.getId();
    }
     
    public List<User>getAll() {
        return em.createQuery("SELECT p FROM User p", User.class).getResultList();
    }
}
