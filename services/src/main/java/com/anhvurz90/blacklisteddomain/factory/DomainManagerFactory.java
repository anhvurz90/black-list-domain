package com.anhvurz90.blacklisteddomain.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anhvurz90.blacklisteddomain.api.DomainManager;

public class DomainManagerFactory {
	public DomainManagerFactory() {}
	
	public DomainManager getDomainManager() {
		String domainStorage = System.getProperty("domainStorage");
		//Should be log here
		System.out.println("Domain Storage: " + domainStorage);
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		if ("dummy".equals(domainStorage)) 
			return (DomainManager)context.getBean("dummyDomainManager"); 
		else if ("file".equals(domainStorage))
		  return (DomainManager)context.getBean("fileDomainManager");
		else if ("hsql".equals(domainStorage))
		  return (DomainManager)context.getBean("hsqlDomainManager");
		return (DomainManager)context.getBean("fileDomainManager");
	}
}
