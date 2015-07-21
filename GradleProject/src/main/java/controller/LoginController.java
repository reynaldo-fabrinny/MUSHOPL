package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//	//MINHA TENTATIVA
//	@RequestMapping(value = ROOT, method = RequestMethod.GET)
//	public String login(Model model) 
//	{
//		System.out.println("ENTROU AQUI NO GET ----------");
//	
//		if(model.containsAttribute("msg"))
//		{
//			System.out.println("ENTROU AQUI NO ERRO ----------");
//			model.addAttribute("msg", "Invalid Login");
//		}
//		return "index";
//	}
//	
//	@RequestMapping(value = ROOT, method = RequestMethod.POST)
//	public ModelAndView login(@ModelAttribute User loginTry, Model model) 
//	{
//		model.addAttribute("loginTry", loginTry);
//		
//		if((this.loggedUser = this.loginService.existsUser(loginTry)) != null)
//		{
//			System.out.println("------------------------LOGADO");
//			return new ModelAndView("list", "userName",this.loggedUser.getName());
//		}
//		else
//		{
//			System.out.println("-----------------------ERRO");
//		//	model.addAttribute("msg", "Invalid Login");
//
//			return new ModelAndView(REDIRECT_PREFIX + ROOT);
//		}
//	}

	
	//SEGUNDO EXEMPLO
	
	@RequestMapping(value="/customLogin", method = RequestMethod.GET)
	public String customLogin(ModelMap map) {
 		return "index";
 	}
	@RequestMapping(value="/loginSuccess", method = RequestMethod.GET)
	public String success(ModelMap map) {
		map.addAttribute("msg", "Successfully logged in");
		return "success";
	}
	
//	-----------------------------------------------------------------------
	
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Custom Login Form");
//		model.addObject("message", "This is welcome page!");
//		model.setViewName("hello");
//		return model;
// 
//	}
// 
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Custom Login Form");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("admin");
// 
//		return model;
// 
//	}
// 
//	//Spring Security see this :
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(
//		@RequestParam(value = "error", required = false) String error,
//		@RequestParam(value = "logout", required = false) String logout) {
// 
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", "Invalid username and password!");
//		}
// 
//		if (logout != null) {
//			model.addObject("msg", "You've been logged out successfully.");
//		}
//		model.setViewName("login");
// 
//		return model;
// 
//	}
//	
	
	
	
	
	//--------------  LIST --------
	
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
