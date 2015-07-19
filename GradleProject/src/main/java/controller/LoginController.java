package controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
//import service.ApplicationService;
import service.UserService;
 
@Controller
public class LoginController 
{ 
	private UserService userService;
	
	 @Autowired(required=true)
	 @Qualifier(value="userService")
	 public void setUserService(UserService us)
	 {
		 this.userService = us;
	 }
	//private final ApplicationService applicationService;
 
//	@Autowired
//	public MainController(ApplicationService applicationService) {
//		this.applicationService = applicationService;
//	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model) 
	{
		//model.put("title", applicationService.getTitle(""));
		model.addAttribute("loginTry", new User());
		//model.put("msg", helloWorldService.getDesc());
 
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute User loginTry, ModelMap model) 
	{
		model.addAttribute("loginTry", loginTry);
		System.out.println(loginTry.getEmail() + "  pegou o valor do user ");
		
		//model.put("msg", helloWorldService.getDesc());
		//this.userService.addUser(new User());
		
		// PRESTAR ATENCAO NA LOGICA AQUIs
		if(this.userService.existsUser(loginTry) != null )
		{
			System.out.println(this.userService.existsUser(loginTry));
			System.out.println("------------------------LOGADO");
			return "list";
		}
		else
		{
			System.out.println("-----------------------ERRO");
			model.put("msg", "Invalid Login");
			
			return "index";
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) 
	{
		//model.put("title", applicationService.getTitle(""));
		model.addAttribute("loginTry", new User());
		//model.put("msg", helloWorldService.getDesc());
 
		return "list";
	}
}
