package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopList 
{
	@Id
    @GeneratedValue
	private Integer id;
	
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
