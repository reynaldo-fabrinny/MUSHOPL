package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Item;
import model.User;
import service.LoginService;
 
@Controller
public class LoginController  extends AbstractController
{ 
	private LoginService loginService;
	private User loggedUser;
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setUserService(LoginService ls)
	{
		this.loginService = ls;
	}

	@RequestMapping(value = ROOT, method = RequestMethod.GET)
	public String login(Model model) 
	{
		System.out.println("ENTROU AQUI NO GET ----------");
	
		if(model.containsAttribute("msg"))
		{
			System.out.println("ENTROU AQUI NO ERRO ----------");
			model.addAttribute("msg", "Invalid Login");
		}
		return "index";
	}
	
	@RequestMapping(value = ROOT, method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User loginTry, Model model) 
	{
		model.addAttribute("loginTry", loginTry);
		
		if((this.loggedUser = this.loginService.existsUser(loginTry)) != null)
		{
			System.out.println("------------------------LOGADO");
			return new ModelAndView("list", "userName",this.loggedUser.getName());
		}
		else
		{
			System.out.println("-----------------------ERRO");
		//	model.addAttribute("msg", "Invalid Login");

			return new ModelAndView(REDIRECT_PREFIX + ROOT);
		}
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView listItems(Model model) 
	{
		model.addAttribute("items", this.loggedUser.getShopList().getItems());
		if(this.loggedUser != null )
		{
			model.addAttribute("userName", this.loggedUser.getName());
		}
		ModelAndView mv = new ModelAndView("list");
		return mv;
	}
	
	@RequestMapping("list")
	public String addItem(Item item) 
	{
		System.out.println("----------------------- logedUser id " + this.loggedUser.getId());
		System.out.println("-----------------------logedUser shop List " + this.loggedUser.getShopList());
		System.out.println("-----------------------item name " +  item.getName());
		
		
		this.loggedUser.getShopList().addItem(item);
		
		System.out.println("-----------------------logedUser shop List " + this.loggedUser.getShopList());
		System.out.println("-----------------------item name " +  item.getShopList());
		
		
		this.loginService.updateUser(this.loggedUser);
	    return REDIRECT_PREFIX + "list";
	}
	
}
