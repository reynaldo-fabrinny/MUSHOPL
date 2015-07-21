package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAOImp;
import model.User;

@Service
public class LoginService// implements UserDetailsService
{
	private UserDAOImp userDao;
	
	 public void setUserDao(UserDAOImp userDao) 
	 {
		 this.userDao = userDao;
	 }
	 
	 /**
	  * Verify if the given user exists. 
	  * returns the complete User if it does.
	  * returns null if it doesn't.
	  */
	 @Transactional
	 public User findUser(User user)
	 {
		 return this.userDao.findUser(user);
	 }
	 
	 /**
	  * Verify if the given user exists based on the email. 
	  * returns the complete User if it does.
	  * returns null if it doesn't.
	  */
	 @Transactional
	 public User findUser(final String email)
	 {
		 return this.userDao.findUser(email);
	 }
	 
	 /**
	  * Updates the user passed as parameter
	  * @param user
	  */
	 @Transactional
	 public void updateUser(User user) 
	 {
		 this.userDao.saveOrUpdateUser(user);
	 }
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
//	{
//		System.out.println("CHEGA AQUI PELO MENOS  2");
//		User user = userDao.findUser(email);
// 
//		List<GrantedAuthority> permitions = new ArrayList<GrantedAuthority>();
//		permitions.add(new SimpleGrantedAuthority("ROLE_USER"));
//		
//		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),permitions);
//	}

}
