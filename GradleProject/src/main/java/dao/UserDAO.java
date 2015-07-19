package dao;

import model.Item;
import model.User;

public interface UserDAO
{
	public User existsUser(User user);
	public void addUser(User user);
	public void addItemInTheList(User user, Item item);
}
