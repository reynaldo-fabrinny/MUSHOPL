package models;

import java.util.ArrayList;

public class ShopList 
{
	private final ArrayList<Item> items;

	ShopList()
	{
		items = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	public void addItem(final Item item) 
	{
		this.items.add(item);
	}
}
