package edu.ucar.cisl.ncarUsers.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class BeanFactory
{
	protected ApplicationContext ctx=null;
	static protected BeanFactory instance=null;
	
	protected BeanFactory ()
	{
		String [] paths={"applicationContext.xml"};
		ctx=new ClassPathXmlApplicationContext(paths);
		
	}
	static public BeanFactory getInstance()
	{
		if (instance == null)
			instance = new BeanFactory();
		return instance;
		
	}
	public Object getBean(String name)
	{
		return ctx.getBean(name);
	}

	
}