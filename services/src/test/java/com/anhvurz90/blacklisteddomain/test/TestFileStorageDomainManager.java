package com.anhvurz90.blacklisteddomain.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anhvurz90.blacklisteddomain.api.DomainManager;

public class TestFileStorageDomainManager extends BaseTestDomainManager<DomainManager> {

	@Override
  protected void createDomainManager() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		domainManager_ = (DomainManager)context.getBean("fileDomainManager");
  }
	
}