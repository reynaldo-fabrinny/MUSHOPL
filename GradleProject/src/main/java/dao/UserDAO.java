package dao;

import model.User;

public interface UserDAO
{
	public User existsUser(User user);
	public void addUser(User user);
}
