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
    @Column(name="ITEM_ID", nullable = false)
	private Long id;
	
	@Column(name="NAME", nullable = false)
	private String name;

	@Column(name="QUANTITY", nullable = false)
	private int quantity;
	
	Item(){
	}
	
	Item(final String name, final int quantity) 
	{
		this.name = name;
		this.quantity = quantity;
	}
	Item(String name)
	{
		this(name,1);
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
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
