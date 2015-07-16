package models;

public class Item 
{
	private final String name;
	private int quantity;
	private String brand;
	private boolean bought;
	
	Item(final String name, final int quantity) 
	{
		this.name = name;
		this.quantity = quantity;
		this.bought = false;
	}

	Item(String name)
	{
		this(name,1);
	}
	
	public boolean isBought() 
	{
		return bought;
	}
	public void setBought(boolean bought) 
	{
		this.bought = bought;
	}
	public String getBrand() 
	{
		return brand;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	public String getName() 
	{
		return name;
	}
	public int getQuantity() 
	{
		return quantity;
	}
}
