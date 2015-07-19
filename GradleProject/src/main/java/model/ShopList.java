package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SHOPLIST")
public class ShopList 
{
	@Id
    @GeneratedValue
    @Column(name="SHOPLIST_ID", nullable = false)
	private Long id;
	
	private final ArrayList<Item> items;
	
	public ShopList()
	{
		this.items = new ArrayList<Item>();
	}
	
	@OneToMany(mappedBy="ITEM", fetch=FetchType.EAGER)
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	public void addItem(final Item item) 
	{
		this.items.add(item);
	}
}
