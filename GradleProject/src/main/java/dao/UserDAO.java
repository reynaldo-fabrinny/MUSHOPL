package dao;

import model.User;

public interface UserDAO
{
	public User findUser(User user);
	public void saveOrUpdateUser(User user);
}
