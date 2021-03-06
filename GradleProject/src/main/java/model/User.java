package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL")})
public class User 
{
	@Id
    @GeneratedValue
    @Column(name="USER_ID", nullable = false)
	private Long id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	 
	@Column(name="EMAIL", nullable = false)
	private String email;
	 
	@Column(name="PASSWORD", nullable = false)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="SHOPLIST_ID")
	private ShopList shopList;
	  
	public User(){}
	  
	public User(String email, String password)
	{
		this.password = password;
		this.email = email;
		this.shopList = new ShopList();
	}
	public User(String name, String email, String password)
	{
		this(email, password);
		this.name = name;
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
