package dao;

import model.User;

public interface UserDAO
{
	public User findUser(User user);
	public User findUser(String email);
	public void saveOrUpdateUser(User user);
}
