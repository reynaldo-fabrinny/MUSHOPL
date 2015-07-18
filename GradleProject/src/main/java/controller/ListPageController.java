package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;

//@Controller
public class ListPageController 
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm(Model model) 
	{
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute User loginTry, Model model) 
	{
		return "index";
	}
	
}
