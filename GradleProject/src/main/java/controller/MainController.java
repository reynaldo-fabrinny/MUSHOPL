package controller;
 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Login;
import service.ApplicationService;
 
@Controller
public class MainController 
{ 
	private final ApplicationService applicationService;
 
	@Autowired
	public MainController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm(Model model) 
	{
		//model.put("title", applicationService.getTitle(""));
		model.addAttribute("loginTry", new Login());
		//model.put("msg", helloWorldService.getDesc());
 
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute Login loginTry, Model model) 
	{
		model.addAttribute("loginTry", loginTry);
		System.out.println(loginTry.getEmail()+ "  pegou o valor do user ");
		
		//model.put("msg", helloWorldService.getDesc());
 
		return "index";
	}

 
}