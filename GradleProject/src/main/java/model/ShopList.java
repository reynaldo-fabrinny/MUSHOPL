package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy = "shopList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private final List<Item> items;
	
	public ShopList()
	{
		this.items = new ArrayList<Item>();
	}
	
	public List<Item> getItems()
	{
		return this.items;
	}
	
	public void addItem(final Item item) 
	{
		System.out.println("lista de items:" + this.items);
		System.out.println("tamanho lista de items:" + this.items.size());
		this.getItems().add(item);
	}
}
