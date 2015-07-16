package models;

public class Item 
{
	private final String name;
	private int quantity;
	private String brand;
	
	Item(final String name, final int quantity) 
	{
		this.name = name;
		this.quantity = quantity;
	}
	
	Item(String name)
	{
		this(name,1);
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
