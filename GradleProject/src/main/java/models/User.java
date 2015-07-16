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
	
}
