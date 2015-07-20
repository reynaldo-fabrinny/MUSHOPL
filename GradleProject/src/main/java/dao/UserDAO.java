package dao;

import model.Item;
import model.User;

public interface UserDAO
{
	public User existsUser(User user);
	public void createUser(User user);
	public void updateUser(User user);
}
