package service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService 
{
	private static final Logger logger = Logger.getLogger(ApplicationService.class);
	 
	public String getDesc() 
	{
 
		logger.debug("getDesc() is executed!");
 
		return "Welcome to the Shopping list";
 
	}
	
	public String getTitle(String name) 
	{
		logger.debug("getTitle() is executed! name "+ name);
 
		if(StringUtils.isEmpty(name))
		{
			return "Welcome to the Shopping list";
		}
		else
		{
			return "Welcome to the Shopping list  " + name;
		}
 
	}
	
}
