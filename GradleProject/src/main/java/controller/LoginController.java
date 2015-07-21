package controller;

import model.Item;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.LoginService;
 
@Controller
public class LoginController extends AbstractController
{ 
	private LoginService loginService;
	private User loggedUser;
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setUserService(LoginService ls)
	{
		this.loginService = ls;
	}

	@RequestMapping(value= {ROOT, "/login"}, method = RequestMethod.GET)
	public ModelAndView  customLogin() 
	{
			ModelAndView model = new ModelAndView();
			model.setViewName("login");
	 
			return model;
 	}

	@RequestMapping(value = LIST_PAGE, method = RequestMethod.GET)
	public ModelAndView listItems(Model model) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    this.loggedUser = this.loginService.findUser(auth.getName());
		
		model.addAttribute("items", this.loggedUser.getShopList().getItems());
		if(this.loggedUser != null )
		{
			model.addAttribute("userName", this.loggedUser.getName());
		}
		ModelAndView mv = new ModelAndView(LIST_PAGE);
		return mv;
	}
	
	@RequestMapping(LIST_PAGE)
	public String addItem(Item item) 
	{
		addItemInShopList(item);
		this.loginService.updateUser(this.loggedUser);
		
	    return REDIRECT_PREFIX + LIST_PAGE;
	}

	private void addItemInShopList(Item... items) 
	{
		for (int i = 0; i < items.length; i++) 
		{
			this.loggedUser.getShopList().getItems().add(items[i]);
		}
	}
	
}
