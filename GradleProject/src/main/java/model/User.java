package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User 
{
	@Id
    @GeneratedValue
    @Column(name="USER_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	 
	@Column(name="EMAIL")
	private String email;
	 
	@Column(name="PASSWORD")
	private String password;
	
	@OneToOne
	@JoinColumn(name="SHOPLIST_ID")
	private ShopList shopList;
	  
	public User(){}
	  
	public User(String name, String email)
	{
	  this.name = name;
	  this.email = email;
	  this.shopList = new ShopList();
	}
	  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShopList getShopList() {
		return shopList;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
