package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
	@JoinColumn(name ="SHOPLIST_ID")
	private ShopList shopList;
	
	Item(){}
	
	Item(final String name, final int quantity) 
	{
		this.name = name;
		this.quantity = quantity;
	}
	Item(final String name)
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
	public ShopList	getShopList()
	{
		return shopList;
	}
	public void setShopList(ShopList shopList)
	{
		this.shopList = shopList;
	}
}
