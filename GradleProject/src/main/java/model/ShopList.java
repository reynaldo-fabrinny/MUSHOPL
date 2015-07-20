package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="item_shoplist",
	joinColumns={@JoinColumn(name="SHOPLIST_ID", referencedColumnName="SHOPLIST_ID")},
	inverseJoinColumns={@JoinColumn(name="ITEM_ID", referencedColumnName="ITEM_ID")}) 
	private final List<Item> items;
	
	public ShopList()
	{
		this.items = new ArrayList<Item>();
	}
	
	public List<Item> getItems()
	{
		return this.items;
	}
	
	public void addItem(Item... items) 
	{
		for (int i = 0; i < items.length; i++) 
		{
			this.getItems().add(items[i]);
		}
	}
}
