package models;

public class User 
{
	  private final String name;
	  private String email;
	  private String password;
	  
	  private ShopList shopList;
	  
	  User(String name, String email)
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

	public void setShopList(ShopList shopList) {
		this.shopList = shopList;
	}

	public String getName() {
		return name;
	}
}
