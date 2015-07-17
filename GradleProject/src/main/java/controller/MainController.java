package controller;
 
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.ApplicationService;
 
@Controller
public class MainController {
 
	private final Logger logger = Logger.getLogger(MainController.class);
	private final ApplicationService applicationService;
 
	@Autowired
	public MainController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
 
		logger.debug("index() is executed!");
 
		model.put("title", applicationService.getTitle(""));
		//model.put("msg", helloWorldService.getDesc());
 
		return "index";
	}
 
//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
// 
//		logger.debug("hello() is executed - name "+ name);
// 
//		ModelAndView model = new ModelAndView();
//		model.setViewName("index");
// 
//		model.addObject("title", helloWorldService.getTitle(name));
//	//	model.addObject("msg", helloWorldService.getDesc());
// 
//		return model;
// 
//	}
 
}