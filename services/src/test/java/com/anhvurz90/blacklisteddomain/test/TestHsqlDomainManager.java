package com.anhvurz90.blacklisteddomain.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.factory.DomainManagerFactory;

public class TestHsqlDomainManager extends BaseTestDomainManager<DomainManager> {
	
	@Override
  protected void createDomainManager() {
		System.setProperty("domainStorage", "hsql");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DomainManagerFactory factory = (DomainManagerFactory)context.getBean("domainManagerFactory");
		domainManager_ = factory.getDomainManager();
  }

}