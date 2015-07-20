package dao;

import model.Item;
import model.User;

public interface UserDAO
{
	public User findUser(User user);
	public void createUser(User user);
	public void saveOrUpdateUser(User user);
}
