package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item 
{
	@Id
    @GeneratedValue
    @Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="bought")
	private boolean bought;
	
	Item(){
	}
	
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

	public String getName() 
	{
		return name;
	}
	public int getQuantity() 
	{
		return quantity;
	}
	public void setName(String name) {
		this.name = name;
	}
}
