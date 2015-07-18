package service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService 
{
	public String getTitle(String name) 
	{
		System.out.println("Entrou no getTitle");
 
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
