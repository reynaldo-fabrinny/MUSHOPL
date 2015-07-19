package controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Item;
import model.User;
import service.UserService;
 
@Controller
public class LoginController 
{ 
	private UserService userService;
	private User loggedUser;
	
	//TODO ERASE
	private List<Item> dumpUserList = new ArrayList<Item>();
	
	 @Autowired(required=true)
	 @Qualifier(value="userService")
	 public void setUserService(UserService us)
	 {
		 this.userService = us;
	 }

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
		
		// PRESTAR ATENCAO NA LOGICA AQUIs
		if((this.loggedUser = this.userService.existsUser(loginTry)) != null )
		{
			System.out.println("------------------------LOGADO");
			return "list";
		}
		else
		{
			System.out.println("-----------------------ERRO");
			model.addAttribute("msg", "Invalid Login");
			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView listItems(Model model) 
	{
		model.addAttribute("items", dumpUserList);
		model.addAttribute("userName","rey");

		ModelAndView mv = new ModelAndView("list");
		return mv;
	}
	@RequestMapping("list")
	public String addItem(Item item) 
	{
		dumpUserList.add(item);
	   // JdbcTarefaDao dao = new JdbcTarefaDao();
	    //dao.adiciona(tarefa);
	    return "redirect:list";
	}
	
}
